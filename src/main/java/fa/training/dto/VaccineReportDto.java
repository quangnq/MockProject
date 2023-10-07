package fa.training.dto;

import fa.training.entity.InjectionResultEntity;
import fa.training.entity.VaccineEntity;
import fa.training.entity.VaccineTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineReportDto {
	private String vaccineId;

	private String contraindication;

	private String indication;

	private Integer numberOfInjection;

	private String origin;

	private LocalDate timeBeginNextInjection;

	private LocalDate timeEndNextInjection;

	private String usage;

	private String vaccineName;

	private VaccineTypeEntity vaccineTypeEntity;

	private List<InjectionResultEntity> injectionResultEntityList;

	public static VaccineReportDto cloneFromEntity(VaccineEntity entity) {
		VaccineReportDto dto = new VaccineReportDto();
		dto.setVaccineId(entity.getVaccineId());
		dto.setContraindication(entity.getContraindication());
		dto.setIndication(entity.getIndication());
		dto.setNumberOfInjection(entity.getNumberOfInjection());
		dto.setOrigin(entity.getOrigin());
		dto.setNumberOfInjection(entity.getNumberOfInjection());
		dto.setTimeBeginNextInjection(entity.getTimeBeginNextInjection());
		dto.setTimeEndNextInjection(entity.getTimeEndNextInjection());

		dto.setUsage(entity.getUsage());
		dto.setVaccineName(entity.getVaccineName());
		dto.setVaccineTypeEntity(entity.getVaccineTypeEntity());
		dto.setInjectionResultEntityList(entity.getInjectionResultEntityList());

		return dto;
	}

	public static List<VaccineReportDto> cloneFromEntityList(List<VaccineEntity> entityList) {
		List<VaccineReportDto> dtoList = new ArrayList<>();
		for (VaccineEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
}
