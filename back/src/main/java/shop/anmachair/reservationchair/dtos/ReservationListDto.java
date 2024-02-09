package shop.anmachair.reservationchair.dtos;

import java.util.List;

public record ReservationListDto(
        List<ReservationSummaryDto> reservations
) {
}
