package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserId(Integer userId);

    Optional<Reservation> findById(Integer reservationId);
}
