package tests.setup;

import org.junit.Before;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Setup {

    private ValidatorFactory factory;
    protected Validator validator;

    /**
     * HAD TO RECREATE THE VALIDATOR BEFORE EACH TEST<br>
     * LOOKS LIKE THIS VALIDATOR IS NOT SO THREAD SAFE
     */
    @Before
    public void before() {

        // should be created once
        factory = Validation.buildDefaultValidatorFactory();

        // should be thread safe
        validator = factory.getValidator();

    }

}
