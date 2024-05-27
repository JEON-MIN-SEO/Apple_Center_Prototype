package mate.apple_center_reservation.service;

import mate.apple_center_reservation.dto.ElderlyDTO;
import mate.apple_center_reservation.entity.ElderlyEntity;
import mate.apple_center_reservation.repository.ElderlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElderlyService {

    private final ElderlyRepository elderlyRepository;

    @Autowired
    public ElderlyService(ElderlyRepository elderlyRepository) {
        this.elderlyRepository = elderlyRepository;
    }

    public List<ElderlyDTO> getAllElderly() {
        List<ElderlyEntity> elderlyList = elderlyRepository.findAll();
        return elderlyList.stream()
                .map(elderly -> new ElderlyDTO(elderly.getId(), elderly.getName(), elderly.getFloor()))
                .collect(Collectors.toList());
    }

    public void createElderly(ElderlyDTO elderlyDTO) {
        ElderlyEntity elderlyEntity = new ElderlyEntity(elderlyDTO.getId(), elderlyDTO.getName(), elderlyDTO.getFloor());
        elderlyRepository.save(elderlyEntity);
    }
}
