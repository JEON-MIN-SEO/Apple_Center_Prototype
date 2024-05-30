package mate.apple_center_reservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.apple_center_reservation.enums.MealType;
import mate.apple_center_reservation.enums.ReservationType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@EntityListeners(AuditingEntityListener.class) //생성, 수정 시간 기록
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation_table")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long elderlyId;

    @Column(nullable = false)
    private String guardianRelation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationType type = ReservationType.DEFAULT; //기본값 설정

    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable = false)
    private LocalTime reservationTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType meal = MealType.DEFAULT; //기본값 설정

    @Column
    private String request;

    @CreatedDate //생성 시간 자동 입력
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate //수정 시간 자동 입력
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
