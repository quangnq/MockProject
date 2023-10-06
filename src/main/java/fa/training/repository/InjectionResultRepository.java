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

    public List<InjectionResultEntity> findByFilter(InjectionResultReportSearchDto injectionResultReportSearchDto) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<InjectionResultEntity> criteriaQuery = cb.createQuery(InjectionResultEntity.class);
        Root<InjectionResultEntity> injectionResultEntityRoot = criteriaQuery.from(InjectionResultEntity.class);
        Join<InjectionResultEntity, VaccineEntity> joinVaccine = injectionResultEntityRoot.join("vaccineEntity");
        Join<VaccineEntity, VaccineTypeEntity> joinVaccineType = joinVaccine.join("vaccineTypeEntity");

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(injectionResultReportSearchDto.getFromDate())) {
            predicates.add(cb.greaterThanOrEqualTo(injectionResultEntityRoot.get("injectionDate")
                    , LocalDate.parse(injectionResultReportSearchDto.getFromDate())));
        }
        if (StringUtils.isNotEmpty(injectionResultReportSearchDto.getToDate())) {
            predicates.add(cb.lessThanOrEqualTo(injectionResultEntityRoot.get("injectionDate")
                    , LocalDate.parse(injectionResultReportSearchDto.getToDate())));
        }
        if (StringUtils.isNotBlank(injectionResultReportSearchDto.getPrevention())) {
            predicates.add(cb.like(injectionResultEntityRoot.get("prevention"), "%"+ injectionResultReportSearchDto.getPrevention()+"%"));
        }
        if (StringUtils.isNotBlank(injectionResultReportSearchDto.getVaccineType()) && !"all".equalsIgnoreCase(injectionResultReportSearchDto.getVaccineType())) {
            predicates.add(cb.equal(joinVaccineType.get("vaccineTypeId"), injectionResultReportSearchDto.getVaccineType()));
        }

        criteriaQuery.select(injectionResultEntityRoot).where(predicates.toArray(new Predicate[]{}));
        return session.createQuery(criteriaQuery).getResultList();
    }

    public BaseChartDto buildMinMaxYear() {
        return sessionFactory.getCurrentSession().createQuery(
                "select new fa.training.dto.BaseChartDto(YEAR(MIN(injectionDate)) as minYear, YEAR(MAX(injectionDate)) as maxYear)" +
                        " from InjectionResultEntity", BaseChartDto.class).getSingleResult();
    }

    public List<ValueOfMonthDto> getValueMonthOfYear(int year) {
        return sessionFactory.getCurrentSession().createQuery(
                "select new fa.training.dto.ValueOfMonthDto(MONTH(injectionDate) as month, SUM(numberOfInjection) as value)" +
                        " from InjectionResultEntity where YEAR(injectionDate) = " + year +
                        " GROUP BY  MONTH(injectionDate)"
                , ValueOfMonthDto.class).getResultList();
    }
}
