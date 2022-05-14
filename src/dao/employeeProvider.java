package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class employeeProvider {

	private static Connection conn;

	private employeeProvider() {}

	public static Connection getInstance() {
		try {
			if (conn == null) {

				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";
				String password = "tiger";
				conn = DriverManager.getConnection(url, user, password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
