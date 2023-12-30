package employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
	private Long id;
	private String locality;
	private String city;
	private String district;
	private String state;
	private Long pin;
}
