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

import de.shop.bestellverwaltung.domain.Lieferant;
import de.shop.util.Mock;
import de.shop.util.NotFoundException;
import de.shop.util.UriHelper;

/**
 * @author Jean-Luc Burot
 */
@Path("/lieferant")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class LieferantResource {
	public static final String LIEFERANTEN_ID_PATH_PARAM = "lieferantenid";
	
	@Context
	private UriInfo uriInfo;
	@Inject
	private UriHelper uriHelper;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findLieferantById(@PathParam("id") Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Lieferant lieferant = Mock.findLieferantById(id);
		if (lieferant == null)
			throw new NotFoundException("Kein Lieferant mit der ID " + id + " gefunden.");
		
		// Link-Header setzen
		final Response response = Response.ok(lieferant)
                                          .links(getTransitionalLinks(lieferant, uriInfo))
                                          .build();
		
		return response;
	}
	
	private Link[] getTransitionalLinks(Lieferant lieferant, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriLieferant(lieferant, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] { self };
	}
	
	public URI getUriLieferant(Lieferant lieferant, UriInfo uriInfo) {
		return uriHelper.getUri(LieferantResource.class, "findLieferantById", lieferant.getId(), uriInfo);
	}

	
	@POST
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createLieferant(Lieferant lieferant) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		return Response.created(getUriLieferant(Mock.createLieferant(lieferant), uriInfo))
			           .build();
	}
	
	@PUT
	@Consumes({APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateLieferant(Lieferant lieferant) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.updateLieferant(lieferant);
	}
	
	@DELETE
	@Path("{id:[1-9][0-9]*}")
	@Produces
	public void deleteLieferant(@PathParam("id") Long liefernantId) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		Mock.deleteLieferant(liefernantId);
	}
}
