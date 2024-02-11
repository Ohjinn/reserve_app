package shop.anmachair.reservationchair.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.anmachair.reservationchair.dtos.LocationResponseListDto;
import shop.anmachair.reservationchair.dtos.TimeListDto;
import shop.anmachair.reservationchair.services.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

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
}
