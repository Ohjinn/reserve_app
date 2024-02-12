package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.dtos.ChairSummaryDto;
import shop.anmachair.reservationchair.dtos.TimeSummaryDto;
import shop.anmachair.reservationchair.models.Location;

import java.time.LocalTime;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<TimeSummaryDto> findAvailableTimeList(Integer locationId);


    List<ChairSummaryDto> findAvailableChairList(Integer locationId, LocalTime convertedTime);
}
