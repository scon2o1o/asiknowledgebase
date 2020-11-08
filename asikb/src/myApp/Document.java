package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "documents")
@XmlType(propOrder = { "id", "name", "details", "url", "category", "dateadded", "author", "likes", "lastmodified", "subcategory" })

public class Document {
	private int id;
	private String name;
	private String details;
	private String url;
	private String category;
	private String dateadded;
	private String author;
	private int likes;
	private String lastmodified;
	private String subcategory;

	public Document(int id, String name, String details, String url, String category, String dateadded, String author, int likes, String lastmodified, String subcategory) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.url = url;
		this.category = category;
		this.dateadded = dateadded;
		this.author = author;
		this.likes = likes;
		this.lastmodified = lastmodified;
		this.subcategory = subcategory;
	}

	public Document(String name, String details, String url, String category, String author, String subcategory) {
		super();
		this.name = name;
		this.details = details;
		this.url = url;
		this.category = category;
		this.author = author;
		this.subcategory = subcategory;
	}

	public Document(int id, String name, String details, String url) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.url = url;
	}

	public Document(String name, String details, String url) {
		super();
		this.name = name;
		this.details = details;
		this.url = url;
	}

	public Document() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDateadded() {
		return dateadded;
	}

	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(String lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
}
