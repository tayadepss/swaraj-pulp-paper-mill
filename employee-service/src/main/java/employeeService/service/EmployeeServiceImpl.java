package employeeService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employeeService.dto.AddressResponse;
import employeeService.dto.EmployeeRequest;
import employeeService.dto.EmployeeResponse;
import employeeService.model.Address;
import employeeService.model.Employee;
import employeeService.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private	EmployeeRepository employeeRepository;
	@Override
	public List<EmployeeResponse> getAllEmployee() {
		List<EmployeeResponse> employees=employeeRepository.findAll().stream().map(emp->mapToEmployeeRespnse(emp)).collect(Collectors.toList());
		log.info("return list of employees");
		return employees;
	}
	private EmployeeResponse mapToEmployeeRespnse(Employee emp) {
		EmployeeResponse employeeRespone=modelMapper.map(emp, EmployeeResponse.class);
		AddressResponse addressResponse=modelMapper.map(emp.getAddress(),AddressResponse.class);
		employeeRespone.setAddressResponse(addressResponse);
		return employeeRespone;
	}
	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		Employee employee=modelMapper.map(employeeRequest, Employee.class);
		employee.setAddress(modelMapper.map(employeeRequest.getAddressRequest(),Address.class));
		 
		employee=employeeRepository.save(employee);
		EmployeeResponse employeeResponse=modelMapper.map(employee, EmployeeResponse.class);
		 employeeResponse.setAddressResponse(modelMapper.map(employee.getAddress(),AddressResponse.class));
		 log.info("employee record store in database and return");
		return employeeResponse;
	}

}
