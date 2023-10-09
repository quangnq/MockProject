package fa.training.dto;

import fa.training.entity.CustomerEntity;
import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp {@code InjectionResultReportDto} là một đối tượng DTO (Data Transfer
 * Object) dùng để lưu trữ thông tin về kết quả tiêm chủng trong báo cáo. Đối
 * tượng này chứa các thuộc tính như mã kết quả tiêm chủng, thông tin về khách
 * hàng, ngày tiêm chủng, nơi tiêm chủng, ngày tiêm chủng tiếp theo, số lần tiêm
 * chủng, thông tin phòng ngừa, và thông tin về vaccine.
 *
 * Đối tượng này cung cấp các phương thức để tạo đối tượng DTO từ đối tượng
 * Entity ({@code InjectionResultEntity}) và danh sách đối tượng DTO từ danh
 * sách đối tượng Entity.
 *
 * @see InjectionResultEntity
 * @see CustomerEntity
 * @see VaccineEntity
 * @see LocalDate
 * @see BaseSearchDto
 * @author phimv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InjectionResultReportDto {
	private String injectionResultId;

	private CustomerEntity customerEntity;

	private LocalDate injectionDate;

	private String injectionPlace;

	private LocalDate nextInjectionDate;

	private int numberOfInjection;

	private String prevention;

	private VaccineEntity vaccineEntity;

	/**
	 * Phương thức tạo một đối tượng {@code InjectionResultReportDto} từ một đối
	 * tượng Entity {@code InjectionResultEntity}.
	 *
	 * @param entity Đối tượng Entity {@code InjectionResultEntity} để sao chép
	 * thông tin.
	 * @return Đối tượng {@code InjectionResultReportDto} được tạo ra từ Entity.
	 */
	public static InjectionResultReportDto cloneFromEntity(InjectionResultEntity entity) {
		InjectionResultReportDto dto = new InjectionResultReportDto();
		dto.setInjectionResultId(entity.getInjectionResultId());
		dto.setCustomerEntity(entity.getCustomerEntity());
		dto.setInjectionDate(entity.getInjectionDate());
		dto.setInjectionPlace(entity.getInjectionPlace());
		dto.setNextInjectionDate(entity.getNextInjectionDate());
		dto.setNumberOfInjection(entity.getNumberOfInjection());
		dto.setPrevention(entity.getPrevention());
		dto.setVaccineEntity(entity.getVaccineEntity());

		return dto;
	}
	  /**
     * Phương thức tạo danh sách các đối tượng {@code InjectionResultReportDto} từ danh sách các đối tượng Entity {@code InjectionResultEntity}.
     *
     * @param entityList Danh sách các đối tượng Entity {@code InjectionResultEntity}.
     * @return Danh sách các đối tượng {@code InjectionResultReportDto}.
     */
	public static List<InjectionResultReportDto> cloneFromEntityList(List<InjectionResultEntity> entityList) {
		List<InjectionResultReportDto> dtoList = new ArrayList<>();
		for (InjectionResultEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
}
