package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class MinMaxModelTest extends Setup {

    MinMaxModel subject = new MinMaxModel();

    @Test
    public void ok() {
        subject.value = 0;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        // null is OK
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failMin() {
        subject.value = -4;
        Set<ConstraintViolation<MinMaxModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<MinMaxModel> violation = violations.iterator().next();
        Assert.assertEquals("must be greater than or equal to -3", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Min.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }

    @Test
    public void failMax() {
        subject.value = 4;
        Set<ConstraintViolation<MinMaxModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<MinMaxModel> violation = violations.iterator().next();
        Assert.assertEquals("must be less than or equal to 3", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Max.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }
}
