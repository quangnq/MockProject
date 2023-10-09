package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Lớp {@code CustomerReportSearchDto} là một đối tượng DTO (Data Transfer Object) được sử dụng để lưu trữ các thông tin
 * cần thiết cho việc tìm kiếm khách hàng trong báo cáo. Đối tượng này kế thừa từ lớp {@code BaseSearchDto} và bổ sung
 * thêm các thuộc tính như tên đầy đủ và địa chỉ của khách hàng.
 *
 * Đối tượng này thường được sử dụng để xác định các tiêu chí tìm kiếm khi truy vấn thông tin của khách hàng trong báo cáo.
 *
 * @see BaseSearchDto
 * @author phinv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerReportSearchDto extends BaseSearchDto {
    private String fullName;

    private String address;

}
