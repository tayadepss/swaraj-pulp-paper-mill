package departmentService.exceptionClasses;

public class DeptNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeptNotExist(String dept) {
		super("Department with name "+dept+" not xist");
	}
}
