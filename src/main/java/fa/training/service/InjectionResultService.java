package fa.training.service;

import fa.training.dto.InjectionResultReportDto;
import fa.training.dto.VaccineTypeDto;
import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineTypeEntity;
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
    public List<InjectionResultReportDto> findAll() {
        List<InjectionResultEntity> entityList = injectionResultRepository.findAll();
        return InjectionResultReportDto.cloneFromEntityList(entityList);
    }
}
