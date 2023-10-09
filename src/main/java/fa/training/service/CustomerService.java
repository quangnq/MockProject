package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dto.CustomerReportDto;
import fa.training.dto.CustomerReportSearchDto;
import fa.training.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<CustomerReportDto> findByFilter(CustomerReportSearchDto searchDto) {
        return CustomerReportDto.cloneFromEntityList(customerRepository.findByFilter(searchDto));
    }

}
