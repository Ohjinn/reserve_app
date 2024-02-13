package shop.anmachair.reservationchair.services;

import io.hypersistence.tsid.TSID;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.controllers.UserController;
import shop.anmachair.reservationchair.exceptions.UserAlreadyExistsException;
import shop.anmachair.reservationchair.utils.AccessTokenGenerator;
import shop.anmachair.reservationchair.utils.UserDetailsDao;


@Service
@Transactional
public class SignupService {
    private final AccessTokenGenerator accessTokenGenerator;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsDao userDetailsDao;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    public SignupService(AccessTokenGenerator accessTokenGenerator,
                         PasswordEncoder passwordEncoder,
                         UserDetailsDao userDetailsDao) {
        this.accessTokenGenerator = accessTokenGenerator;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsDao = userDetailsDao;
    }

    public String signup(String username, String password) {
        if (userDetailsDao.existsByUsername(username)) {
            throw new UserAlreadyExistsException();
        }

        String id = TSID.Factory.getTsid().toString();
        String encodedPassword = passwordEncoder.encode(password);
        String accessToken = accessTokenGenerator.generate(id);

        log.error("id" + id);
        userDetailsDao.addUser(id, username, encodedPassword);
        userDetailsDao.addAccessToken(id, accessToken);

        return accessToken;
    }
}