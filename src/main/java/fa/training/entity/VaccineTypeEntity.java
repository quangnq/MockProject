package fa.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VACCINE_TYPE")
public class VaccineTypeEntity {
	@Id
	@Column(name = "VACCINE_TYPE_ID", length=36)
	private String vaccineTypeId;

	@Column(name = "DESCRIPTION", length=200)
	private String description;

	@Column(name = "VACCINE_TYPE_NAME", length=50)
	private String vaccineTypeName;

	@OneToMany(mappedBy = "vaccineTypeEntity")
	List<VaccineEntity> vaccineEntityList;

	//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate ngayDatCoc;
}
