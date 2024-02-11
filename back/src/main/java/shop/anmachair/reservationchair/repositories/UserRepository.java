package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
