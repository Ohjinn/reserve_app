package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.models.Chair;

public interface ChairRepository extends JpaRepository<Chair, Integer> {
}
