package fa.training.service;

import fa.training.dto.VaccineReportDto;
import fa.training.dto.VaccineReportSearchDto;
import fa.training.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
/**
 * Lớp {@code VaccineService} là một thành phần dịch vụ (Service) được sử dụng để xử lý các yêu cầu liên quan
 * đến thông tin vắc-xin. Lớp này chứa phương thức để tìm vắc-xin dựa trên các tiêu chí tìm kiếm.
 *
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Service
public class VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Transactional
    public List<VaccineReportDto> findByFilter(VaccineReportSearchDto searchDto) {
        return VaccineReportDto.cloneFromEntityList(vaccineRepository.findByFilter(searchDto));
    }
}
