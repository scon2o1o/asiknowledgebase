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

public enum DocumentDAO {
	instance;
	private Map<Integer, Document> docsMap = new HashMap<Integer, Document>();

	private DocumentDAO() {
		loadFromDB();
	}

	public Map<Integer, Document> loadFromDB() {
		docsMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM docs order by dateadded desc");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Document d = new Document(rs.getInt("id"), rs.getString("name"), rs.getString("details"), rs.getString("url"), rs.getString("category"), rs.getString("dateadded"), rs.getString("author"), rs.getInt("likes"), rs.getString("lastmodified"), rs.getString("subcategory"));
				docsMap.put(docsMap.size() + 1, d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docsMap;
	}

	public Map<Integer, Document> loadTop10FromDB() {
		docsMap.clear();
		try {
			Connection connection = Utils.getConnection();

			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM docs order by dateadded desc limit 10");

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Document d = new Document(rs.getInt("id"), rs.getString("name"), rs.getString("details"), rs.getString("url"), rs.getString("category"), rs.getString("dateadded"), rs.getString("author"), rs.getInt("likes"), rs.getString("lastmodified"), rs.getString("subcategory"));
				docsMap.put(docsMap.size() + 1, d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docsMap;
	}

	public Document save(Document doc, String user) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO docs VALUES (?, ?, ?, ?, ?, current_timestamp(), ?, 0, current_timestamp(), ?)");
			psmt.setInt(1, doc.getId());
			psmt.setString(2, doc.getName());
			psmt.setString(3, doc.getDetails());
			psmt.setString(4, doc.getUrl());
			psmt.setString(5, doc.getCategory());
			psmt.setString(6, doc.getAuthor());
			psmt.setString(7, doc.getSubcategory());
			psmt.executeUpdate();
			loadFromDB();
			PreparedStatement psmt2 = connection.prepareStatement("SELECT id FROM docs WHERE name = ?");
			psmt2.setString(1, doc.getName());
			ResultSet result = psmt2.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("id");
				AuditDAO.instance.addEntry("New document '" + doc.getName() + "' added. Document ID: " + id, user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public List<Document> getDocs() {
		List<Document> docs = new ArrayList<Document>();
		docs.addAll(docsMap.values());
		return docs;
	}

	public List<Document> getDocsTop10() {
		loadTop10FromDB();
		List<Document> docs = new ArrayList<Document>();
		docs.addAll(docsMap.values());
		return docs;
	}

	public void deleteDoc(Integer id, String user, String name) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("DELETE FROM docs WHERE id = ?");
			psmt.setInt(1, id);
			psmt.executeUpdate();
			loadFromDB();
			AuditDAO.instance.addEntry("Document '" + name + "' deleted. Document ID: " + id, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editDoc(Integer id, String name, String details, String url, String category, String subcategory) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement("UPDATE docs SET name = ?, details = ?, url = ?, lastmodified = current_timestamp(), category = ?, subcategory = ? WHERE id = ?");
			psmt.setString(1, name);
			psmt.setString(2, details);
			psmt.setString(3, url);
			psmt.setString(4, category);
			psmt.setString(5, subcategory);
			psmt.setInt(6, id);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void likeDoc(int id, String username) {
		Connection connection = Utils.getConnection();

		try {
			PreparedStatement psmt2 = connection.prepareStatement("INSERT INTO docslikes VALUES (?, ?, current_timestamp())");
			psmt2.setInt(1, id);
			psmt2.setString(2, username);
			psmt2.executeUpdate();

			PreparedStatement psmt = connection.prepareStatement("update docs set likes = (select count(*) from docslikes where id = ?) where id = ?;");
			psmt.setInt(1, id);
			psmt.setInt(2, id);
			psmt.executeUpdate();
			loadFromDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
