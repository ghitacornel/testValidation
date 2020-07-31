package custom;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.*;

public class CustomValidationRuleModelTest extends Setup {

    CustomValidationRuleModel subject = new CustomValidationRuleModel();

    @Test
    public void ok() {

        subject.orderType = "top order";
        Assert.assertTrue(validator.validate(subject).isEmpty());

        subject.orderType = "low order";
        Assert.assertTrue(validator.validate(subject).isEmpty());

    }

    @Test
    public void fail() {

        subject.orderType = "xxx";
        Set<ConstraintViolation<CustomValidationRuleModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<CustomValidationRuleModel> violation = violations.iterator().next();
        Assert.assertEquals("bad order, accepted 'top order' or 'low order'", violation.getMessage());
        Assert.assertEquals("{my.custom.validation.rule.OrderType.message}", violation.getMessageTemplate());
        Assert.assertEquals("orderType", violation.getPropertyPath().toString());
    }

}
