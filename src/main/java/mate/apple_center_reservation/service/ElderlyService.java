package mate.apple_center_reservation.service;

import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.entity.ElderlyEntity;
import mate.apple_center_reservation.exception.CreateException;
import mate.apple_center_reservation.exception.DeleteException;
import mate.apple_center_reservation.exception.FindException;
import mate.apple_center_reservation.exception.UpdateException;
import mate.apple_center_reservation.repository.ElderlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<ElderlyDTO> getAllElderly() {
        try {
            List<ElderlyEntity> elderlyList = elderlyRepository.findAll();
            return elderlyList.stream()
                    .map(elderly -> new ElderlyDTO(elderly.getId(), elderly.getName(), elderly.getFloor()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("입소자 명부를 가져오는 중 오류가 발생했습니다.", e);
        }
    }

    //어르신 번호 이름으로 찾기
    @Transactional(readOnly = true)
    public Long findElderlyIdByName(String name) {
        try {
            ElderlyEntity elderly = elderlyRepository.findByName(name)
                    .orElseThrow(() -> new FindException("해당 이름을 가진 어르신이 존재하지 않습니다."));
            return elderly.getId();
        } catch (Exception e) {
            throw new FindException("어르신 ID를 찾는 중 오류가 발생했습니다.", e);
        }
    }


    //입소자 명부 생성
    @Transactional
    public void saveElderly(ElderlyDTO elderlyDTO) {
        try {
            ElderlyEntity elderlyEntity = new ElderlyEntity(elderlyDTO.getId(), elderlyDTO.getName(), elderlyDTO.getFloor());
            elderlyRepository.save(elderlyEntity);
        } catch (Exception e) {
            throw new CreateException("입소자 명부를 저장하는 중 오류가 발생했습니다.", e);
        }
    }

    //입소자 명부 수정
    @Transactional
    public void updateElderly(Long id, ElderlyDTO elderlyDTO) {
        try {
            Optional<ElderlyEntity> optionalElderlyEntity = elderlyRepository.findById(id);
            if (optionalElderlyEntity.isPresent()) {
                ElderlyEntity updateElderlyEntity = optionalElderlyEntity.get();
                updateElderlyEntity.setName(elderlyDTO.getName());
                updateElderlyEntity.setFloor(elderlyDTO.getFloor());
                elderlyRepository.save(updateElderlyEntity);
            } else {
                throw new UpdateException("수정이 불가합니다: 어르신 ID " + id + "를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            throw new UpdateException("입소자 명부를 수정하는 중 오류가 발생했습니다.", e);
        }
    }

    //입소자 명부 삭제
    @Transactional
    public void deleteElderly(Long id) {
        try {
            Optional<ElderlyEntity> optionalElderlyEntity = elderlyRepository.findById(id);
            if (optionalElderlyEntity.isPresent()) {
                elderlyRepository.deleteById(id);
            } else {
                throw new DeleteException("삭제가 불가합니다: 어르신 ID " + id + "를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            throw new DeleteException("입소자 명부를 삭제하는 중 오류가 발생했습니다.", e);
        }
    }
}
