package departmentService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departmentService.client.EmployeeClient;
import departmentService.dto.DepartmentRequest;
import departmentService.dto.DepartmentResponse;
import departmentService.dto.DeptWithEmployeeResponse;
import departmentService.dto.EmployeeResponse;
import departmentService.exceptionClasses.DeptNotExist;
import departmentService.model.Department;
import departmentService.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeClient employeeClient;
	
	@Override
	public List<DepartmentResponse> getAllDept() {
		return departmentRepository.findAll().stream().map(dept->mapToDepartmentResponse(dept)).collect(Collectors.toList());		
	}

	private DepartmentResponse mapToDepartmentResponse(Department dept) {
		return modelMapper.map(dept, DepartmentResponse.class);		
	}

	@Override
	public DepartmentResponse createDept(DepartmentRequest departmentRequest) {
			return modelMapper.map(departmentRepository.save(modelMapper.map(departmentRequest, Department.class)),DepartmentResponse.class);
	}

	@Override
	public DeptWithEmployeeResponse getDeptWithEmployees(String dept) {
		DeptWithEmployeeResponse deptWithEmployeeResponse=new DeptWithEmployeeResponse();
		Department department=departmentRepository.findByDeptName(dept).orElseThrow(()-> new DeptNotExist(dept));
		deptWithEmployeeResponse=modelMapper.map(department, DeptWithEmployeeResponse.class);
		deptWithEmployeeResponse.setEmployees(employeeClient.getAllEmployee());
		log.info("Department with employee return");
		return deptWithEmployeeResponse;		
	}
	
}
