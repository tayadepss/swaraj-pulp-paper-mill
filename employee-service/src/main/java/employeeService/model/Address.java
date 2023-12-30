package employeeService.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="addresses")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="locality")
	private String locality;
	@Column(name="city")
	private String city;
	@Column(name="district")
	private String district;
	@Column(name="State")
	private String state;
	@Column(name="pin")
	private Long pin;
}
