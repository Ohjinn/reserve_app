package shop.anmachair.reservationchair.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shop.anmachair.reservationchair.dtos.SignupRequestDto;
import shop.anmachair.reservationchair.dtos.SignupResultDto;
import shop.anmachair.reservationchair.exceptions.UserAlreadyExistsException;
import shop.anmachair.reservationchair.services.SignupService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final SignupService signupService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SignupResultDto signup(
            @Valid @RequestBody SignupRequestDto signupRequestDto) {
        String accessToken = signupService.signup(
                signupRequestDto.username().trim(),
                signupRequestDto.password().trim());

        return new SignupResultDto(accessToken);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String alreadyExists() {
        return "User Already Exists";
    }
}