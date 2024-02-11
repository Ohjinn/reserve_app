package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
