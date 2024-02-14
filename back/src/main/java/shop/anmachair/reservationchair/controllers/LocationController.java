package shop.anmachair.reservationchair.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.anmachair.reservationchair.dtos.ChairListDto;
import shop.anmachair.reservationchair.dtos.LocationResponseListDto;
import shop.anmachair.reservationchair.dtos.TimeListDto;
import shop.anmachair.reservationchair.services.LocationService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger log = LoggerFactory.getLogger(LocationController.class);
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<LocationResponseListDto> list() {
        LocationResponseListDto locationList = locationService.getLocationList();

        return ResponseEntity.ok()
                .body(locationList);
    }

    @GetMapping("/{locationId}/times")
    public ResponseEntity<TimeListDto> timeList(
            @PathVariable Integer locationId
    ) {
        TimeListDto timeList = locationService.getTimeList(locationId);
        return ResponseEntity.ok()
                .body(timeList);
    }

    @GetMapping("/{locationId}/times/{time}/chairs")
    public ResponseEntity<ChairListDto> chairList(
            @PathVariable Integer locationId,
            @PathVariable String time
    ) {
        LocalTime convertedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        ChairListDto chairList = locationService.getChairList(locationId, convertedTime);
        return ResponseEntity.ok()
                .body(chairList);
    }
}
