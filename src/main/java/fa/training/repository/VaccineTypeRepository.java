package fa.training.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.entity.VaccineTypeEntity;

/**
 * Lớp {@code VaccineTypeRepository} là một thành phần Repository (kho dữ liệu) được sử dụng để truy vấn và tương tác
 * với cơ sở dữ liệu liên quan đến thông tin loại vắc-xin. Lớp này chứa phương thức để tìm tất cả các loại vắc-xin.
 *
 * @see SessionFactory
 * @see Session
 * @see VaccineTypeEntity
 * @see Repository
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Repository
public class VaccineTypeRepository {

    @Autowired
    SessionFactory sessionFactory;
    /**
     * Phương thức này được sử dụng để tìm tất cả các loại vắc-xin trong cơ sở dữ liệu.
     *
     * @return Danh sách các đối tượng {@code VaccineTypeEntity}.
     */
    public List<VaccineTypeEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<VaccineTypeEntity> vaccineTypeEntityList = session.createQuery("from VaccineTypeEntity", VaccineTypeEntity.class).getResultList();
        return vaccineTypeEntityList;
    }
}
