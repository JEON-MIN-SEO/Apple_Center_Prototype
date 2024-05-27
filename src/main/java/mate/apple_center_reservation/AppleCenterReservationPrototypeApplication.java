package mate.apple_center_reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //JPA 감사 기능
public class AppleCenterReservationPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppleCenterReservationPrototypeApplication.class, args);
	}

}
