package shop.anmachair.reservationchair.repositories.customRepository;

import shop.anmachair.reservationchair.dtos.ReservationSummaryDto;

import java.util.List;

public interface ReservationRepositoryCustom {

    List<ReservationSummaryDto> findByUserIdLeftJoinLocationChair(String userId);
}
