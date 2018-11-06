package model;

import validators.OrderType;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
