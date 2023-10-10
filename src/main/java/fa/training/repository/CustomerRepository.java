package fa.training.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dto.CustomerReportSearchDto;
import fa.training.entity.CustomerEntity;

/**
 * Lớp {@code CustomerRepository} là một thành phần Repository (kho dữ liệu) được sử dụng để truy vấn và tương tác
 * với cơ sở dữ liệu liên quan đến thông tin khách hàng. Lớp này chứa các phương thức để tìm tất cả khách hàng và
 * tìm khách hàng theo các tiêu chí tìm kiếm.
 *
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Repository
public class CustomerRepository {
    @Autowired
    SessionFactory sessionFactory;

    /**
     * Phương thức này được sử dụng để tìm khách hàng theo các tiêu chí tìm kiếm được chỉ định trong đối tượng
     * {@code CustomerReportSearchDto}.
     *
     * @param searchDto Đối tượng {@code CustomerReportSearchDto} chứa các tiêu chí tìm kiếm.
     * @return Danh sách các đối tượng {@code CustomerEntity} thỏa mãn tiêu chí tìm kiếm.
     */
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
