package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "smtp")
@XmlType(propOrder = { "server", "port", "auth", "starttls", "fromaddress", "username", "password" })

public class SMTP {
	private String server;
	private Integer port;
	private String auth;
	private String starttls;
	private String fromaddress;
	private String username;
	private String password;

	public SMTP(String server, Integer port, String auth, String starttls, String fromaddress, String username, String password) {
		super();
		this.server = server;
		this.port = port;
		this.auth = auth;
		this.starttls = starttls;
		this.fromaddress = fromaddress;
		this.username = username;
		this.password = password;
	}

	public SMTP() {
		super();
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getStarttls() {
		return starttls;
	}

	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}

	public String getFromaddress() {
		return fromaddress;
	}

	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
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
}
