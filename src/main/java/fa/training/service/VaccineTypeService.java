package fa.training.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fa.training.dto.VaccineTypeDto;
import fa.training.entity.VaccineTypeEntity;
import fa.training.repository.VaccineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccineTypeService {

    @Autowired
    VaccineTypeRepository vaccineTypeRepository;

    @Transactional
    public List<VaccineTypeDto> findAll() {
        List<VaccineTypeEntity> vaccineTypeEntityList = vaccineTypeRepository.findAll();
        return VaccineTypeDto.cloneFromEntityList(vaccineTypeEntityList);
    }
}
