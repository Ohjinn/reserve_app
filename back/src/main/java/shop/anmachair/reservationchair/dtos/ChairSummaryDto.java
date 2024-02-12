package shop.anmachair.reservationchair.dtos;

public record ChairSummaryDto(
        Integer chairId,
        String chairName,
        Boolean possible
) {
}
