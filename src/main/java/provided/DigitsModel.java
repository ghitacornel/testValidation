package provided;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class DigitsModel {

    @Digits(integer = 36, fraction = 37)
    BigDecimal value;

}
