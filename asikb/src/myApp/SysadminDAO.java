package myApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Utils;

public enum SysadminDAO {
	instance;

	private Map<Integer, Sysadmin> sysadminMap = new HashMap<Integer, Sysadmin>();

	private SysadminDAO() {
		loadFromDB();
	}

	private Map<Integer, Sysadmin> loadFromDB() {
		sysadminMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection.prepareStatement("SELECT adminuser, adminemail FROM sysinfo");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Sysadmin u = new Sysadmin(rs.getString("adminuser"), rs.getString("adminemail"));
				sysadminMap.put(sysadminMap.size() + 1, u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysadminMap;
		
	}

	public List<Sysadmin> getSysadmin() {
		List<Sysadmin> sysadmin = new ArrayList<Sysadmin>();
		sysadmin.addAll(sysadminMap.values());
		return sysadmin;
	}

	public void editSysadmin(String username, String email) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("UPDATE sysinfo SET adminuser = ?, adminemail = ?");
			psmt.setString(1, username);
			psmt.setString(2, email);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
