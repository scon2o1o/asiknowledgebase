package myApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Email;
import dao.Utils;

public enum AuditDAO {
	instance;
	private Map<Integer, Audit> auditMap = new HashMap<Integer, Audit>();

	private AuditDAO() {
		loadFromDB();
	}

	public Map<Integer, Audit> loadFromDB() {
		auditMap.clear();
		try {
			Connection connection = Utils.getConnection();
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM audit ORDER BY datetime DESC");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Audit a = new Audit(rs.getString("datetime"), rs.getString("action"), rs.getString("user"));
				auditMap.put(auditMap.size() + 1, a);
			}
		} catch (Exception e) {
			Email.instance.sendErrorEmail(e, "Failed to load audit trail from the database", e.getMessage());
		}
		return auditMap;
	}

	public List<Audit> getAuditLog() {
		List<Audit> auditLog = new ArrayList<Audit>();
		auditLog.addAll(auditMap.values());
		return auditLog;
	}

	public void addEntry(String action, String user) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection
					.prepareStatement("INSERT INTO audit VALUES (current_timestamp(), ?, ?)");
			psmt.setString(1, action);
			psmt.setString(2, user);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			Email.instance.sendErrorEmail(e, "Failed to add new entry to the audit trail", e.getMessage());
		}
	}
}
