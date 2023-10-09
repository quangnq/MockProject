package fa.training.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * Lớp {@code BaseSearchDto} là một đối tượng DTO (Data Transfer Object) cơ bản được sử dụng
 * để lưu trữ các thông tin liên quan đến việc tìm kiếm dữ liệu. Đối tượng này chứa các thuộc tính
 * cho ngày bắt đầu (fromDate) và ngày kết thúc (toDate) mà có thể được sử dụng để lọc dữ liệu trong các truy vấn.
 *
 * Ngoài ra, lớp này cung cấp phương thức {@code validate()} để kiểm tra và điều chỉnh ngày bắt đầu và ngày kết thúc
 * nếu chúng không hợp lệ và không thể được chuyển đổi thành đối tượng {@code LocalDate}.
 *
 * @author phinv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Data
public class BaseSearchDto {

    private String fromDate;

    private String toDate;

    /**
     * Phương thức này được sử dụng để kiểm tra và điều chỉnh ngày bắt đầu và ngày kết thúc nếu chúng không hợp lệ
     * và không thể được chuyển đổi thành đối tượng {@code LocalDate}.
     * Nếu ngày bắt đầu hoặc ngày kết thúc không hợp lệ, chúng sẽ được đặt lại thành chuỗi rỗng ("").
     */
    public void validate() {
        if (StringUtils.isNotEmpty(this.fromDate)) {
            try {
                LocalDate.parse(this.fromDate);
            } catch (Exception e) {
                fromDate = "";
            }
        }
        if (StringUtils.isNotEmpty(this.toDate)) {
            try {
                LocalDate.parse(this.toDate);
            } catch (Exception e) {
                toDate = "";
            }
        }
    }
}
