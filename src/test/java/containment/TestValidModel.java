package containment;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class TestValidModel extends Setup {

    @Test
    public void testParentModel_OK() {
        ParentModel model = new ParentModel();
        Assert.assertTrue(validator.validate(model).isEmpty());
    }

    @Test
    public void testParentModel_FAIL() {
        ParentModel model = new ParentModel();
        model.parentProperty = null;
        Set<ConstraintViolation<ParentModel>> violations = validator.validate(model);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<ParentModel> violation = violations.iterator().next();
        Assert.assertEquals("parentProperty", violation.getPropertyPath().toString());
    }

    @Test
    public void testModel_OK() {
        Model model = new Model();
        Assert.assertTrue(validator.validate(model).isEmpty());
    }

    @Test
    public void testModel_FAIL() {

        {// parent property fail
            Model model = new Model();
            model.parentProperty = null;
            Set<ConstraintViolation<Model>> violations = validator.validate(model);
            Assert.assertEquals(1, violations.size());
            ConstraintViolation<Model> violation = violations.iterator().next();
            Assert.assertEquals("parentProperty", violation.getPropertyPath().toString());
            Assert.assertEquals(model, violation.getLeafBean());
            Assert.assertEquals(model, violation.getRootBean());
        }

        {// child property fail
            Model model = new Model();
            model.childProperty = null;
            Set<ConstraintViolation<Model>> violations = validator.validate(model);
            Assert.assertEquals(1, violations.size());
            ConstraintViolation<Model> violation = violations.iterator().next();
            Assert.assertEquals("childProperty", violation.getPropertyPath().toString());
            Assert.assertEquals(model, violation.getLeafBean());
            Assert.assertEquals(model, violation.getRootBean());
        }

        {// single component property fail
            Model model = new Model();
            model.component.singleComponentProperty = null;
            Set<ConstraintViolation<Model>> violations = validator.validate(model);
            Assert.assertEquals(1, violations.size());
            ConstraintViolation<Model> violation = violations.iterator().next();
            Assert.assertEquals("component.singleComponentProperty", violation.getPropertyPath().toString());
            Assert.assertEquals(model.component, violation.getLeafBean());
            Assert.assertEquals(model, violation.getRootBean());
        }

        {// collection component property fail
            Model model = new Model();
            model.components.get(1).collectionComponentProperty = null;
            Set<ConstraintViolation<Model>> violations = validator.validate(model);
            Assert.assertEquals(1, violations.size());
            ConstraintViolation<Model> violation = violations.iterator().next();
            Assert.assertEquals("components[1].collectionComponentProperty", violation.getPropertyPath().toString());
            Assert.assertEquals(model.components.get(1), violation.getLeafBean());
            Assert.assertEquals(model, violation.getRootBean());
        }

    }

}
