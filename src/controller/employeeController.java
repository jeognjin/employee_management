package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dto.Manager;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeController {

	private static EmployeeController instance;
	
	private static EmployeeService empService = EmployeeServiceImpl.getInstance();
	
	private EmployeeController() {
	}
	
	public static EmployeeController getInstance() {
		if(instance == null) {
			instance = new EmployeeController(); 
		}
		return instance;
	}

	public static Manager login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		
		Manager manager = null;
		
		try {
			manager = empService.login(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return manager;
	}

	
	
	
	
	
}
