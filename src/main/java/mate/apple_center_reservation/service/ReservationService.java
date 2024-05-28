package mate.apple_center_reservation.service;

import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.dto.ReservationDTO;
import mate.apple_center_reservation.entity.ReservationEntity;
import mate.apple_center_reservation.repository.ElderlyRepository;
import mate.apple_center_reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

//    public void addReservation(ReservationDTO reservationDTO) {
//        ReservationEntity reservation = new ReservationEntity();
//        reservation.setElderly_Id(reservationDTO.getElderly_id());
//        reservation.setGuardian_relation(reservationDTO.getGuardian_relation());
//        reservation.setType(reservationDTO.);
//        reservation.setReservationDate(request.getReservationDate());
//        reservation.setReservationTime(request.getReservationTime());
//        reservation.setMeal(request.getMeal());
//        reservation.setRequest(request.getRequest());
//        reservation.setCreatedAt(LocalDateTime.now());
//        reservation.setUpdatedAt(LocalDateTime.now());
//
//        reservationRepository.save(reservation);
//    }
}
