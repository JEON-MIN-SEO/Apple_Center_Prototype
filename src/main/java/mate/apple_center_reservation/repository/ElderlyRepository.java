package mate.apple_center_reservation.repository;

import mate.apple_center_reservation.entity.ElderlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElderlyRepository extends JpaRepository<ElderlyEntity,Long> {
}