package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/subcategories")
public class SubcategoryResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Subcategory> getSubcategories() {
		return SubcategoryDAO.instance.getSubcategories();
	}
}
