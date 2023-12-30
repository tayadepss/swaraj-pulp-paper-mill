package departmentService.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import departmentService.exceptionClasses.DeptNotExist;

@ControllerAdvice
public class DepartmentControllerAdvice {
	
	@ExceptionHandler(value=DeptNotExist.class)
	public ResponseEntity<String> deptNotExistException(DeptNotExist ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
}
