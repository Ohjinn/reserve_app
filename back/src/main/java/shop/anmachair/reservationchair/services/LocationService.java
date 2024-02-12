package shop.anmachair.reservationchair.services;

import org.springframework.stereotype.Service;
import shop.anmachair.reservationchair.dtos.*;
import shop.anmachair.reservationchair.models.Location;
import shop.anmachair.reservationchair.repositories.LocationRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationResponseListDto getLocationList() {
        List<Location> locationList = locationRepository.findAll();

        List<LocationSummaryDto> collect = locationList.stream()
                .map(location -> new LocationSummaryDto(
                        location.getId(),
                        location.getLocationName()
                )).collect(Collectors.toList());

        return new LocationResponseListDto(collect);
    }

    public TimeListDto getTimeList(Integer locationId) {
        List<TimeSummaryDto> availableTimeList = locationRepository.findAvailableTimeList(locationId);
        return new TimeListDto(availableTimeList);
    }

    public ChairListDto getChairList(Integer locationId, LocalTime convertedTime) {
        List<ChairSummaryDto> availableChairList = locationRepository.findAvailableChairList(locationId, convertedTime);
        return new ChairListDto(availableChairList);
    }
}
