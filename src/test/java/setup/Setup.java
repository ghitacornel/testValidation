package setup;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Setup {

    // usually a SINGLETON
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    // thread safe
    protected final Validator validator = factory.getValidator();

}
