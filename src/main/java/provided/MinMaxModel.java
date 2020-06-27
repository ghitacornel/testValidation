package provided;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MinMaxModel {

    @Min(-3)
    @Max(3)
    Integer value;

}
