package shop.anmachair.reservationchair.services;

import jakarta.transaction.Transactional;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.dtos.LoginResultDto;
import shop.anmachair.reservationchair.models.AccessToken;
import shop.anmachair.reservationchair.models.User;
import shop.anmachair.reservationchair.repositories.AccessTokenRepository;
import shop.anmachair.reservationchair.repositories.UserRepository;
import shop.anmachair.reservationchair.utils.AccessTokenGenerator;
import shop.anmachair.reservationchair.utils.UserDetailsDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginService {
    private final AccessTokenGenerator accessTokenGenerator;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsDao userDetailsDao;
    private final AccessTokenRepository accessTokenRepository;

    public LoginService(AccessTokenGenerator accessTokenGenerator,
                        PasswordEncoder passwordEncoder,
                        UserDetailsDao userDetailsDao, AccessTokenRepository accessTokenRepository) {
        this.accessTokenGenerator = accessTokenGenerator;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsDao = userDetailsDao;
        this.accessTokenRepository = accessTokenRepository;
    }

    public LoginResultDto login(String username, String password) {
        return userDetailsDao.findByUsername(username)
                .filter(userDetails -> passwordEncoder.matches(
                        password, userDetails.getPassword()))
                .map(userDetails -> {
                    String userId = userDetails.getUsername();

                    // 이미 로그인 되어있는지 확인
                    Optional<AccessToken> token = accessTokenRepository.findById(userId);

                    List<GrantedAuthority> userRoles = new ArrayList<>(userDetails.getAuthorities());
                    List<String> roles = userRoles.stream().map((GrantedAuthority::getAuthority)).toList();

                    String accessToken = "";
                    if (token.isEmpty()) {
                        accessToken = accessTokenGenerator.generate(userId);
                        userDetailsDao.addAccessToken(userId, accessToken);
                    } else {
                        accessToken = token.get().getToken();
                    }
                    return new LoginResultDto(accessToken, roles);

                }).orElseThrow(() -> new BadCredentialsException("Login Failed"));
    }
}