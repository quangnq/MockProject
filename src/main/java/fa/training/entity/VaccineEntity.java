package fa.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VACCINE")
public class VaccineEntity {
	@Id
	@Column(name = "VACCINE_ID", length=36)
	private String vaccineId;

	@Column(name = "CONTRAINDICATION", length=200, columnDefinition = "NVARCHAR(200)")
	private String contraindication;

	@Column(name = "INDICATION", length=200, columnDefinition = "NVARCHAR(200)")
	private String indication;

	@Column(name = "NUMBER_OF_INJECTION")
	private int numberOfInjection;

	@Column(name = "ORIGIN", length=50, columnDefinition = "NVARCHAR(50)")
	private String origin;

	@Column(name = "TIME_BEGIN_NEXT_INJECTION")
	private LocalDate timeBeginNextInjection;

	@Column(name = "TIME_END_NEXT_INJECTION")
	private LocalDate timeEndNextInjection;

	@Column(name = "USAGE", length=200, columnDefinition = "NVARCHAR(200)")
	private String usage;

	@Column(name = "VACCINE_NAME", length=100, columnDefinition = "NVARCHAR(100)")
	private String vaccineName;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "VACCINE_TYPE_ID")
	private VaccineTypeEntity vaccineTypeEntity;

	@OneToMany(mappedBy = "vaccineEntity")
	private List<InjectionResultEntity> injectionResultEntityList;

}
