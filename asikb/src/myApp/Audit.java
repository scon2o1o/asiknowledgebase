package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "audit")
@XmlType(propOrder = { "datetime", "action", "user" })

public class Audit {
	private String datetime;
	private String action;
	private String user;

	public Audit(String timestamp, String action, String user) {
		super();
		this.datetime = timestamp;
		this.action = action;
		this.user = user;
	}

	public Audit() {
		super();
	}

	public Audit(String action, String user) {
		super();
		this.action = action;
		this.user = user;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
