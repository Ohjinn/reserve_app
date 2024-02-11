package shop.anmachair.reservationchair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //자동 시간 주입
public class ReservationChairApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationChairApplication.class, args);
    }

}
