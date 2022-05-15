package service;

import java.sql.SQLException;
import java.util.Map;

import dto.Manager;

public interface EmployeeService{

	Manager login(Map<String, String> info) throws SQLException;

	Manager logout(Map<String, String> info) throws SQLException;

	int regist(Manager manager) throws SQLException;
	
	

}
