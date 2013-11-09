package de.shop.bestellverwaltung.rest;

import static de.shop.util.Constants.SELF_LINK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.kundenverwaltung.rest.KundeResource;
import de.shop.util.Mock;
import de.shop.util.rest.NotFoundException;
import de.shop.util.rest.UriHelper;

/**
 * @author <a href="mailto:Juergen.Zimmermann@HS-Karlsruhe.de">J&uuml;rgen Zimmermann</a>
 */
@Path("/auftrag")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class AuftragResource {
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UriHelper uriHelper;
	
	@Inject
	private KundeResource kundeResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findBestellungById(@PathParam("id") Long id) {
		// TODO Anwendungskern statt Mock, Verwendung von Locale
		final Auftrag auftrag = Mock.findAuftragById(id);
		if (auftrag == null) {
			throw new NotFoundException("Keine Bestellung mit der ID " + id + " gefunden.");
		}
		
		setStructuralLinks(auftrag, uriInfo);
		
		// Link-Header setzen
		final Response response = Response.ok(auftrag)
                                          .links(getTransitionalLinks(auftrag, uriInfo))
                                          .build();
		
		return response;
	}
	
	public void setStructuralLinks(Auftrag auftrag, UriInfo uriInfo) {
		// URI fuer Kunde setzen
		final Kunde kunde = auftrag.getKunde();
		if (kunde != null) {
			final URI kundeUri = kundeResource.getUriKunde(auftrag.getKunde(), uriInfo);
			auftrag.setKundeUri(kundeUri);
		}
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
}
