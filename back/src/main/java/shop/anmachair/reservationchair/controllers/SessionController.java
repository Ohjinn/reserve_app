package shop.anmachair.reservationchair.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import shop.anmachair.reservationchair.dtos.LoginRequestDto;
import shop.anmachair.reservationchair.dtos.LoginResultDto;
import shop.anmachair.reservationchair.services.LoginService;
import shop.anmachair.reservationchair.services.LogoutService;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final LoginService loginService;
    private final LogoutService logoutService;

    public SessionController(LoginService loginService,
                             LogoutService logoutService) {
        this.loginService = loginService;
        this.logoutService = logoutService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResultDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(
                loginRequestDto.username(),
                loginRequestDto.password()
        );
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(Authentication authentication) {
        String accessToken = authentication.getCredentials().toString();

        logoutService.logout(accessToken);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String loginFailed() {
        return "Bad Request!";
    }
}