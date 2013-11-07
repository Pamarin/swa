package de.shop.bestellverwaltung.rest;

import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.util.Mock;
import de.shop.util.NotFoundException;
import de.shop.util.UriHelper;

/**
 * @author Jean-Luc Burot
 */
@Path("/auftrag")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class AuftragResource {
	public static final String AUFTRAGS_ID_PATH_PARAM = "auftragsid";
	
	@Context
	private UriInfo uriInfo;
	@Inject
	private UriHelper uriHelper;
	
	/*
	@GET
	public Response getAuftragAlle() {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final List<Auftrag> auftraege = Mock.findAllAuftraege();
		if(auftraege.size() <= 0)
			throw new NotFoundException("Keine Auftraege gefunden");
		
		final Response response = Response.ok(new GenericEntity<List<Auftrag>>(auftraege) {})
										  .links(getTransitionalLinks(auftrag, uriInfo))
										  
	}
	*/
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findAuftragById(@PathParam("id") Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Auftrag auftrag = Mock.findAuftragById(id);
		if (auftrag == null)
			throw new NotFoundException("Kein Auftrag mit der ID " + id + " gefunden.");
		
		// Link-Header setzen
		final Response response = Response.ok(auftrag)
                                          .links(getTransitionalLinks(auftrag, uriInfo))
                                          .build();
		
		return response;
	}
	
	private Link[] getTransitionalLinks(Auftrag auftrag, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriAuftrag(auftrag, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] { self };
	}
	
	public URI getUriAuftrag(Auftrag auftrag, UriInfo uriInfo) {
		return uriHelper.getUri(AuftragResource.class, "findAuftragById", auftrag.getId(), uriInfo);
	}

	
	@POST
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createAuftrag(Auftrag auftrag) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		return Response.created(getUriAuftrag(Mock.createAuftrag(auftrag), uriInfo))
			           .build();
	}
	
	@PUT
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateAuftrag(Auftrag auftrag) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.updateAuftrag(auftrag);
	}
	
	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces
	public void deleteAuftrag(@PathParam("id") Long auftragId) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.deleteAuftrag(auftragId);
	}
}
