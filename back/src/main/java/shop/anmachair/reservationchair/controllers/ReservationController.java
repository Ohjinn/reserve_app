package shop.anmachair.reservationchair.controllers;

import jakarta.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.anmachair.reservationchair.dtos.ReservationListDto;
import shop.anmachair.reservationchair.dtos.ReservationRequestDto;
import shop.anmachair.reservationchair.services.ReservationService;

import java.security.Principal;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<ReservationListDto> list(
//            @RequestHeader(value = "Authorization") String token,
            Principal principal
    ) {
        String name = principal.getName();
        System.out.println("name = " + name);
        ReservationListDto reservationList = reservationService.getReservationList(name);
        System.out.println(reservationList.reservations().stream().toString());
        return ResponseEntity.ok()
                .body(reservationList);
    }

    @PostMapping
    public ResponseEntity<Integer> create(
            Principal principal,
            @Valid @RequestBody ReservationRequestDto reservationRequestDto
    ) {
        String user = principal.getName();
        log.error(user);
        Integer reservationId = reservationService
                .createReservation(user, reservationRequestDto);
        log.error("reservationId", reservationId);
        return ResponseEntity.ok()
                .body(reservationId);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Integer> delete(
            @PathVariable Integer reservationId
    ) {
        return ResponseEntity.ok()
                .body(reservationService.deleteReservation(reservationId));
    }
}
