package mate.apple_center_reservation.dto;

import lombok.*;
import mate.apple_center_reservation.enums.MealType;
import mate.apple_center_reservation.enums.ReservationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class ReservationDTO {
    private Long id;
    private Long elderly_id;// ElderlyDTO.id
    private String guardian_relation;
    private ReservationType reservationType;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private MealType meal;
    private String request;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
