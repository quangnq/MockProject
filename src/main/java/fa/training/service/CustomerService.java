package fa.training.service;

import fa.training.dto.BaseChartDto;
import fa.training.dto.CustomerReportDto;
import fa.training.dto.CustomerReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
import fa.training.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<CustomerReportDto> findByFilter(CustomerReportSearchDto searchDto) {
        return CustomerReportDto.cloneFromEntityList(customerRepository.findByFilter(searchDto));
    }

    public BaseChartDto getChartDto() {
        List<ValueOfMonthDto> valueOfMonthDtoList = customerRepository.getValueMonthOfYear();
        BaseChartDto baseChartDto = new BaseChartDto(valueOfMonthDtoList);
        return baseChartDto;
    }
}
