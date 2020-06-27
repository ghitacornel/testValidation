package provided;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Map;

public class NotEmptyModel {

    @NotEmpty
    String text;

    @NotEmpty
    Collection<Integer> objects;

    @NotEmpty
    Map<?, ?> map;

    @NotEmpty
    int[] array;

}
