package tests;

import model.ValidModel;
import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class TestValidModel extends Setup {

    @Test
    public void testValidModel() {

        ValidModel model = new ValidModel();

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertTrue(violations.isEmpty());

    }

    @Test
    public void testNonValidCustomValidatorModel() {

        ValidModel model = new ValidModel();
        model.setOrderType("bad order");

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ValidModel> violation = violations.iterator().next();
        Assert.assertEquals("orderType", violation.getPropertyPath().toString());
        Assert.assertEquals("bad order, accepted 'top order' or 'low order'", violation.getMessage());

    }

    @Test
    public void testNonValidInnerModel() {

        ValidModel model = new ValidModel();
        model.getValidInnerModel().setBooleanTrue(false);

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ValidModel> violation = violations.iterator().next();
        Assert.assertEquals("validInnerModel.booleanTrue", violation.getPropertyPath().toString());
    }

    @Test
    public void testNonValidModelAndInnerModel() {

        ValidModel model = new ValidModel();
        model.getValidInnerModel().setBooleanTrue(false);

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());

    }

    @Test
    public void testNonValidComponents() {

        ValidModel model = new ValidModel();
        model.getComponents().get(1).setBooleanTrue(false);

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ValidModel> violation = violations.iterator().next();
        Assert.assertEquals("components[1].booleanTrue", violation.getPropertyPath().toString());
    }

    @Test
    public void testNonValidParent() {

        ValidModel model = new ValidModel();
        model.setParentIntValue(-100);

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ValidModel> violation = violations.iterator().next();
        Assert.assertEquals("parentIntValue", violation.getPropertyPath().toString());
    }

    @Test
    public void testNonValidEmail() {

        ValidModel model = new ValidModel();
        model.setEmail("xxx");

        Set<ConstraintViolation<ValidModel>> violations = validator.validate(model);

        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ValidModel> violation = violations.iterator().next();
        Assert.assertEquals("email", violation.getPropertyPath().toString());
        Assert.assertEquals("'xxx' must be a well-formed email address", violation.getMessage());
    }

}
