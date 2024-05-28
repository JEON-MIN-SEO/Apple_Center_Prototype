package mate.apple_center_reservation.controller.api;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.validation.Valid;
import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.exception.DeleteException;
import mate.apple_center_reservation.exception.UpdateException;
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
        public ResponseEntity<String> updateElderly(@PathVariable("id") Long id, @RequestBody ElderlyDTO elderlyDTO) {
            try {
                elderlyService.updateElderly(id, elderlyDTO);
                return new ResponseEntity<>("업데이트가 성공적으로 완료되었습니다.", HttpStatus.OK); // 업데이트 성공
            } catch (UpdateException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 업데이트 실패 시
            } catch (Exception e) {
                return new ResponseEntity<>("서버 오류가 발생했습니다: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 기타 예외 발생 시
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteElderly(@PathVariable("id") Long id) {
        try {
            elderlyService.deleteElderly(id);
            return new ResponseEntity<>("삭제가 성공적으로 완료되었습니다.", HttpStatus.OK); // 삭제 성공
        } catch (DeleteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 삭제 실패 시
        } catch (Exception e) {
            return new ResponseEntity<>("서버 오류가 발생했습니다: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 기타 예외 발생 시
        }
    }
}
