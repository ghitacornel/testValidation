package provided;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class DecimalMinMaxModel {

    @DecimalMin("-123456789123456789123456789123456789.123456789123456789123456789123456789")
    @DecimalMax("+123456789123456789123456789123456789.123456789123456789123456789123456789")
    BigDecimal value;

}
