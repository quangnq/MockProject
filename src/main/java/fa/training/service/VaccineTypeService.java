package fa.training.service;

import fa.training.entity.VaccineTypeEntity;
import fa.training.repository.VaccineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VaccineTypeService {

    @Autowired
    VaccineTypeRepository vaccineTypeRepository;

    @Transactional
    public List<VaccineTypeEntity> findAll() {
        return vaccineTypeRepository.findAll();
    }
}
