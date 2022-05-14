package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dto.Manager;

public class EmployeeDaoImpl implements EmployeeDao{

	private static Connection conn = EmployeeProvider.getInstance();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static EmployeeDaoImpl instance;
	
	private EmployeeDaoImpl() {
	}
	
	public static EmployeeDaoImpl getInstance() {
		if(instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	@Override
	public Manager selectOne(Map<String, String> info) throws SQLException {
		String sql = "select * from manager where manager_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, info.get("id"));
		rs = pstmt.executeQuery();
		if(rs.next()) {
		String id = rs.getString("manager_id");
		String password = rs.getString("manager_password");
		String name = rs.getString("manager_name");
		boolean loginCheck = true;
		return new Manager(id, password, name, loginCheck);
		}		
		return null;
	}

}
