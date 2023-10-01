package fa.training.service;

import fa.training.entity.VaccineEntity;
import fa.training.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Transactional
    public List<VaccineEntity> findAll() {
        return vaccineRepository.findAll();
    }
}
