package fa.training.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineEntity;
import fa.training.entity.VaccineTypeEntity;

/**
 * Lớp {@code InjectionResultRepository} là một thành phần Repository (kho dữ liệu) được sử dụng để truy vấn và tương tác
 * với cơ sở dữ liệu liên quan đến thông tin kết quả tiêm chủng. Lớp này chứa các phương thức để tìm tất cả kết quả tiêm chủng,
 * tìm kết quả tiêm chủng theo các tiêu chí tìm kiếm, và lấy giá trị theo tháng của số lần tiêm chủng.
 *
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Repository
public class InjectionResultRepository {

    @Autowired
    SessionFactory sessionFactory;    
    
    /**
     * Phương thức này được sử dụng để tìm tất cả các kết quả tiêm chủng trong cơ sở dữ liệu.
     *
     * @return Danh sách các đối tượng {@code InjectionResultEntity}.
     */
    public List<InjectionResultEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from InjectionResultEntity", InjectionResultEntity.class).getResultList();
    }

    /**
     * Phương thức này được sử dụng để tìm kết quả tiêm chủng theo các tiêu chí tìm kiếm được chỉ định trong đối tượng
     * {@code InjectionResultReportSearchDto}.
     *
     * @param searchDto Đối tượng {@code InjectionResultReportSearchDto} chứa các tiêu chí tìm kiếm.
     * @return Danh sách các đối tượng {@code InjectionResultEntity} thỏa mãn tiêu chí tìm kiếm.
     */
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
    /**
     * Phương thức này được sử dụng để lấy giá trị theo tháng của số lần tiêm chủng từ cơ sở dữ liệu.
     *
     * @return Danh sách các đối tượng {@code ValueOfMonthDto} chứa giá trị theo tháng của số lần tiêm chủng.
     */
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
