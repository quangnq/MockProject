package fa.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="INJECTION_RESULT")
public class InjectionResultEntity {
	@Id
	@Column(name = "INJECTION_RESULT_ID", length=36)
	private String injectionResultId;

	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "CUSTOMER_ID")
	private CustomerEntity customerEntity;

	@Column(name = "INJECTION_DATE")
	private LocalDate injectionDate;

	@Column(name = "INJECTION_PLACE", length=255)
	private String injectionPlace;

	@Column(name = "NEXT_INJECTION_DATE")
	private LocalDate nextInjectionDate;

	@Column(name = "NUMBER_OF_INJECTION", length=100)
	private int numberOfInjection;

	@Column(name = "PREVENTION", length=100)
	private String prevention;

	@ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "VACCINE_ID")
	private VaccineEntity vaccineEntity;

}
