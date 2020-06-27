package provided;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class PastFutureOrPresentWithClockProviderModel {

    @PastOrPresent
    LocalDateTime pastOrPresent;

    @FutureOrPresent
    LocalDateTime futureOrPresent;

}
