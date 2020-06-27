package provided;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Map;

public class SizeModel {

    @Size(min = 3, max = 6)
    String text;

    @Size(min = 3, max = 6)
    Collection<Integer> objects;

    @Size(min = 3, max = 6)
    Map<?, ?> map;

    @Size(min = 3, max = 6)
    int[] array;

}
