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

    @Size(min = 3, max = 5)
    private String stringValue = "abcd";

    @Size(min = 3, max = 5)
    private List<String> list = Arrays.asList("a", "b", "c", "d");

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

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
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
