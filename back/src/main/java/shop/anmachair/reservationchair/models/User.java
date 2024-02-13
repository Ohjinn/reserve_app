package shop.anmachair.reservationchair.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends CreateTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "role", nullable = false, length = 10)
    private String role;

    public User() {
    }

    public User(String id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
