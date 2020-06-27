package provided;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public class PastFutureModel {

    @Past
    LocalDateTime past;

    @Future
    LocalDateTime future;

}
