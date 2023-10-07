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

    public List<ValueOfMonthDto> getValueMonthOfYear() {
        Query<ValueOfMonthDto> query = sessionFactory.getCurrentSession().createQuery(
                "select new fa.training.dto.ValueOfMonthDto(MONTH(injectionDate) as month" +
                        ", SUM(numberOfInjection) as value, YEAR(injectionDate) as year)" +
                        " from InjectionResultEntity" +
                        " GROUP BY  MONTH(injectionDate), YEAR(injectionDate)" +
                        " ORDER BY YEAR(injectionDate), MONTH(injectionDate)"
                , ValueOfMonthDto.class);
        return query.getResultList();
    }
}
