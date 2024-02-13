package shop.anmachair.reservationchair.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.utils.UserDetailsDao;

@Service
@Transactional
public class LogoutService {
    private final UserDetailsDao userDetailsDao;

    public LogoutService(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    public void logout(String accessToken) {
        userDetailsDao.removeAccessToken(accessToken);
    }
}