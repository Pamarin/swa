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
import de.shop.bestellverwaltung.domain.Rechnung;
import de.shop.util.Mock;
import de.shop.util.NotFoundException;
import de.shop.util.UriHelper;

/**
 * @author Jean-Luc Burot
 */
@Path("/rechnung")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class RechnungResource {
	public static final String LIEFERANTEN_ID_PATH_PARAM = "id";
	
	@Context
	private UriInfo uriInfo;
	@Inject
	private UriHelper uriHelper;
	@Inject
	private AuftragResource auftragResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findRechnungById(@PathParam(LIEFERANTEN_ID_PATH_PARAM) Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Rechnung rechnung = Mock.findRechnungById(id);
		if (rechnung == null)
			throw new NotFoundException("Kein Rechnung mit der ID " + id + " gefunden.");
		
		// Link-Header setzen
		final Response response = Response.ok(rechnung)
                                          .links(getTransitionalLinks(rechnung, uriInfo))
                                          .build();
		
		return response;
	}
	
	private Link[] getTransitionalLinks(Rechnung rechnung, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriRechnung(rechnung, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] { self };
	}
	
	public URI getUriRechnung(Rechnung rechnung, UriInfo uriInfo) {
		return uriHelper.getUri(RechnungResource.class, "findRechnungById", rechnung.getId(), uriInfo);
	}

	
	@POST
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createRechnung(Rechnung rechnung) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		return Response.created(getUriRechnung(Mock.createRechnung(rechnung), uriInfo))
			           .build();
	}
	
	@PUT
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateRechnung(Rechnung rechnung) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.updateRechnung(rechnung);
	}
	
	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces
	public void deleteRechnung(@PathParam("id") Long liefernantId) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.deleteRechnung(liefernantId);
	}
	
	public void setStructuralLinks(Rechnung rechnung, UriInfo uriInfo) {
		// URI fuer Kunde setzen
		final Auftrag auftrag = rechnung.getAuftrag();
		if (auftrag != null) {
			final URI auftragUri = auftragResource.getUriAuftrag(rechnung.getAuftrag(), uriInfo);
			rechnung.setAuftragUri(auftragUri);
		}
	}
}
