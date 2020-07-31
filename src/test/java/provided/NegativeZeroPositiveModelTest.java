package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class NegativeZeroPositiveModelTest extends Setup {

    NegativeZeroPositiveModel subject = new NegativeZeroPositiveModel();

    @Test
    public void ok() {
        subject.negative = -1;
        subject.negativeOrZero = 0;
        subject.positive = 1;
        subject.positiveOrZero = 0;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        // null is OK
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failNegative() {
        subject.negative = 0;
        Set<ConstraintViolation<NegativeZeroPositiveModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NegativeZeroPositiveModel> violation = violations.iterator().next();
        Assert.assertEquals("must be less than 0", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Negative.message}", violation.getMessageTemplate());
        Assert.assertEquals("negative", violation.getPropertyPath().toString());
    }

    @Test
    public void failPositive() {
        subject.positive = 0;
        Set<ConstraintViolation<NegativeZeroPositiveModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NegativeZeroPositiveModel> violation = violations.iterator().next();
        Assert.assertEquals("must be greater than 0", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Positive.message}", violation.getMessageTemplate());
        Assert.assertEquals("positive", violation.getPropertyPath().toString());
    }

    @Test
    public void failNegativeOrZero() {
        subject.negativeOrZero = 1;
        Set<ConstraintViolation<NegativeZeroPositiveModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NegativeZeroPositiveModel> violation = violations.iterator().next();
        Assert.assertEquals("must be less than or equal to 0", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NegativeOrZero.message}", violation.getMessageTemplate());
        Assert.assertEquals("negativeOrZero", violation.getPropertyPath().toString());
    }

    @Test
    public void failPositiveOrZero() {
        subject.positiveOrZero = -1;
        Set<ConstraintViolation<NegativeZeroPositiveModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NegativeZeroPositiveModel> violation = violations.iterator().next();
        Assert.assertEquals("must be greater than or equal to 0", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.PositiveOrZero.message}", violation.getMessageTemplate());
        Assert.assertEquals("positiveOrZero", violation.getPropertyPath().toString());
    }
}
