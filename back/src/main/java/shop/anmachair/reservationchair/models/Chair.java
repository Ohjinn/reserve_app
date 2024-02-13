package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chair")
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chair_id")
    private Integer id;

    @Column(name = "chair_name", nullable = false, length = 45)
    private String chairName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Chair() {
    }

    public Chair(Integer id, String chairName) {
        this.id = id;
        this.chairName = chairName;
    }

    public Integer getId() {
        return id;
    }

    public String getChairName() {
        return chairName;
    }
}
