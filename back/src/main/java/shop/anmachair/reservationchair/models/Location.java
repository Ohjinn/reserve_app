package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private Integer id;

    private String locationId;

    public Location() {
    }

    public Location(Integer id, String locationId) {
        this.id = id;
        this.locationId = locationId;
    }

    public Integer getId() {
        return id;
    }

    public String getLocationId() {
        return locationId;
    }
}
