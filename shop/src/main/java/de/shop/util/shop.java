package de.shop.util;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.bestellverwaltung.domain.Auftrag;

@XmlRootElement
@Path("")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.75" })
public class shop {
	@XmlTransient
	private List<Auftrag> Auftraege;

	/**
	 * @param auftraege
	 */
	public shop() {
		super();
		Auftraege = new ArrayList<Auftrag>();
	}

	@GET
	@Path("auftrag")
	public Response getAuftragAll() {
		//alle Auftraege holen
		Link self = Link.fromUri("https://.../auftrag")
						.rel("self")
						.build();
		Link first = Link.fromUri("https://.../auftrag/" + Auftraege.get(0).getId())
						 .rel("first")
						 .build();
		Link last = Link.fromUri("https://.../auftrag/" + Auftraege.get(Auftraege.size() - 1).getId())
						.rel("last")
						.build();
		return Response.ok(new GenericEntity<List<Auftrag>>(Auftraege) {})
					   .links(self, first, last)
					   .build();
	}
	
	@GET
	@Path("auftrag/{auftragsnr:[1-9][0-9]*}")
	public Response getAuftrag(@PathParam("auftragsid") Integer auftragsid) {
		//einen bestimmten Auftrag holen
		Link self = Link.fromUri("https://.../auftrag/" + auftragsid)
						.rel("self")
						.build();
		Link list = Link.fromUri("https://.../auftrag")
						.rel("list")
						.build();
		Link add = Link.fromUri("https://.../auftrag")
					   .rel("add")
					   .build();
		Link update = Link.fromUri("https://.../auftrag")
						  .rel("update")
						  .build();
		Link remove = Link.fromUri("https://.../auftrag")
						  .rel("update")
						  .build();
		
		for(Auftrag auftrag : Auftraege) {
			if(auftrag.getId().equals(auftragsid))
				return Response.ok(auftrag)
							   .links(self, list, add, update, remove)
							   .build();
		}
		
		throw new NotFoundException("Kein Auftrag mit der AuftragsId: " + auftragsid + " gefunden.");
	}
}
