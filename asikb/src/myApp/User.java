package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "users")
@XmlType(propOrder = { "username", "password", "firstnames", "surname", "canadd",
		"canedit", "isadmin" })

public class User {
	private String username;
	private String password;
	private String firstnames;
	private String surname;
	private String canadd;
	private String canedit;
	private String isadmin;
	
	public User(String username, String password, String firstnames, String surname, String canadd, String canedit,
			String isadmin) {
		super();
		this.username = username;
		this.password = password;
		this.firstnames = firstnames;
		this.surname = surname;
		this.canadd = canadd;
		this.canedit = canedit;
		this.isadmin = isadmin;
	}

	public User(String username, String firstnames, String surname, String canadd, String canedit, String isadmin) {
		super();
		this.username = username;
		this.firstnames = firstnames;
		this.surname = surname;
		this.canadd = canadd;
		this.canedit = canedit;
		this.isadmin = isadmin;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstnames() {
		return firstnames;
	}

	public void setFirstnames(String firstnames) {
		this.firstnames = firstnames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCanadd() {
		return canadd;
	}

	public void setCanadd(String canadd) {
		this.canadd = canadd;
	}

	public String getCanedit() {
		return canedit;
	}

	public void setCanedit(String canedit) {
		this.canedit = canedit;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
}
