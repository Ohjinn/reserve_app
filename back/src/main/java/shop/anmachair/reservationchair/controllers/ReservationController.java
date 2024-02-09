package shop.anmachair.reservationchair.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.anmachair.reservationchair.dtos.ReservationListDto;
import shop.anmachair.reservationchair.services.ReservationService;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ReservationListDto list(
//            @RequestHeader(value = "Authorization") String token
    ) {
        String token = "12345";
        Integer userId = 12345;
        return reservationService.getReservationList(userId);
    }
}
