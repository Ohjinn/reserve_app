package shop.anmachair.reservationchair.repositories.customRepository;

import shop.anmachair.reservationchair.dtos.TimeSummaryDto;

import java.util.List;

public interface LocationRepositoryCustom {
    List<TimeSummaryDto> findAvailableTimeList(Integer locationId);
}
