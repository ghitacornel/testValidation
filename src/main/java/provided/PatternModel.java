package provided;

import javax.validation.constraints.Pattern;

public class PatternModel {

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    String value;

}
