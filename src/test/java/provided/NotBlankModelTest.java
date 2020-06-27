package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NotBlankModelTest extends Setup {

    NotBlankModel subject = new NotBlankModel();

    @Test
    public void ok() {
        subject.text = "1";
    }

    @Test
    public void failEmptyString() {
        subject.text = "    ";
        Set<ConstraintViolation<NotBlankModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotBlankModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be blank", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotBlank.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

    @Test
    public void failNullString() {
        subject.text = null;
        Set<ConstraintViolation<NotBlankModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotBlankModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be blank", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotBlank.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

}
