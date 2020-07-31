package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class PatternModelTest extends Setup {

    PatternModel subject = new PatternModel();

    @Test
    public void ok() {
        subject.value = "aaa_bbb@ccc-ddd.com";
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        // null is OK
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failPattern() {
        subject.value = "aaa#_bbb@ccc-ddd.com";
        Set<ConstraintViolation<PatternModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<PatternModel> violation = violations.iterator().next();
        Assert.assertEquals("must match \"^[A-Za-z0-9+_.-]+@(.+)$\"", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Pattern.message}", violation.getMessageTemplate());
        Assert.assertEquals("value", violation.getPropertyPath().toString());
    }

}
