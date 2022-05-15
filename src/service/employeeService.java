package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dto.Employee;
import dto.Manager;

public interface EmployeeService{

	Manager login(Map<String, String> info) throws SQLException;

	Manager logout(Map<String, String> info) throws SQLException;

	int managerRegist(Manager manager) throws SQLException;

	int managerResign(String managerId) throws SQLException;

	List<Employee> empList() throws SQLException;

	List<Employee> deptList(int deptNo) throws SQLException;

	List<Employee> empSelect(String empName) throws SQLException;

	int empRegist(Employee emp) throws SQLException;

	int empResign(int empNo) throws SQLException;

	int empUpdate(Employee emp) throws SQLException;
	
	

}
