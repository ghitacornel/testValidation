package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class NullModelTest extends Setup {

    NullModel subject = new NullModel();

    @Test
    public void ok() {
        subject.object = null;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void fail() {
        subject.object = new Object();
        Set<ConstraintViolation<NullModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NullModel> violation = violations.iterator().next();
        Assert.assertEquals("must be null", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Null.message}", violation.getMessageTemplate());
        Assert.assertEquals("object", violation.getPropertyPath().toString());
    }
}
