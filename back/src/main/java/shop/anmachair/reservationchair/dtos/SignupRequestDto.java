package shop.anmachair.reservationchair.dtos;

import jakarta.validation.constraints.NotBlank;

public record SignupRequestDto(
        @NotBlank
        String username,

        @NotBlank
        String password
) {
}
