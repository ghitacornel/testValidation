package provided;

import org.junit.Assert;
import org.junit.Test;
import setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SizeModelTest extends Setup {

    SizeModel subject = new SizeModel();

    @Test
    public void ok() {
        subject.text = "123";
        subject.objects = List.of(1, 2, 3);
        subject.map = Map.of(1, "1", 2, "2", 3, "3");
        subject.array = new int[3];
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        // null is OK
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failMinString() {
        subject.text = "12";
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

    @Test
    public void failMaxString() {
        subject.text = "1234567";
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

    @Test
    public void failMinObjects() {
        subject.objects = List.of(1, 2);
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("objects", violation.getPropertyPath().toString());
    }

    @Test
    public void failMaxObjects() {
        subject.objects = List.of(1, 2, 3, 4, 5, 6, 7);
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("objects", violation.getPropertyPath().toString());
    }

    @Test
    public void failMinMap() {
        subject.map = Map.of(1, "1", 2, "2");
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("map", violation.getPropertyPath().toString());
    }

    @Test
    public void failMaxMap() {
        subject.map = Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7");
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("map", violation.getPropertyPath().toString());
    }

    @Test
    public void failMinArray() {
        subject.array = new int[]{1, 2};
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("array", violation.getPropertyPath().toString());
    }

    @Test
    public void failMaxArray() {
        subject.array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("size must be between 3 and 6", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
        Assert.assertEquals("array", violation.getPropertyPath().toString());
    }

    @Test
    public void failCustomText() {
        subject.customText = "ab";
        Set<ConstraintViolation<SizeModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<SizeModel> violation = violations.iterator().next();
        Assert.assertEquals("'ab' value must be of length between 3 and 6", violation.getMessage());
        Assert.assertEquals("'${validatedValue}' value must be of length between {min} and {max}", violation.getMessageTemplate());
        Assert.assertEquals("customText", violation.getPropertyPath().toString());
    }
}
