package fa.training.service;

import fa.training.entity.CustomerEntity;
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
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }
}
