package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "time_slot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_slot_id")
    private Integer id;

    private LocalTime times;

    public TimeSlot() {
    }

    public TimeSlot(Integer id, LocalTime timeSlot) {
        this.id = id;
        this.times = timeSlot;
    }

    public LocalTime getTimes() {
        return times;
    }

    public Integer getId() {
        return id;
    }
}
