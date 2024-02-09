package shop.anmachair.reservationchair.dtos;

import java.time.LocalDateTime;

public record ReservationSummaryDto(
        Integer reservationId,
        Integer userId,
        Integer chairId,
        LocalDateTime reservationDateTime,
        LocalDateTime createdAt
) {
}
