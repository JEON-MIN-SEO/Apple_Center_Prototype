package mate.apple_center_reservation.controller.api;

import mate.apple_center_reservation.dto.ReservationDTO;
import mate.apple_center_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class API_ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public API_ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //전체 조회


    //개별 조회

    //예약 추가
//    @PostMapping("/add")
//    public ResponseEntity<Void> Reservation_Add(@RequestBody ReservationDTO reservationDTO) {
//        reservationService.addReservation(reservationDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    //예약 수정

    //예약 삭제
}
