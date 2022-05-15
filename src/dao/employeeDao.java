package dao;

import java.sql.SQLException;
import java.util.Map;

import dto.Manager;

public interface EmployeeDao {

	//id, password 받아서 일치여부 확인 후 객체로 반환
	Manager selectLogin(Map<String, String> info) throws SQLException;

	Manager selectLogout(Map<String, String> info) throws SQLException;

	int insert(Manager manager) throws SQLException;

}
