package fa.training.repository;

import fa.training.dto.CustomerReportSearchDto;
import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
import fa.training.entity.CustomerEntity;
import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineEntity;
import fa.training.entity.VaccineTypeEntity;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<CustomerEntity> findByFilter(CustomerReportSearchDto searchDto) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery = cb.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteriaQuery.from(CustomerEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(searchDto.getFromDate())) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateOfBirth")
                    , LocalDate.parse(searchDto.getFromDate())));
        }
        if (StringUtils.isNotEmpty(searchDto.getToDate())) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateOfBirth")
                    , LocalDate.parse(searchDto.getToDate())));
        }
        if (StringUtils.isNotBlank(searchDto.getAddress())) {
            predicates.add(cb.like(root.get("address"), "%"+ searchDto.getAddress()+"%"));
        }
        if (StringUtils.isNotBlank(searchDto.getFullName())) {
            predicates.add(cb.like(root.get("fullName"), "%"+ searchDto.getFullName()+"%"));
        }

        criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
        return session.createQuery(criteriaQuery).getResultList();
    }
}
