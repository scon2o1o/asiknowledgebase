package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categories")
public class CategoryResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Category> getCategories() {
		return CategoryDAO.instance.getCategories();
	}
}
