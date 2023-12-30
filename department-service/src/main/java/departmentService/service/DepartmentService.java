package departmentService.service;

import java.util.List;

import departmentService.dto.DepartmentRequest;
import departmentService.dto.DepartmentResponse;
import departmentService.dto.DeptWithEmployeeResponse;

public interface DepartmentService {

	List<DepartmentResponse> getAllDept();

	DepartmentResponse createDept(DepartmentRequest departmentRequest);

	DeptWithEmployeeResponse getDeptWithEmployees(String dept);

}
