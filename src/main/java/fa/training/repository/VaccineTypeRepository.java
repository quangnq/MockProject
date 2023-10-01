package fa.training.repository;

import fa.training.entity.VaccineEntity;
import fa.training.entity.VaccineTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class VaccineTypeRepository {

    @Autowired
    SessionFactory sessionFactory;

    public List<VaccineTypeEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<VaccineTypeEntity> vaccineTypeEntityList = session.createQuery("from VaccineTypeEntity", VaccineTypeEntity.class).getResultList();
        return vaccineTypeEntityList;
    }
}
