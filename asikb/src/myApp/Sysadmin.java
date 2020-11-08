package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sysadmin")
@XmlType(propOrder = { "username", "email" })

public class Sysadmin {
	
	private String username;
	private String email;
	
	public Sysadmin(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public Sysadmin() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
