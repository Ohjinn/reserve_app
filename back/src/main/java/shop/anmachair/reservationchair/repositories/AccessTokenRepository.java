package shop.anmachair.reservationchair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.anmachair.reservationchair.models.AccessToken;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {
}
