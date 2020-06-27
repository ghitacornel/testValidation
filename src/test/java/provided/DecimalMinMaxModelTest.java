package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class DecimalMinMaxModelTest extends Setup {

    DecimalMinMaxModel subject = new DecimalMinMaxModel();

    @Test
    public void ok() {
        subject.value = new BigDecimal(0);
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failMin() {
        subject.value = new BigDecimal("-9123456789123456789123456789123456789");
        Set<ConstraintViolation<DecimalMinMaxModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<DecimalMinMaxModel> violation = violations.iterator().next();
        Assert.assertEquals("must be greater than or equal to -123456789123456789123456789123456789.123456789123456789123456789123456789", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.DecimalMin.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }

    @Test
    public void failMax() {
        subject.value = new BigDecimal("+9123456789123456789123456789123456789");
        Set<ConstraintViolation<DecimalMinMaxModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<DecimalMinMaxModel> violation = violations.iterator().next();
        Assert.assertEquals("must be less than or equal to +123456789123456789123456789123456789.123456789123456789123456789123456789", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.DecimalMax.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }
}
