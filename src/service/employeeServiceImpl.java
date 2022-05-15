package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dto.Employee;
import dto.Manager;

public class EmployeeServiceImpl implements EmployeeService{
	
	private static EmployeeServiceImpl instance;
	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	private EmployeeServiceImpl() {
	}

	public static EmployeeServiceImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeServiceImpl();
		}
		return instance;
	}

	@Override //id,password 일치여부 확인 후 정보가 담긴 객체 또는 null값 반환
	public Manager login(Map<String, String> info) throws SQLException {
		Manager manager = dao.selectLogin(info);
		//id가 일치하는 객체를 받아서 객체의 비밀번호와 입력값 일치여부 확인
		if (manager != null && info.get("password").equals(manager.getManagerPassword())) {
			return manager;
		} else {
			return null;
		}
	}

	@Override //id,password 일치여부 확인 후 정보가 담긴 객체 또는 null값 반환
	public Manager logout(Map<String, String> info) throws SQLException {
		Manager manager = dao.selectLogout(info);
		//id가 일치하는 객체를 받아서 객체의 비밀번호와 입력값 일치여부 확인
		if (manager != null && info.get("password").equals(manager.getManagerPassword())) {
			return manager;
		} else {
			return null;
		}
	}

	//관리자등록
	@Override
	public int managerRegist(Manager manager) throws SQLException {
		return dao.insert(manager);
	}

	//관리자 삭제
	@Override
	public int managerResign(String managerId) throws SQLException {
		return dao.delete(managerId);
	}

	//직원목록
	@Override
	public List<Employee> empList() throws SQLException {
		return dao.empList();
	}

	//부서검색
	@Override
	public List<Employee> deptList(int deptNo) throws SQLException {
		return dao.deptList(deptNo);
	}

	//직원검색
	@Override
	public List<Employee> empSelect(String empName) throws SQLException {
		return dao.empSelect(empName);
	}

	//직원등록
	@Override
	public int empRegist(Employee emp) throws SQLException {
		return dao.empInsert(emp);
	}

	//직원삭제
	@Override
	public int empResign(int empNo) throws SQLException {
		return dao.empDelete(empNo);
	}

	//직원 정보수정
	@Override
	public int empUpdate(Employee emp) throws SQLException {
		return dao.empUpdate(emp);
	}

}
