package myApp;

public class ViewUser {
	private String username;
	private String firstnames;
	private String surname;
	private String canadd;
	private String canedit;
	private String isadmin;
	
	public ViewUser(String username, String firstnames, String surname, String canadd, String canedit, String isadmin) {
		super();
		this.username = username;
		this.firstnames = firstnames;
		this.surname = surname;
		this.canadd = canadd;
		this.canedit = canedit;
		this.isadmin = isadmin;
	}

	public ViewUser() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
