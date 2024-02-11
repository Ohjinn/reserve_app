package shop.anmachair.reservationchair.controllers;

import jakarta.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.anmachair.reservationchair.dtos.ReservationListDto;
import shop.anmachair.reservationchair.dtos.ReservationRequestDto;
import shop.anmachair.reservationchair.services.ReservationService;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
    private static final Integer userId = 2;

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<ReservationListDto> list(
//            @RequestHeader(value = "Authorization") String token
    ) {
        return ResponseEntity.ok()
                .body(reservationService.getReservationList(userId));
    }

    @PostMapping
    public ResponseEntity<Integer> create(
//            @RequestHeader(value = "Authorization") String token
            @Valid @RequestBody ReservationRequestDto reservationRequestDto
    ) {

        log.error(String.valueOf(reservationRequestDto));

        Integer reservationId = reservationService
                .createReservation(userId, reservationRequestDto);

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
