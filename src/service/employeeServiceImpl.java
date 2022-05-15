package service;

import java.sql.SQLException;
import java.util.Map;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
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

	@Override
	public int regist(Manager manager) throws SQLException {
		return dao.insert(manager);
	}

}
