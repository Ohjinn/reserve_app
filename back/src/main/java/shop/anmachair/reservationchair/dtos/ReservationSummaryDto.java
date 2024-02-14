package shop.anmachair.reservationchair.dtos;

import java.time.LocalDateTime;

public record ReservationSummaryDto(
        Integer reservationId,
        String userId,
        String chairName,
        String locationName,
        LocalDateTime reservationDateTime,
        LocalDateTime createdAt
) {
}
