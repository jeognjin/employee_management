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

	//로그인
	public static Manager login(Map<String, String> info) {
		Manager manager = null;
		try {
			manager = empService.login(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return manager;
	}

	//로그아웃
	public static Manager logout(Map<String, String> info) {
		Manager manager = null;
		boolean loginCheck = true;
		
		try {
			manager = empService.logout(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}

	//관리자 등록
	public static int regist(Manager manager) {
		int result = 0;
		try {
			result = empService.regist(manager);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}



	
	
	
	
	
}
