package employeeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import employeeService.dto.EmployeeRequest;
import employeeService.dto.EmployeeResponse;
import employeeService.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("getAllEmployee")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
		return new ResponseEntity<List<EmployeeResponse>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PostMapping("/createEmployee")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
		return new ResponseEntity<EmployeeResponse>(employeeService.createEmployee(employeeRequest),HttpStatus.CREATED);
	}
}
