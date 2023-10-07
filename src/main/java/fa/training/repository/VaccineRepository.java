package fa.training.repository;

import fa.training.dto.VaccineReportSearchDto;
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
public class VaccineRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<VaccineEntity> findByFilter(VaccineReportSearchDto searchDto) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<VaccineEntity> criteriaQuery = cb.createQuery(VaccineEntity.class);
        Root<VaccineEntity> root = criteriaQuery.from(VaccineEntity.class);
        Join<VaccineEntity, VaccineTypeEntity> joinVaccineType = root.join("vaccineTypeEntity");

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(searchDto.getFromDate())) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("timeBeginNextInjection")
                    , LocalDate.parse(searchDto.getFromDate())));
        }
        if (StringUtils.isNotEmpty(searchDto.getToDate())) {
            predicates.add(cb.lessThanOrEqualTo(root.get("timeEndNextInjection")
                    , LocalDate.parse(searchDto.getToDate())));
        }
        if (StringUtils.isNotBlank(searchDto.getVaccineType()) && !"all".equalsIgnoreCase(searchDto.getVaccineType())) {
            predicates.add(cb.equal(joinVaccineType.get("vaccineTypeId"), searchDto.getVaccineType()));
        }
        if (StringUtils.isNotBlank(searchDto.getOrigin())) {
            predicates.add(cb.like(root.get("origin"), "%"+ searchDto.getOrigin()+"%"));
        }

        criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
        return session.createQuery(criteriaQuery).getResultList();
    }
}
