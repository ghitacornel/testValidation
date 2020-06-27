package model;

import validators.OrderType;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ValidModel extends ValidParent {

    @Min(1)
    @Max(6)
    private int intValue = 2;

    @Size(min = 3, max = 5)
    private String stringValue = "abcd";

    @Size(min = 3, max = 5)
    private List<String> list = Arrays.asList("a", "b", "c", "d");

    @Past
    private Date pastDate = new Date(new Date().getTime() - 1000000);

    @Future
    private Date futureDate = new Date(new Date().getTime() + 1000000);

    @DecimalMax("1000")
    @DecimalMin("10")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal decimal = new BigDecimal("100.1");

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Pattern(regexp = EMAIL_PATTERN)
    private String pattern = "aaa@bbb.com";

    @Valid
    private ValidInnerModel validInnerModel = new ValidInnerModel();

    @Valid
    private List<ValidComponent> components = new ArrayList<ValidComponent>();

    {
        components.add(new ValidComponent());
        components.add(new ValidComponent());
        components.add(new ValidComponent());
    }

    @OrderType
    private String orderType;

    // email with overridden default message
    @Email
    private String email = "aaa@bbb.com";

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Date getPastDate() {
        return pastDate;
    }

    public void setPastDate(Date pastDate) {
        this.pastDate = pastDate;
    }

    public Date getFutureDate() {
        return futureDate;
    }

    public void setFutureDate(Date futureDate) {
        this.futureDate = futureDate;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public ValidInnerModel getValidInnerModel() {
        return validInnerModel;
    }

    public void setValidInnerModel(ValidInnerModel validInnerModel) {
        this.validInnerModel = validInnerModel;
    }

    public List<ValidComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ValidComponent> components) {
        this.components = components;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
