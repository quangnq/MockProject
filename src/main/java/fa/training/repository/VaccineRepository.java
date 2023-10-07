package fa.training.repository;

import fa.training.dto.CustomerReportSearchDto;
import fa.training.entity.CustomerEntity;
import fa.training.entity.VaccineEntity;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<CustomerEntity> findByFilter(CustomerReportSearchDto customerReportSearchDto) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteriaQuery = cb.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteriaQuery.from(CustomerEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(customerReportSearchDto.getFromDate())) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("dateOfBirth")
                    , LocalDate.parse(customerReportSearchDto.getFromDate())));
        }
        if (StringUtils.isNotEmpty(customerReportSearchDto.getToDate())) {
            predicates.add(cb.lessThanOrEqualTo(root.get("dateOfBirth")
                    , LocalDate.parse(customerReportSearchDto.getToDate())));
        }
        if (StringUtils.isNotBlank(customerReportSearchDto.getAddress())) {
            predicates.add(cb.like(root.get("address"), "%"+ customerReportSearchDto.getAddress()+"%"));
        }
        if (StringUtils.isNotBlank(customerReportSearchDto.getFullName())) {
            predicates.add(cb.like(root.get("fullName"), "%"+ customerReportSearchDto.getFullName()+"%"));
        }

        criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
        return session.createQuery(criteriaQuery).getResultList();
    }
}
