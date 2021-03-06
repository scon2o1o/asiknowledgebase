package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sysadmin")
public class SysadminResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Sysadmin> getSysadmin() {
		return SysadminDAO.instance.getSysadmin();
	}
}
