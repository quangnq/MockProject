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

/**
 * Lớp {@code VaccineRepository} là một thành phần Repository (kho dữ liệu) được sử dụng để truy vấn và tương tác
 * với cơ sở dữ liệu liên quan đến thông tin vắc-xin. Lớp này chứa phương thức để tìm vắc-xin theo các tiêu chí tìm kiếm.
 *
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Repository
public class VaccineRepository {
    @Autowired
    SessionFactory sessionFactory;
    
    /**
     * Phương thức này được sử dụng để tìm vắc-xin theo các tiêu chí tìm kiếm được chỉ định trong đối tượng
     * {@code VaccineReportSearchDto}.
     *
     * @param searchDto Đối tượng {@code VaccineReportSearchDto} chứa các tiêu chí tìm kiếm.
     * @return Danh sách các đối tượng {@code VaccineEntity} thỏa mãn tiêu chí tìm kiếm.
     */
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
