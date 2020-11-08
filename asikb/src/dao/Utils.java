package dao;

import java.sql.*;

public class Utils {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/kbdata";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, "root", "pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
