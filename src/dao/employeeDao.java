package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Employee;
import dto.Manager;

public interface EmployeeDao {

	//id, password 받아서 일치여부 확인 후 객체로 반환
	Manager selectLogin(Map<String, String> info) throws SQLException;

	Manager selectLogout(Map<String, String> info) throws SQLException;

	int insert(Manager manager) throws SQLException;

	int delete(String managerId) throws SQLException;

	List<Employee> empList() throws SQLException;

	List<Employee> deptList(int deptNo) throws SQLException;

	List<Employee> empSelect(String empName) throws SQLException;

	int empInsert(Employee emp) throws SQLException;

	int empDelete(int empNo) throws SQLException;

	int empUpdate(Employee emp) throws SQLException;

}
