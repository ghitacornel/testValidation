package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.*;

public class EmailWithOverriddenCustomMessageModelTest extends Setup {

    EmailWithOverriddenCustomMessageModel subject = new EmailWithOverriddenCustomMessageModel();

    @Test
    public void ok() {
        subject.email = "aaa@bbb.com";
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        subject.email = null;
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void fail() {

        subject.email = "aaa";

        Set<ConstraintViolation<EmailWithOverriddenCustomMessageModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<EmailWithOverriddenCustomMessageModel> violation = violations.iterator().next();
        Assert.assertEquals("'aaa' must be a well-formed email address", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Email.message}", violation.getMessageTemplate());
        Assert.assertEquals("email", violation.getPropertyPath().toString());
    }

}
