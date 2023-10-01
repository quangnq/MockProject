package fa.training.repository;

import fa.training.entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<CustomerEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<CustomerEntity> customerEntityList = session.createQuery("from CustomerEntity", CustomerEntity.class).getResultList();
        return customerEntityList;
    }
}
