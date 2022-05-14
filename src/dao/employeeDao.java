package dao;

import java.sql.SQLException;
import java.util.Map;

import dto.Manager;

public interface EmployeeDao {

	Manager selectOne(Map<String, String> info) throws SQLException;

}
