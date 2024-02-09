package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation extends CreateTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime reservationDateTime;

    @ManyToOne
    @JoinColumn(name = "chairId")
    private Chair chair;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    public Reservation() {
    }

    public Reservation(Integer id, User user, LocalDateTime reservationDateTime, Chair chair, Location location) {
        this.id = id;
        this.user = user;
        this.reservationDateTime = reservationDateTime;
        this.chair = chair;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public Chair getChair() {
        return chair;
    }

    public Location getLocation() {
        return location;
    }
}
