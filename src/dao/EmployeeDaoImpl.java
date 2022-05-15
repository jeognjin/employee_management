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

	@Override //로그인
	public Manager selectLogin(Map<String, String> info) throws SQLException { //id가 일치하는 정보를 받아서 객체로 반환, 없으면 null반환
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

	@Override //로그아웃
	public Manager selectLogout(Map<String, String> info) throws SQLException {
		String sql = "select * from manager where manager_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, info.get("id"));
		rs = pstmt.executeQuery();
		if(rs.next()) {
		String id = rs.getString("manager_id");
		String password = rs.getString("manager_password");
		String name = rs.getString("manager_name");
		boolean loginCheck = false;
		return new Manager(id, password, name, loginCheck);
		}		
		return null;
	}

	@Override //관리자 등록
	public int insert(Manager manager) throws SQLException {
		String sql = "insert into manager values(?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, manager.getManagerId());
		pstmt.setString(2, manager.getManagerPassword());
		pstmt.setString(3, manager.getManagerName());
		return pstmt.executeUpdate();
	}

}
