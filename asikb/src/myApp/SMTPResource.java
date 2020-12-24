package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/smtp")
public class SMTPResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SMTP> getSMTPSettings() {
		return SMTPDAO.instance.getSMTPSettings();
	}
}
