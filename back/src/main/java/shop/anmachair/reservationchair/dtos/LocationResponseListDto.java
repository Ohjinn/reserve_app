package shop.anmachair.reservationchair.dtos;

import java.util.List;

public record LocationResponseListDto(
        List<LocationSummaryDto> locationSummaryDto
) {
}
