package shop.anmachair.reservationchair.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record ReservationRequestDto(

        @Min(0)
        Integer locationId,

        @Min(0)
        Integer chairId,

        @Max(59)
        @Min(0)
        Integer minute,

        @Max(18)
        @Min(9)
        Integer hour
) {
}
