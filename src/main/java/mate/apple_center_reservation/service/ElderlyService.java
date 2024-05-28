package mate.apple_center_reservation.service;

import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.entity.ElderlyEntity;
import mate.apple_center_reservation.exception.DeleteException;
import mate.apple_center_reservation.exception.UpdateException;
import mate.apple_center_reservation.repository.ElderlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElderlyService {

    private final ElderlyRepository elderlyRepository;

    @Autowired
    public ElderlyService(ElderlyRepository elderlyRepository) {
        this.elderlyRepository = elderlyRepository;
    }

    //입소자 명부 모두 가져오기
    public List<ElderlyDTO> getAllElderly() {
        List<ElderlyEntity> elderlyList = elderlyRepository.findAll();
        return elderlyList.stream()
                .map(elderly -> new ElderlyDTO(elderly.getId(), elderly.getName(), elderly.getFloor()))
                .collect(Collectors.toList());
    }

    //입소자 명부 생성
    public void saveElderly(ElderlyDTO elderlyDTO) {
        ElderlyEntity elderlyEntity = new ElderlyEntity(elderlyDTO.getId(), elderlyDTO.getName(), elderlyDTO.getFloor());
        elderlyRepository.save(elderlyEntity);
    }

    //입소자 명부 수정
    public void updateElderly(Long id, ElderlyDTO elderlyDTO) {
        Optional<ElderlyEntity> optionalElderlyEntity = elderlyRepository.findById(id);
        if (optionalElderlyEntity.isPresent()) {
            ElderlyEntity updateElderlyEntity = optionalElderlyEntity.get();
            updateElderlyEntity.setName(elderlyDTO.getName());
            updateElderlyEntity.setFloor(elderlyDTO.getFloor());
            elderlyRepository.save(updateElderlyEntity);
        } else {
            throw new UpdateException("수정이 불가합니다: 어르신 ID " + id + "를 찾을 수 없습니다.");
        }
    }

    //입소자 명부 삭제
    public void deleteElderly(Long id) {
        Optional<ElderlyEntity> optionalElderlyEntity = elderlyRepository.findById(id);
        if (optionalElderlyEntity.isPresent()) {
            elderlyRepository.deleteById(id);
        } else {
            throw new DeleteException("삭제가 불가합니다: 어르신 ID " + id + "를 찾을 수 없습니다.");
        }
    }
}
