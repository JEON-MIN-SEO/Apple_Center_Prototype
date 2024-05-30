package mate.apple_center_reservation.dto;

import jakarta.validation.constraints.NotNull;
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
@Builder
public class ReservationDTO {

    private Long id;

    @NotNull(message = "Elderly ID는 필수 항목입니다.")
    private Long elderly_id;// ElderlyDTO.id

    @NotNull(message = "Guardian relation은 필수 항목입니다.")
    private String guardian_relation;

    @Builder.Default
    private ReservationType reservationType = ReservationType.DEFAULT;

    @NotNull(message = "Reservation Date는 필수 항목입니다.")
    private LocalDate reservationDate;

    @NotNull(message = "Reservation Time은 필수 항목입니다.")
    private LocalTime reservationTime;

    @Builder.Default
    private MealType meal = MealType.DEFAULT;

    private String request;

    @NotNull(message = "Created Date는 필수 항목입니다.")
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
