package shop.anmachair.reservationchair.services;

import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.dtos.ReservationSummaryDto;
import shop.anmachair.reservationchair.dtos.ReservationListDto;
import shop.anmachair.reservationchair.repositories.ReservationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationListDto getReservationList(Integer userId) {
        List<ReservationSummaryDto> reservations = reservationRepository.findByUserId(userId)
                .stream()
                .map(reservation -> new ReservationSummaryDto(
                        reservation.getId(),
                        reservation.getUser().getId(),
                        reservation.getChair().getId(),
                        reservation.getReservationDateTime(),
                        reservation.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return new ReservationListDto(reservations);
    }
}
