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
	private List<Auftrag> Aufträge;

	/**
	 * @param aufträge
	 */
	public shop() {
		super();
		Aufträge = new ArrayList<Auftrag>();
	}

	@GET
	@Path("auftrag")
	public Response getAuftragAll() {
		//alle Aufträge holen
		Link self = Link.fromUri("https://.../auftrag")
						.rel("self")
						.build();
		Link first = Link.fromUri("https://.../auftrag/" + Aufträge.get(0).getNr())
						 .rel("first")
						 .build();
		Link last = Link.fromUri("https://.../auftrag/" + Aufträge.get(Aufträge.size() - 1).getNr())
						.rel("last")
						.build();
		return Response.ok(new GenericEntity<List<Auftrag>>(Aufträge) {})
					   .links(self, first, last)
					   .build();
	}
	
	@GET
	@Path("auftrag/{auftragsnr:[1-9][0-9]*}")
	public Response getAuftrag(@PathParam("auftragsnr") Integer auftragsnr) {
		//einen bestimmten Auftrag holen
		Link self = Link.fromUri("https://.../auftrag/" + auftragsnr)
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
		
		for(Auftrag auftrag : Aufträge) {
			if(auftrag.getNr().equals(auftragsnr))
				return Response.ok(auftrag)
							   .links(self, list, add, update, remove)
							   .build();
		}
		
		throw new NotFoundException("Kein Auftrag mit der Nr: " + auftragsnr + " gefunden.");
	}
		
	/*
	@GET
	@Path("{auftragsnr:[1-9][0-9]*}")
	public Response getAuftrag(@PathParam("auftragsnr") Integer auftragsnr) {
		//einen bestimmten Auftrag holen
	}
	
	@GET
	@Path("{auftragsnr:[1-9][0-9]*}/lieferant")
	public Response getLieferantAll(@PathParam("auftragsnr") Integer auftragsnr) {
		//alle Lieferanten zu einem bestimmten Auftrag holen
	}
	
	@GET
	@Path("{auftragsnr:[1-9][0-9]*}/lieferant/{lieferantennr:[1-9][0-9]*}")
	public Response getLieferant(@PathParam("auftragsnr") Integer auftragsnr, @PathParam("lieferantennr") Integer lieferantennr) {
		//einen bestimmten Lieferanten zu einem bestimmten Auftrag holen
	}
	
	@GET
	@Path("{auftragsnr:[1-9][0-9]*}/rechnung")
	public Response getRechnungAll(@PathParam("auftragsnr") Integer auftragsnr) {
		//alle Rechnungen zu einem bestimmten Auftrag holen
	}
	
	@GET
	@Path("{auftragsnr:[1-9][0-9]*}/rechnung/{rechnungsnr:[1-9][0-9]*}")
	public Response getRechnung(@PathParam("auftragsnr") Integer auftragsnr, @PathParam("rechnungsnr") Integer rechnungsnr) {
		//eine bestimmte Rechnung zu einem bestimmten Auftrag holen
	}
	
	@POST
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public Response createAuftrag(Auftrag auftrag) {
		//einen Auftrag anlegen
	}
	
	@PUT
	@Consumes({ APPLICATION_JSON, APPLICATION_XML, TEXT_XML })
	@Produces
	public void updateAuftrag(Auftrag auftrag) {
		//einen Auftrag ändern
	}
	
	@DELETE
	@Consumes
	@Produces
	public void deleteAuftrag(Integer auftragsnr) {
		//einen Auftrag löschen
		//in Wirklichkeit wird nicht gelöscht, sondern storniert
	}
	*/
}
