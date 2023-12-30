package employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeService.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
