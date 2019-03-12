package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ValidParent {

    @Min(1)
    @Max(6)
    private int parentIntValue = 2;

    public int getParentIntValue() {
        return parentIntValue;
    }

    public void setParentIntValue(int parentIntValue) {
        this.parentIntValue = parentIntValue;
    }
}
