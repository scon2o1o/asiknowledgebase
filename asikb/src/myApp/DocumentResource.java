package myApp;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/documents")
public class DocumentResource {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Document> getDocuments() {
		return DocumentDAO.instance.getDocs();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/top10/")
	public List<Document> getDocumentsTop10() {
		return DocumentDAO.instance.getDocsTop10();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML })
	@Path("/text/")
	public List<Document> getDocumentsText() {
		return DocumentDAO.instance.getDocs();
	}
}
