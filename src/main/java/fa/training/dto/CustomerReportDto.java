package fa.training.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.CustomerEntity;
import fa.training.entity.InjectionResultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lớp {@code CustomerReportDto} là một đối tượng DTO (Data Transfer Object) dùng để lưu trữ thông tin về khách hàng
 * trong báo cáo. Đối tượng này chứa các thuộc tính như mã khách hàng, địa chỉ, ngày sinh, email, họ và tên, giới tính,
 * số CMND, mật khẩu, số điện thoại, tên đăng nhập và số lần tiêm chủng.
 *
 * Ngoài ra, lớp này cung cấp các phương thức để tạo đối tượng DTO từ đối tượng Entity ({@code CustomerEntity}) và danh sách
 * đối tượng DTO từ danh sách đối tượng Entity.
 *
 * @author phinv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReportDto {
	private String customerId;

	private String address;

	private LocalDate dateOfBirth;

	private String email;

	private String fullName;

	private Integer gender;

	private String identityCard;

	private String password;

	private String phone;

	private String username;

	private int numberOfInjection;

	public static CustomerReportDto cloneFromEntity(CustomerEntity entity) {
		CustomerReportDto dto = new CustomerReportDto();
		dto.setCustomerId(entity.getCustomerId());
		dto.setAddress(entity.getAddress());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setEmail(entity.getEmail());
		dto.setFullName(entity.getFullName());
		dto.setGender(entity.getGender());
		dto.setIdentityCard(entity.getIdentityCard());
		dto.setPassword(entity.getPassword());
		dto.setPhone(entity.getPhone());
		dto.setUsername(entity.getUsername());
		
        // Tính tổng số lần tiêm chủng bằng cách lặp qua danh sách InjectionResultEntity
		int sumInjection = 0;
		for (InjectionResultEntity injectionResultEntity : entity.getInjectionResultEntityList()) {
			sumInjection = sumInjection + injectionResultEntity.getNumberOfInjection();
		}
		dto.setNumberOfInjection(sumInjection);
		return dto;
	}
	
	 /**
     * Phương thức tạo một đối tượng {@code CustomerReportDto} từ một đối tượng Entity {@code CustomerEntity}.
     *
     * @param entity Đối tượng Entity {@code CustomerEntity} để sao chép thông tin.
     * @return Đối tượng {@code CustomerReportDto} được tạo ra từ Entity.
     */
	public static List<CustomerReportDto> cloneFromEntityList(List<CustomerEntity> entityList) {
		List<CustomerReportDto> dtoList = new ArrayList<>();
		for (CustomerEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
	
	
}
