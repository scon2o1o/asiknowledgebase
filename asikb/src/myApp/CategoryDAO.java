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

public enum CategoryDAO {
	instance;
	private Map<Integer, Category> categoryMap = new HashMap<Integer, Category>();

	private CategoryDAO() {
		loadFromDB();
	}

	public Map<Integer, Category> loadFromDB() {
		categoryMap.clear();
		try {
			Connection connection = Utils.getConnection();
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM categories ORDER BY name ASC");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Category c = new Category(rs.getInt("id"), rs.getString("name"));
				categoryMap.put(categoryMap.size() + 1, c);
			}
		} catch (Exception e) {
			Email.instance.sendErrorEmail(e, "Failed to load categories from the database", e.getMessage());
		}
		return categoryMap;
	}

	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		categories.addAll(categoryMap.values());
		return categories;
	}

	public void addCategory(String name, String username) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO categories VALUES (0, ?)");
			psmt.setString(1, name);
			psmt.executeUpdate();
			AuditDAO.instance.addEntry("New category added: '" + name + "'", username);
			loadFromDB();
		} catch (SQLException e) {
			Email.instance.sendErrorEmail(e, "Failed to add new category", e.getMessage());
		}
	}

	public void editCategory(String category, String newname) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection.prepareStatement("UPDATE categories SET name = ? WHERE name = ?");
			psmt.setString(1, newname);
			psmt.setString(2, category);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			Email.instance.sendErrorEmail(e, "Failed to edit category", e.getMessage());
		}
	}

	public void deleteCategory(String category, String user) {
		Connection connection = Utils.getConnection();
		try {
			PreparedStatement psmt = connection.prepareStatement("DELETE FROM categories WHERE name = ?");
			psmt.setString(1, category);
			psmt.executeUpdate();
			loadFromDB();
			AuditDAO.instance.addEntry("Category deleted. Name: '" + category + "'", user);
		} catch (SQLException e) {
			Email.instance.sendErrorEmail(e, "Failed to delete category", e.getMessage());
		}

	}
}
