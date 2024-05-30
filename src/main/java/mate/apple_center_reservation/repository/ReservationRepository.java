package mate.apple_center_reservation.repository;

import mate.apple_center_reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    // 주 단위 예약 조회
    List<ReservationEntity> findByReservationDateBetween(LocalDate startDate, LocalDate endDate);

    // 특정 어르신의 예약 조회
    List<ReservationEntity> findByElderlyIdIn(List<Long> elderlyIds);
}