package departmentService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import departmentService.dto.DepartmentRequest;
import departmentService.dto.DepartmentResponse;
import departmentService.dto.DeptWithEmployeeResponse;
import departmentService.dto.EmployeeResponse;
import departmentService.employeeClient.EmployeeClient;
import departmentService.exceptionClasses.DeptNotExist;
import departmentService.model.Department;
import departmentService.repository.DepartmentRepository;
@Service
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
		return deptWithEmployeeResponse;		
	}
	
}
