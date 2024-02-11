package shop.anmachair.reservationchair.dtos;

import java.time.LocalTime;

public record TimeSummaryDto(
        LocalTime time,
        Boolean possible
) {
}
