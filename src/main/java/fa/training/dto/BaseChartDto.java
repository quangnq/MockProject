package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Lớp {@code BaseChartDto} đại diện cho đối tượng DTO (Data Transfer Object)
 * dùng để lưu trữ dữ liệu liên quan đến biểu đồ cơ bản. Biểu đồ này thể hiện
 * giá trị dữ liệu theo tháng trong các năm khác nhau.
 *
 * Đối tượng này chứa một {@code Map} lưu trữ giá trị theo từng năm và tháng
 * trong đó. Mỗi năm có một mảng giá trị, trong đó mỗi phần tử của mảng tương
 * ứng với giá trị của một tháng.
 *
 * Có cả một constructor được sử dụng để tạo đối tượng {@code BaseChartDto} từ
 * danh sách các đối tượng {@code ValueOfMonthDto} đại diện cho giá trị của từng
 * tháng trong năm.
 *
 * @author phinv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseChartDto {

	// Dữ liệu biểu đồ lưu trữ giá trị theo từng năm và tháng
	private Map<String, Long[]> yearAndMonthValue = new LinkedHashMap<>();

	/**
	 * Constructor để tạo đối tượng {@code BaseChartDto} từ danh sách các đối tượng
	 * {@code ValueOfMonthDto}.
	 *
	 * @param valueOfMonths Danh sách các đối tượng {@code ValueOfMonthDto} chứa giá
	 * trị của từng tháng.
	 */
	public BaseChartDto(List<ValueOfMonthDto> valueOfMonths) {
		if (CollectionUtils.isEmpty(valueOfMonths)) {
			return;
		}
		// Xác định năm nhỏ nhất và lớn nhất từ danh sách giá trị tháng
		int minYear = valueOfMonths.get(0).getYear();
		int maxYear = valueOfMonths.get(valueOfMonths.size() - 1).getYear();

		// Khởi tạo giá trị tháng của năm cho mỗi năm
		for (int year = minYear; year <= maxYear; year++) {
			// Khởi tạo giá trị tháng của năm ban đâù
			yearAndMonthValue.put(String.valueOf(year), new Long[] { 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l });
		}
		// Cập nhật giá trị tháng từ danh sách giá trị tháng đầu vào
		for (ValueOfMonthDto dto : valueOfMonths) {
			Long[] monthValues = yearAndMonthValue.get(String.valueOf(dto.getYear()));
			monthValues[dto.getMonth() - 1] = dto.getValue();
		}
	}
}
