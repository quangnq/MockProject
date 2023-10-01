package fa.training.service;

import fa.training.entity.InjectionResultEntity;
import fa.training.repository.InjectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;

    @Transactional
    public List<InjectionResultEntity> findAll() {
        return injectionResultRepository.findAll();
    }
}
