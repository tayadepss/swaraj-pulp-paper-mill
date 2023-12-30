package departmentService.employeeClient;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import departmentService.dto.EmployeeResponse;
@HttpExchange("/employee")
public interface EmployeeClient{
	@GetExchange("getAllEmployee")
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeResponse> getAllEmployee();
}
