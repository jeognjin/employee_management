package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Employee;
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
	public static int managerRegist(Manager manager) {
		int result = 0;
		try {
			result = empService.managerRegist(manager);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//관리자 삭제
	public static int managerResign(String managerId) {
		int result = 0;
		try {
			result = empService.managerResign(managerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//직원목록
	public static List<Employee> empList() {
		List<Employee> employees = null;
		try {
			employees = empService.empList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	//부서번호를 받아서 해당 부서의 목록 반환
	public static List<Employee> deptList(int deptNo) {
		List<Employee> employees = null;
		try {
			employees = empService.deptList(deptNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	//직원검색
	public static List<Employee> empSelect(String empName) {
		List<Employee> employees = null;
		try {
			employees = empService.empSelect(empName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	//직원 등록
	public static int empRegist(Employee emp) {
		int result = 0;
		try {
			result = empService.empRegist(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//직원삭제
	public static int empResign(int empNo) {
		int result = 0;
		try {
			result = empService.empResign(empNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//직원 정보수정
	public static int empUpdate(Employee emp) {
		int result = 0;
		try {
			result = empService.empUpdate(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}




	
	
	
	
	
}
