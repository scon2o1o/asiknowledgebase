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

public enum SMTPDAO {
	instance;

	private Map<Integer, SMTP> smtpMap = new HashMap<Integer, SMTP>();

	private SMTPDAO() {
		loadFromDB();
	}

	private Map<Integer, SMTP> loadFromDB() {
		smtpMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection.prepareStatement("SELECT smtpserver, smtpport, smtpauth, smtpstarttls, smtpfromaddress, smtpusername, smtppassword  FROM sysinfo");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				SMTP u = new SMTP(rs.getString("smtpserver"), rs.getInt("smtpport"), rs.getString("smtpauth"), rs.getString("smtpstarttls"), rs.getString("smtpfromaddress"), rs.getString("smtpusername"), rs.getString("smtppassword"));
				smtpMap.put(smtpMap.size() + 1, u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smtpMap;
	}

	public List<SMTP> getSMTPSettings() {
		List<SMTP> smtp = new ArrayList<SMTP>();
		smtp.addAll(smtpMap.values());
		return smtp;
	}

	public void editSMTPSettings(String server, int port, String auth, String starttls, String fromaddress, String username, String password) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("UPDATE sysinfo SET smtpserver = ?, smtpport = ?, smtpauth = ?, smtpstarttls = ?, smtpfromaddress = ?, smtpusername = ?, smtppassword = ?");
			psmt.setString(1, server);
			psmt.setInt(2, port);
			psmt.setString(3, auth);
			psmt.setString(4, starttls);
			psmt.setString(5, fromaddress);
			psmt.setString(6, username);
			psmt.setString(7, password);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
