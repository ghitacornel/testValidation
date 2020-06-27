package provided;

import javax.validation.constraints.*;

public class NegativeZeroPositiveModel {

    @Negative
    Integer negative;

    @NegativeOrZero
    Integer negativeOrZero;

    @Positive
    Integer positive;

    @PositiveOrZero
    Integer positiveOrZero;

}
