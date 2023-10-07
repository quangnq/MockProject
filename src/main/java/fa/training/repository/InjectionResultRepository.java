package fa.training.repository;

import fa.training.dto.BaseChartDto;
import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
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
public class InjectionResultRepository {

    @Autowired
    SessionFactory sessionFactory;

    public List<InjectionResultEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from InjectionResultEntity", InjectionResultEntity.class).getResultList();
    }

    public List<InjectionResultEntity> findByFilter(InjectionResultReportSearchDto searchDto) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<InjectionResultEntity> criteriaQuery = cb.createQuery(InjectionResultEntity.class);
        Root<InjectionResultEntity> injectionResultEntityRoot = criteriaQuery.from(InjectionResultEntity.class);
        Join<InjectionResultEntity, VaccineEntity> joinVaccine = injectionResultEntityRoot.join("vaccineEntity");
        Join<VaccineEntity, VaccineTypeEntity> joinVaccineType = joinVaccine.join("vaccineTypeEntity");

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(searchDto.getFromDate())) {
            predicates.add(cb.greaterThanOrEqualTo(injectionResultEntityRoot.get("injectionDate")
                    , LocalDate.parse(searchDto.getFromDate())));
        }
        if (StringUtils.isNotEmpty(searchDto.getToDate())) {
            predicates.add(cb.lessThanOrEqualTo(injectionResultEntityRoot.get("injectionDate")
                    , LocalDate.parse(searchDto.getToDate())));
        }
        if (StringUtils.isNotBlank(searchDto.getPrevention())) {
            predicates.add(cb.like(injectionResultEntityRoot.get("prevention"), "%"+ searchDto.getPrevention()+"%"));
        }
        if (StringUtils.isNotBlank(searchDto.getVaccineType()) && !"all".equalsIgnoreCase(searchDto.getVaccineType())) {
            predicates.add(cb.equal(joinVaccineType.get("vaccineTypeId"), searchDto.getVaccineType()));
        }

        criteriaQuery.select(injectionResultEntityRoot).where(predicates.toArray(new Predicate[]{}));
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
