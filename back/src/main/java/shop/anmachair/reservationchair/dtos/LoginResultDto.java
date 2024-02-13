package shop.anmachair.reservationchair.dtos;

import java.util.List;

public record LoginResultDto(
        String accessToken,
        List<String> roles
) {
}