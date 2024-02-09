package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class Reservation extends CreateTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private LocalDateTime reservationDateTime;

    @ManyToOne
    @JoinColumn(name = "CHAIR_ID")
    private Chair chair;

    public Reservation() {
    }

    public Reservation(Integer id, User user, LocalDateTime reservationDateTime, Chair chair) {
        this.id = id;
        this.user = user;
        this.reservationDateTime = reservationDateTime;
        this.chair = chair;
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
}
