package shop.anmachair.reservationchair.repositories.customRepository;

import shop.anmachair.reservationchair.dtos.ChairSummaryDto;
import shop.anmachair.reservationchair.dtos.TimeSummaryDto;

import java.time.LocalTime;
import java.util.List;

public interface LocationRepositoryCustom {
    List<TimeSummaryDto> findAvailableTimeList(Integer locationId);

    List<ChairSummaryDto> findAvailableChairList(Integer locationId, LocalTime convertedTime);
}
