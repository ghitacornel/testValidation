package provided;

import org.junit.Assert;
import org.junit.Test;
import tests.setup.Setup;

import javax.validation.ConstraintViolation;
import java.util.*;

public class NotemptyModelTest extends Setup {

    NotEmptyModel subject = new NotEmptyModel();

    @Test
    public void ok() {
        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failString() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.text = "";
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

    @Test
    public void failNullString() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.text = null;
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("text", violation.getPropertyPath().toString());
    }

    @Test
    public void failObjects() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.objects = new ArrayList<>();
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("objects", violation.getPropertyPath().toString());
    }

    @Test
    public void failNullObjects() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.objects = null;
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("objects", violation.getPropertyPath().toString());
    }

    @Test
    public void failMap() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.map = new HashMap<>();
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("map", violation.getPropertyPath().toString());
    }

    @Test
    public void failNullMap() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.map = null;
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("map", violation.getPropertyPath().toString());
    }

    @Test
    public void failArray() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.array = new int[]{};
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("array", violation.getPropertyPath().toString());
    }

    @Test
    public void failNullArray() {

        subject.text = "1";
        subject.objects = List.of(1);
        subject.map = Map.of(1, "1");
        subject.array = new int[1];

        subject.array = null;
        Set<ConstraintViolation<NotEmptyModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<NotEmptyModel> violation = violations.iterator().next();
        Assert.assertEquals("must not be empty", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.NotEmpty.message}", violation.getMessageTemplate());
        Assert.assertEquals("array", violation.getPropertyPath().toString());
    }

}
