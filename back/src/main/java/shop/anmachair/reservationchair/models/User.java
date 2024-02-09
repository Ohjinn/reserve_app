package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends CreateTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    @Column(name = "userName", nullable = false, length = 20)
    private String userName;

    public User() {
    }

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
