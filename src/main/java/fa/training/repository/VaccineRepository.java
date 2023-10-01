package fa.training.repository;

import fa.training.entity.VaccineEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class VaccineRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<VaccineEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<VaccineEntity> vaccineEntityList = session.createQuery("from VaccineEntity", VaccineEntity.class).getResultList();
        return vaccineEntityList;
    }
}
