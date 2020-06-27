package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.Set;

public class PastFutureModelTest extends Setup {

    PastFutureModel subject = new PastFutureModel();

    @Test
    public void ok() {
        subject.past = LocalDateTime.now().minusDays(1);
        subject.future = LocalDateTime.now().plusDays(1);
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failPast() {
        subject.past = LocalDateTime.now().plusDays(1);
        Set<ConstraintViolation<PastFutureModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<PastFutureModel> violation = violations.iterator().next();
        Assert.assertEquals("must be a past date", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Past.message}", violation.getMessageTemplate());
        Assert.assertEquals("past", violation.getPropertyPath().toString());
    }

    @Test
    public void failFuture() {
        subject.future = LocalDateTime.now().minusDays(1);
        Set<ConstraintViolation<PastFutureModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<PastFutureModel> violation = violations.iterator().next();
        Assert.assertEquals("must be a future date", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Future.message}", violation.getMessageTemplate());
        Assert.assertEquals("future", violation.getPropertyPath().toString());
    }
}
