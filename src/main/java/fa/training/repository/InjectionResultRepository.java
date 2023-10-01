package fa.training.repository;

import fa.training.entity.InjectionResultEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InjectionResultRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<InjectionResultEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<InjectionResultEntity> injectionResultEntityList = session.createQuery("from InjectionResultEntity", InjectionResultEntity.class).getResultList();
        return injectionResultEntityList;
    }
}
