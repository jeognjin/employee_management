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

	@Override
	public Manager login(Map<String, String> info) throws SQLException {
		Manager manager = dao.selectOne(info);
		if (manager != null && info.get("password").equals(manager.getManagerPassword())) {
			return manager;
		} else {
			return null;
		}
	}

}
