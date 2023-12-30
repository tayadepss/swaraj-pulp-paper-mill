package employeeService.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
	private Long id;
	private String name;
	private String department;
	private Date dob;
	private Integer age;
	private Date doj;
	private Double salary;
	private String mobNumber;
	private String emailId;
	private AddressResponse addressResponse;
	private String designation;
}
