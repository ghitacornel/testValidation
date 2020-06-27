package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class NotNullModelTest extends Setup {

    NotNullModel subject = new NotNullModel();

    @Test
    public void ok() {
        subject.object = new Object();
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void fail() {
        subject.object = null;
        Set<ConstraintViolation<NotNullModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotNullModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be null", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
        Assert.assertEquals("object", violation.getPropertyPath().toString());
    }
}
