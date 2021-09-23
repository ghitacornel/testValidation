package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class AssertTrueModelTest extends Setup {

    AssertTrueModel subject = new AssertTrueModel();

    @Test
    public void ok() {
        subject.property = true;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void fail() {
        subject.property = false;
        Set<ConstraintViolation<AssertTrueModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<AssertTrueModel> violation = violations.iterator().next();
        Assert.assertEquals("must be true", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.AssertTrue.message}", violation.getMessageTemplate());
        Assert.assertEquals("object", violation.getPropertyPath().toString());
    }
}
