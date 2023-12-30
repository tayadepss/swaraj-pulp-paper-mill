package departmentService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptWithEmployeeResponse {
	private Long deptId;
	private String deptName;
	private String deptIncharge;
	private List<EmployeeResponse> employees;
}
