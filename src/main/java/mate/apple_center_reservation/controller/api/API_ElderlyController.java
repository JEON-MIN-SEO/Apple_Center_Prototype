package mate.apple_center_reservation.controller.api;

import jakarta.validation.Valid;
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

    @PostMapping("/elderly") //입소자 추가
    public ResponseEntity<Void> createElderly(@Valid @RequestBody ElderlyDTO elderlyDTO) {
        elderlyService.saveElderly(elderlyDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}") //입소자 명부 수정
    public ResponseEntity<Void> updateElderly(@PathVariable("id") Long id, @RequestBody ElderlyDTO elderlyDTO) {
        elderlyService.updateElderly(id, elderlyDTO);
        return new ResponseEntity<>(HttpStatus.OK); // 업데이트 성공
    }

    @DeleteMapping("/{id}") //입소자 명부 삭제
    public ResponseEntity<Void> deleteElderly(@PathVariable("id") Long id) {
        elderlyService.deleteElderly(id);
        return new ResponseEntity<>(HttpStatus.OK); // 삭제 성공
    }

    @GetMapping("/elderly/id") //이름으로 입소자 번호 찾기 [admin/api/elderly/id?name=손민석]
    public ResponseEntity<Long> getElderlyIdByName(@RequestParam("name") String name) {
        Long id = elderlyService.findElderlyIdByName(name);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
