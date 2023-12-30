package departmentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import departmentService.dto.DepartmentRequest;
import departmentService.dto.DepartmentResponse;
import departmentService.dto.DeptWithEmployeeResponse;
import departmentService.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/getAllDept")
	public ResponseEntity<List<DepartmentResponse>> getAllDept(){
		return new ResponseEntity<List<DepartmentResponse>>(departmentService.getAllDept(),HttpStatus.OK);
	}
	@PostMapping("/createDept")
	public ResponseEntity<DepartmentResponse> createDept(@RequestBody DepartmentRequest departmentRequest){
		return new ResponseEntity<DepartmentResponse>(departmentService.createDept(departmentRequest),HttpStatus.CREATED);
	}
	@GetMapping("/DeptWithEmployees/{dept}")
	public ResponseEntity<DeptWithEmployeeResponse> getDeptWithEmployees(@PathVariable("dept") String dept){
		return new ResponseEntity<DeptWithEmployeeResponse>(departmentService.getDeptWithEmployees(dept),HttpStatus.OK);
		
	}
}
