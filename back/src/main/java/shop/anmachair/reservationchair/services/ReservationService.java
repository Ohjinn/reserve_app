package shop.anmachair.reservationchair.services;

import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.dtos.ReservationRequestDto;
import shop.anmachair.reservationchair.dtos.ReservationSummaryDto;
import shop.anmachair.reservationchair.dtos.ReservationListDto;
import shop.anmachair.reservationchair.models.Chair;
import shop.anmachair.reservationchair.models.Location;
import shop.anmachair.reservationchair.models.Reservation;
import shop.anmachair.reservationchair.models.User;
import shop.anmachair.reservationchair.repositories.ChairRepository;
import shop.anmachair.reservationchair.repositories.LocationRepository;
import shop.anmachair.reservationchair.repositories.ReservationRepository;
import shop.anmachair.reservationchair.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final ChairRepository chairRepository;
    private final LocationRepository locationRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, ChairRepository chairRepository, LocationRepository locationRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.chairRepository = chairRepository;
        this.locationRepository = locationRepository;
    }

    public ReservationListDto getReservationList(String userId) {
        return new ReservationListDto(reservationRepository.findByUserIdLeftJoinLocationChair(userId));
    }

    public Integer createReservation(String userId, ReservationRequestDto reservationRequestDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);

        Chair chair = chairRepository.findById(reservationRequestDto.chairId())
                .orElseThrow(NoSuchElementException::new);

        Location location = locationRepository.findById(reservationRequestDto.locationId())
                .orElseThrow(NoSuchElementException::new);

        LocalDateTime now = LocalDateTime.now();

        // TODO: 유저가 해당 시간에 예약했는지 확인하는 로직 추가 필요

        Reservation reservation = new Reservation.Builder()
                .reservationDateTime(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), reservationRequestDto.hour(), reservationRequestDto.minute()))
                .user(user)
                .location(location)
                .chair(chair)
                .build();

        return reservationRepository.save(reservation).getId();
    }

    public Integer deleteReservation(Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(NoSuchElementException::new);

        reservationRepository.delete(reservation);

        return reservationId;
    }
}
