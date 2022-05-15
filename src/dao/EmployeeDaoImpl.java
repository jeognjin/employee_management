package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.Employee;
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

	@Override //관리자 삭제
	public int delete(String managerId) throws SQLException {
		String sql = "delete from manager where manager_id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, managerId);
		return pstmt.executeUpdate();
	}

	@Override //직원목록 array list 로 반환
	public List<Employee> empList() throws SQLException {
		String sql = "select * from employee";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Employee> employees = listUp(rs);
		
		
		return employees;
	}

	@Override //부서번호를 받아서 deptList 반환
	public List<Employee> deptList(int deptNo) throws SQLException {
		String sql = "select * from employee where department_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptNo);
		rs = pstmt.executeQuery();
		List<Employee> employees = listUp(rs);
		return employees;
	}
	

	//직원이름을 받아서 해당 직원 검색 후 arraylist로 반환
	@Override
	public List<Employee> empSelect(String empName) throws SQLException {
		String sql = "select * from employee where department_name like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, empName);
		rs = pstmt.executeQuery();
		List<Employee> employees = listUp(rs);
		return employees;
	}
	
	//ResultSet으로 받은 정보를 arraylist로 반환
	private List<Employee> listUp(ResultSet rs2) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		if(rs.next()) {
			int empNo = rs.getInt("emp_no");
			String name = rs.getString("name");
			int departmentNo = rs.getInt("department_no");
			String departmentName = rs.getString("department_name");
			String position = rs.getString("position");
			int salary = rs.getInt("salary");
			employees.add(new Employee(empNo, name, departmentNo, departmentName, position, salary));
		}
		return employees;
	}

	//직원등록
	@Override
	public int empInsert(Employee emp) throws SQLException {
		String sql = "insert into employee values(?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, emp.getEmpNo());
		pstmt.setString(2, emp.getName());
		pstmt.setInt(3, emp.getDepartmentNo());
		pstmt.setString(4, emp.getDepartmentName());
		pstmt.setString(5, emp.getPosition());
		pstmt.setInt(6, emp.getSalary());
		return pstmt.executeUpdate();
	}

	//직원삭제
	@Override
	public int empDelete(int empNo) throws SQLException {
		String sql = "delete from employee where emp_no =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empNo);
		return pstmt.executeUpdate();
	}

	//직원 정보수정
	@Override
	public int empUpdate(Employee emp) throws SQLException {
		String sql = "update employee set name = ?, department_no = ?, department_name = ?, position = ?, salary = ? where emp_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getName());
		pstmt.setInt(2, emp.getDepartmentNo());
		pstmt.setString(3, emp.getDepartmentName());
		pstmt.setString(4, emp.getPosition());
		pstmt.setInt(5, emp.getSalary());
		pstmt.setInt(6, emp.getEmpNo());
		return pstmt.executeUpdate();
	}

}
