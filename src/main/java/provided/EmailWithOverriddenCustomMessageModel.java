package provided;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Map;

public class EmailWithOverriddenCustomMessageModel {

    @Email
    String email;

}
