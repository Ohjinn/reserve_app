package shop.anmachair.reservationchair.dtos;

import java.util.List;

public record ChairListDto(
        List<ChairSummaryDto> chairSummaryDto
) {
}
