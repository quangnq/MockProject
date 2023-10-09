package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dto.VaccineTypeDto;
import fa.training.entity.VaccineTypeEntity;
import fa.training.repository.VaccineTypeRepository;
/**
 * Lớp {@code VaccineTypeService} là một thành phần dịch vụ (Service) được sử dụng để xử lý các yêu cầu liên quan
 * đến thông tin về các loại vắc-xin. Lớp này chứa phương thức để tìm tất cả các loại vắc-xin.
 *
 * @see VaccineTypeRepository
 * @see VaccineTypeDto
 * @see Service
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Service
public class VaccineTypeService {

    @Autowired
    VaccineTypeRepository vaccineTypeRepository;
    
    /**
     * Phương thức này được sử dụng để tìm tất cả các loại vắc-xin trong cơ sở dữ liệu.
     *
     * @return Danh sách các đối tượng {@code VaccineTypeDto} chứa thông tin về các loại vắc-xin.
     */
    @Transactional
    public List<VaccineTypeDto> findAll() {
        List<VaccineTypeEntity> vaccineTypeEntityList = vaccineTypeRepository.findAll();
        return VaccineTypeDto.cloneFromEntityList(vaccineTypeEntityList);
    }
}
