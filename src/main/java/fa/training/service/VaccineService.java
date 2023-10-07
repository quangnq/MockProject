package fa.training.service;

import fa.training.dto.VaccineReportDto;
import fa.training.dto.VaccineReportSearchDto;
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
    public List<VaccineReportDto> findByFilter(VaccineReportSearchDto searchDto) {
        return VaccineReportDto.cloneFromEntityList(vaccineRepository.findByFilter(searchDto));
    }
}
