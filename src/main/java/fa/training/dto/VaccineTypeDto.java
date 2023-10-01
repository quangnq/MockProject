package fa.training.dto;

import fa.training.entity.VaccineTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineTypeDto {
	private String vaccineTypeId;

	private String description;

	private String vaccineTypeName;

	public static VaccineTypeDto cloneFromEntity(VaccineTypeEntity entity) {
		VaccineTypeDto dto = new VaccineTypeDto();
		dto.setVaccineTypeId(entity.getVaccineTypeId());
		dto.setDescription(entity.getDescription());
		dto.setVaccineTypeName(entity.getVaccineTypeName());
		return dto;
	}

	public static List<VaccineTypeDto> cloneFromEntityList(List<VaccineTypeEntity> entityList) {
		List<VaccineTypeDto> dtoList = new ArrayList<>();
		for (VaccineTypeEntity entity : entityList) {
			dtoList.add(cloneFromEntity(entity));
		}
		return dtoList;
	}
}
