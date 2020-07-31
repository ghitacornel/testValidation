package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class DigitsModelTest extends Setup {

    DigitsModel subject = new DigitsModel();

    @Test
    public void ok() {
        subject.value = new BigDecimal("123456789123456789123456789123456789.1234567891234567891234567891234567891");
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failInteger() {
        subject.value = new BigDecimal("1234567891234567891234567891234567891.1234567891234567891234567891234567891");
        Set<ConstraintViolation<DigitsModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<DigitsModel> violation = violations.iterator().next();
        Assert.assertEquals("numeric value out of bounds (<36 digits>.<37 digits> expected)", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Digits.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }

    @Test
    public void failFraction() {
        subject.value = new BigDecimal("123456789123456789123456789123456789.12345678912345678912345678912345678912");
        Set<ConstraintViolation<DigitsModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<DigitsModel> violation = violations.iterator().next();
        Assert.assertEquals("numeric value out of bounds (<36 digits>.<37 digits> expected)", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Digits.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }
}
