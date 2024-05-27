package mate.apple_center_reservation.controller.api;

import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.service.ElderlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api")
public class API_ElderlyController {

    private final ElderlyService elderlyService;

    @Autowired
    public API_ElderlyController(ElderlyService elderlyService) {
        this.elderlyService = elderlyService;
    }

    @GetMapping("/elderly") //입소자(어르신) 명부 모두 확인 API
    public List<ElderlyDTO> listElderly() {
        return elderlyService.getAllElderly();
    }

    @PostMapping("/elderly") //입소자 추가 API
    public ResponseEntity<Void> createElderly(@RequestBody ElderlyDTO elderlyDTO) {
        elderlyService.createElderly(elderlyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
