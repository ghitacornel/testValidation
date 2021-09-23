package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class AssertFalseModelTest extends Setup {

    AssertFalseModel subject = new AssertFalseModel();

    @Test
    public void ok() {
        subject.property = false;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void fail() {
        subject.property = true;
        Set<ConstraintViolation<AssertFalseModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<AssertFalseModel> violation = violations.iterator().next();
        Assert.assertEquals("must be false", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.AssertFalse.message}", violation.getMessageTemplate());
        Assert.assertEquals("object", violation.getPropertyPath().toString());
    }
}
