package shop.anmachair.reservationchair.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_token")
public class AccessToken {

    @Id @Column(name = "user_id")
    private String user_id;

    private String token;

    public AccessToken() {
    }

    public AccessToken(String user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getToken() {
        return token;
    }
}
