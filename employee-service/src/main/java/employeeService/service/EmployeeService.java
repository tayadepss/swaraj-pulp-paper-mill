package employeeService.service;

import java.util.List;

import employeeService.dto.EmployeeRequest;
import employeeService.dto.EmployeeResponse;

public interface EmployeeService {

	List<EmployeeResponse> getAllEmployee();

	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

}
