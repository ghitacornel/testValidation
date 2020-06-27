package provided;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import java.time.*;
import java.util.Set;

public class PastFutureOrPresentWithClockProviderModelTest {

    PastFutureOrPresentWithClockProviderModel subject = new PastFutureOrPresentWithClockProviderModel();

    private static class MyClockProvider implements ClockProvider {

        Clock clock = null;

        @Override
        public Clock getClock() {
            return clock;
        }
    }

    Instant referenceDate = Instant.now();
    MyClockProvider myClockProvider = new MyClockProvider();
    ValidatorFactory factory;
    Validator validator;

    @Before
    public void setUp() {
        factory = Validation.byDefaultProvider().configure().clockProvider(myClockProvider).buildValidatorFactory();
        validator = factory.getValidator();
//        myClockProvider.clock = Clock.systemDefaultZone();
        myClockProvider.clock = new Clock() {
            @Override
            public ZoneId getZone() {
                return ZoneOffset.ofHoursMinutes(0, 0);
            }

            @Override
            public Clock withZone(ZoneId zone) {
                return this;
            }

            @Override
            public Instant instant() {
                return referenceDate;
            }
        };
    }

    @Test
    public void ok() {
        subject.pastOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).minusDays(1);
        subject.futureOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).plusDays(1);
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okPresent() {
        subject.pastOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).minusDays(1);
        subject.futureOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).plusDays(1);
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void okNull() {
        Assert.assertTrue(validator.validate(subject).isEmpty());
    }

    @Test
    public void failPast() {
        subject.pastOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).plusDays(1);
        Set<ConstraintViolation<PastFutureOrPresentWithClockProviderModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<PastFutureOrPresentWithClockProviderModel> violation = violations.iterator().next();
        Assert.assertEquals("must be a date in the past or in the present", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.PastOrPresent.message}", violation.getMessageTemplate());
        Assert.assertEquals("pastOrPresent", violation.getPropertyPath().toString());
    }

    @Test
    public void failFuture() {
        subject.futureOrPresent = LocalDateTime.ofInstant(referenceDate, ZoneOffset.ofHoursMinutes(0, 0)).minusDays(1);
        Set<ConstraintViolation<PastFutureOrPresentWithClockProviderModel>> violations = validator.validate(subject);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<PastFutureOrPresentWithClockProviderModel> violation = violations.iterator().next();
        Assert.assertEquals("must be a date in the present or in the future", violation.getMessage());
        Assert.assertEquals("{javax.validation.constraints.FutureOrPresent.message}", violation.getMessageTemplate());
        Assert.assertEquals("futureOrPresent", violation.getPropertyPath().toString());
    }

}
