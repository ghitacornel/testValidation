package setup;

import org.junit.Before;
import org.junit.BeforeClass;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Setup {

    // usually a SINGLETON
    private static ValidatorFactory factory;

    // usually a PROTOTYPE or ThreadLocal
    protected Validator validator;

    @BeforeClass
    static public void beforeAll() {
        factory = Validation.buildDefaultValidatorFactory();
    }

    /**
     * HAD TO RECREATE THE VALIDATOR BEFORE EACH TEST<br>
     * LOOKS LIKE THIS VALIDATOR IS NOT SO THREAD SAFE
     */
    @Before
    public void before() {

        // should be thread safe
        validator = factory.getValidator();

    }

}
