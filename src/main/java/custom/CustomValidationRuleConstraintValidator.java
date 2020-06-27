package custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidationRuleConstraintValidator implements ConstraintValidator<CustomValidationRule, String> {

    @Override
    public void initialize(CustomValidationRule constraintAnnotation) {
        // do nothing
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return value.equals("top order") || value.equals("low order");
    }
}
