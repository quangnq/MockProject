package fa.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CUSTOMER")
public class CustomerEntity {
	@Id
	@Column(name = "CUSTOMER_ID", columnDefinition = "NVARCHAR")
	private String customerId;

	@Column(name = "ADDRESS", length=255, columnDefinition = "NVARCHAR")
	private String address;

	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dateOfBirth;

	@Column(name = "EMAIL", length=100, columnDefinition = "NVARCHAR")
	private String email;

	@Column(name = "FULL_NAME", length=100, columnDefinition = "NVARCHAR")
	private String fullName;

	@Column(name = "GENDER")
	private int gender;

	@Column(name = "IDENTITY_CARD", length=12, columnDefinition = "NVARCHAR")
	private String identityCard;

	@Column(name = "PASSWORD", length=255, columnDefinition = "NVARCHAR")
	private String password;

	@Column(name = "PHONE", length=20, columnDefinition = "NVARCHAR(36)")
	private String phone;

	@Column(name = "USERNAME", length=255, columnDefinition = "NVARCHAR")
	private String username;

	@OneToMany(mappedBy = "customerEntity")
	private List<InjectionResultEntity> injectionResultEntityList;

}
