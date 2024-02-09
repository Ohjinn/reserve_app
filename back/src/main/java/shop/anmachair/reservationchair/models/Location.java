package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationId")
    private Integer id;

    @Column(name = "locationName", nullable = false, length = 45)
    private String locationName;

    public Location() {
    }

    public Location(Integer id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    public Integer getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }
}
