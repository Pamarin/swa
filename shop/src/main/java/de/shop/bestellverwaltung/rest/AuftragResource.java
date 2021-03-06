package de.shop.bestellverwaltung.rest;

import static de.shop.util.Constants.FIRST_LINK;
import static de.shop.util.Constants.LAST_LINK;
import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;
import java.util.List;

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
import javax.ws.rs.core.GenericEntity;
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
@Path("/auftrag")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class AuftragResource {
	public static final String AUFTRAGS_ID_PATH_PARAM = "id";
	
	@Context
	private UriInfo uriInfo;
	@Inject
	private UriHelper uriHelper;
	@Inject
	private RechnungResource rechnungResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findAuftragById(@PathParam(AUFTRAGS_ID_PATH_PARAM) Long id) {
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
	
	@GET
	public Response findAuftraege() {
		List<Auftrag> auftraege = Mock.findAllAuftraege();
		
		return Response.ok(new GenericEntity<List<Auftrag>>(auftraege){})
                       .links(getTransitionalLinksAuftraege(auftraege, uriInfo))
                       .build();
	}
	
	
	
	@GET
	@Path("{id:[1-9][0-9]*}/rechnung")
	public Response findRechnungenByAuftragId(@PathParam("id") Long auftragId) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Auftrag auftrag = Mock.findAuftragById(auftragId);
		final List<Rechnung> rechnungen = Mock.findRechnungenByAuftrag(auftrag);
		if (rechnungen.isEmpty()) {
			throw new NotFoundException("Zur ID " + auftragId + " wurden keine Rechnungen gefunden");
		}
		
		// URIs innerhalb der gefundenen Rechnungen anpassen
		for (Rechnung rechnung : rechnungen) {
			rechnungResource.setStructuralLinks(rechnung, uriInfo);
		}
		
		return Response.ok(new GenericEntity<List<Rechnung>>(rechnungen){})
                       .links(getTransitionalLinksRechnungen(rechnungen, uriInfo))
                       .build();
	}
	
	private Link[] getTransitionalLinksRechnungen(List<Rechnung> rechnungen, UriInfo uriInfo) {
		if (rechnungen == null || rechnungen.isEmpty()) {
			return null;
		}
		
		final Link first = Link.fromUri(getUriRechnung(rechnungen.get(0), uriInfo))
	                           .rel(FIRST_LINK)
	                           .build();
		final int lastPos = rechnungen.size() - 1;
		final Link last = Link.fromUri(getUriRechnung(rechnungen.get(lastPos), uriInfo))
                              .rel(LAST_LINK)
                              .build();
		
		return new Link[] { first, last };
	}

	public URI getUriRechnung(Rechnung rechnung, UriInfo uriInfo) {
		return uriHelper.getUri(RechnungResource.class, "findRechnungById", rechnung.getId(), uriInfo);
	}
	
	public void setStructuralLinks(Auftrag auftrag, UriInfo uriInfo) {
		// URI fuer Rechnungen setzen
		final URI uri = getUriRechnungen(auftrag, uriInfo);
		auftrag.setRechnungenUri(uri);
	}

	private URI getUriRechnungen(Auftrag kunde, UriInfo uriInfo) {
		return uriHelper.getUri(AuftragResource.class, "findRechnungenByAuftragId", kunde.getId(), uriInfo);
	}		
	
	private Link[] getTransitionalLinks(Auftrag auftrag, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriAuftrag(auftrag, uriInfo))
                              .rel(SELF_LINK)
                              .build();
		return new Link[] { self };
	}
	
	private Link[] getTransitionalLinksAuftraege(List<Auftrag> auftraege, UriInfo uriInfo) {
		if (auftraege == null || auftraege.isEmpty())
			return null;
		
		final Link first = Link.fromUri(getUriAuftrag(auftraege.get(0), uriInfo))
	                           .rel(FIRST_LINK)
	                           .build();
		final int lastPos = auftraege.size() - 1;
		final Link last = Link.fromUri(getUriAuftrag(auftraege.get(lastPos), uriInfo))
                              .rel(LAST_LINK)
                              .build();
		
		return new Link[] { first, last };
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
