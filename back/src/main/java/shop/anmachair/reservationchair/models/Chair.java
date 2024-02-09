package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CHAIR")
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAIR_ID")
    private Integer id;

    private String chairName;

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
