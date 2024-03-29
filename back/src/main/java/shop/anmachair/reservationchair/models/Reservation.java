package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation extends CreateTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime reservationDatetime;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Reservation() {
    }

    public Reservation(Integer id, User user, LocalDateTime reservationDateTime, Chair chair, Location location) {
        this.id = id;
        this.user = user;
        this.reservationDatetime = reservationDateTime;
        this.chair = chair;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getReservationDatetime() {
        return reservationDatetime;
    }

    public Chair getChair() {
        return chair;
    }

    public Location getLocation() {
        return location;
    }

    public static class Builder {
        private Integer id;
        private User user;
        private LocalDateTime reservationDateTime;
        private Chair chair;
        private Location location;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder reservationDateTime(LocalDateTime reservationDateTime) {
            this.reservationDateTime = reservationDateTime;
            return this;
        }

        public Builder chair(Chair chair) {
            this.chair = chair;
            return this;
        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.id = this.id;
            reservation.user = this.user;
            reservation.reservationDatetime = this.reservationDateTime;
            reservation.chair = this.chair;
            reservation.location = this.location;
            return reservation;
        }
    }
}
