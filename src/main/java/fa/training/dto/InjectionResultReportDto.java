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

	public static List<InjectionResultReportDto> cloneFromEntityList(List<InjectionResultEntity> entityList) {
		List<InjectionResultReportDto> dtoList = new ArrayList<>();
		for (InjectionResultEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
}
