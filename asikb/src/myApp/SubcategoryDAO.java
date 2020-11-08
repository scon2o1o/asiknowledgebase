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

public enum SubcategoryDAO {
	instance;
	private Map<Integer, Subcategory> subcategoryMap = new HashMap<Integer, Subcategory>();

	private SubcategoryDAO() {
		loadFromDB();
	}

	public Map<Integer, Subcategory> loadFromDB() {
		subcategoryMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM subcategories ORDER BY name ASC");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Subcategory c = new Subcategory(rs.getInt("id"), rs.getString("name"));
				subcategoryMap.put(subcategoryMap.size() + 1, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subcategoryMap;
	}

	public List<Subcategory> getSubcategories() {
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		subcategories.addAll(subcategoryMap.values());
		return subcategories;
	}

	public void addSubcategory(String name, String user) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO subcategories VALUES (0, ?)");
			psmt.setString(1, name);
			psmt.executeUpdate();
			loadFromDB();
			AuditDAO.instance.addEntry("New subcategory added. Name: '" + name + "'", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editSubcategory(String subcategory, String newname) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("UPDATE subcategories SET name = ? WHERE name = ?");
			psmt.setString(1, newname);
			psmt.setString(2, subcategory);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSubcategory(String subcategory) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("DELETE FROM subcategories WHERE name = ?");
			psmt.setString(1, subcategory);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
