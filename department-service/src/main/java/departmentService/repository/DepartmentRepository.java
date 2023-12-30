package departmentService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import departmentService.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByDeptName(String dept);
}
