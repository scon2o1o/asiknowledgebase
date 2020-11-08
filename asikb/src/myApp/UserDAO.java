package myApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Email;
import dao.Utils;

public enum UserDAO {
	instance;
	private Map<Integer, User> userMap = new HashMap<Integer, User>();
	
	private UserDAO() {
		loadFromDB();
	}
	
	public Map<Integer, User> loadFromDB() {
		userMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection
					.prepareStatement("SELECT * FROM users");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getString("username"),
						rs.getString("password"), rs.getString("firstnames"),
						rs.getString("surname"), rs.getString("canadd"),
						rs.getString("canedit"), rs.getString("isadmin"));
				userMap.put(userMap.size() + 1, u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMap;
	}

	public User checkLogin(String username, String password) {
		Connection connection = Utils.getConnection();
		User user = null;

		try {
			PreparedStatement psmt = connection
					.prepareStatement("SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ?");
			psmt.setString(1, username);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("username"),
						rs.getString("password"),
						rs.getString("firstnames"),
						rs.getString("surname"),
						rs.getString("canadd"),
						rs.getString("canedit"),
						rs.getString("isadmin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User save(User user, String user2) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection
					.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)");
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getFirstnames());
			psmt.setString(4, user.getSurname());
			psmt.setString(5, user.getCanadd());
			psmt.setString(6, user.getCanedit());
			psmt.setString(7, user.getIsadmin());
			psmt.executeUpdate();
			loadFromDB();
			AuditDAO.instance.addEntry("New user added. Username: '" + user.getUsername() + "'", user2);
		} catch (SQLException e) {
			Email.instance.sendErrorEmail(e, "ASIKB - Error adding new user", "User '" + user2 + "' encountered the following error when trying to add a new user");
		}
		return user;
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.addAll(userMap.values());
		return users;
	}

	public void editUser(User user) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection
					.prepareStatement("UPDATE users set firstnames = ?, surname = ?, canadd = ?, canedit = ?, isadmin = ? where username = ?");
			psmt.setString(1, user.getFirstnames());
			psmt.setString(2, user.getSurname());
			psmt.setString(3, user.getCanadd());
			psmt.setString(4, user.getCanedit());
			psmt.setString(5, user.getIsadmin());
			psmt.setString(6, user.getUsername());
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String username) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection
					.prepareStatement("DELETE FROM users WHERE username = ?");
			psmt.setString(1, username);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editUserPassword(String username, String password) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection
					.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
			psmt.setString(1, password);
			psmt.setString(2, username);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
