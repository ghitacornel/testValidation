package containment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Model extends ParentModel {

    @NotNull
    Object childProperty = new Object();

    @Valid
    SingleComponent component = new SingleComponent();

    @Valid
    List<CollectionComponent> components = new ArrayList<>();

    {
        components.add(new CollectionComponent());
        components.add(new CollectionComponent());
        components.add(new CollectionComponent());
    }

}
