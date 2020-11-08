package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

@Path("/users")
public class UserResource {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		return UserDAO.instance.getUsers();
	}
}
