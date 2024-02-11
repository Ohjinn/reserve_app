package shop.anmachair.reservationchair.dtos;

import java.util.List;

public record TimeListDto(
        List<TimeSummaryDto> timeSummaryDtoList
) {
}
