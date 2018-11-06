package validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderTypeValidator implements ConstraintValidator<OrderType, String> {

    @Override
    public void initialize(OrderType constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return value.equals("top order") || value.equals("low order");
    }
}
