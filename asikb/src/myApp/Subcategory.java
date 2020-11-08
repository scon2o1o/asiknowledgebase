package myApp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "subcategories")
@XmlType(propOrder = { "id", "name" })

public class Subcategory {
	private Integer id;
	private String name;
	
	public Subcategory(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Subcategory() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
