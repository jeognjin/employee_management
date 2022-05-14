package controller;

public class EmployeeController {

	private static EmployeeController instance;
	
	private EmployeeController() {
	}
	
	public static EmployeeController getInstance() {
		if(instance == null) {
			instance = new EmployeeController(); 
		}
		return instance;
	}

	
	
	
	
	
}
