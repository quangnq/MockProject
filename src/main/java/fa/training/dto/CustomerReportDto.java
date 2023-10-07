package fa.training.dto;

import fa.training.entity.CustomerEntity;
import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

//	private List<InjectionResultEntity> injectionResultEntityList;

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
		int sumInjection = 0;
		for (InjectionResultEntity injectionResultEntity : entity.getInjectionResultEntityList()) {
			sumInjection = sumInjection + injectionResultEntity.getNumberOfInjection();
		}
		dto.setNumberOfInjection(sumInjection);
		return dto;
	}

	public static List<CustomerReportDto> cloneFromEntityList(List<CustomerEntity> entityList) {
		List<CustomerReportDto> dtoList = new ArrayList<>();
		for (CustomerEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
}
