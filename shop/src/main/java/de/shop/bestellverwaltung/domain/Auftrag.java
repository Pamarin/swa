package de.shop.bestellverwaltung.domain;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.kundenverwaltung.domain.Kunde;


/**
 * @author Jean-Luc Burot
 *
 */
@XmlRootElement
public class Auftrag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3378371456188800702L;

	/**
	 * 
	 */

	public enum AuftragsStatus {
		InBearbeitung,
		Abgeschlossen
	}
	
	private Long id;
	private AuftragsStatus status;
	@XmlTransient
	private List<Lieferant> lieferant;
	@XmlTransient
	private List<Rechnung> rechnung;
	@XmlTransient
	private Kunde kunde;
	private URI kundeUri;
	
	/**
	 * @param nr Auftragsnummer.
	 */
	public Auftrag() {
		super();
		setStatus(AuftragsStatus.InBearbeitung);
		this.lieferant = new ArrayList<Lieferant>();
		this.rechnung = new ArrayList<Rechnung>();
	}
	
	/**
	 * @return Auftragsnummer.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id Auftragsnummer.
	 */
	public void setId(Long id) {
		if(id == null)
			throw new NullPointerException("Id muss einen Wert haben.");

		this.id = id;
	}
		
	/**
	 * @return Auftragsstatus.
	 */
	public AuftragsStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status Auftragsstatus.
	 */
	public void setStatus(AuftragsStatus status) {
		if(status == null)
			throw new NullPointerException("Auftragsstatus muss einen Wert haben.");
		
		this.status = status;
	}
	
	/**
	 * @param lieferant Lieferant.
	 * @throws LieferantException
	 */
	public void addLieferant(Lieferant lieferant) throws LieferantException {
		if(this.lieferant.contains(lieferant))
			throw new LieferantException("Lieferant bereits vorhanden.");
		
		this.lieferant.add(lieferant);
	}
	
	/**
	 * @param lieferant Lieferant.
	 * @throws LieferantException
	 */
	public void delLieferant(Lieferant lieferant) throws LieferantException {
		if(!this.lieferant.contains(lieferant))
			throw new LieferantException("Gesuchter Lieferant nicht vorhanden.");
		
		this.lieferant.remove(lieferant);
	}
	
	/**
	 * @param id Lieferantennummer.
	 * @return Lieferant.
	 * @throws LieferantException
	 */
	public Lieferant getLieferant(Long id) throws LieferantException {		
		for(Lieferant lieferant : this.lieferant) {
			if(lieferant.getId() == id)
				return lieferant;
		}
		
		throw new LieferantException("Gesuchter Lieferant nicht vorhanden.");
	}
	
	/**
	 * @return Lieferantenliste.
	 */
	public List<Lieferant> getLieferantAll() {
		return this.lieferant;
	}
	
	/**
	 * @param rechnung Rechnung.
	 * @throws RechnungException
	 */
	public void addRechnung(Rechnung rechnung) throws RechnungException {
		if(this.rechnung.contains(rechnung))
			throw new RechnungException("Rechnung bereits vorhanden.");
		
		this.rechnung.add(rechnung);
	}
	
	/**
	 * @param rechnung Rechnung.
	 * @throws RechnungException
	 */
	public void delRechnung(Rechnung rechnung) throws RechnungException {
		if(!this.rechnung.contains(rechnung))
			throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		this.rechnung.remove(rechnung);
	}
	
	/**
	 * @param id Rechnungsnummer.
	 * @return Rechnung.
	 * @throws RechnungException
	 */
	public Rechnung getRechnung(Long id) throws RechnungException {
		if(this.rechnung == null)
			throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		for(Rechnung rechnung : this.rechnung) {
			if(rechnung.getId() == id)
				return rechnung;
		}
		
		throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
	}
	
	/**
	 * @return Rechnungsliste.
	 */
	public List<Rechnung> getRechnungAll() {
		return this.rechnung;
	}
	
	/**
	 * @return Kunde.
	 */
	public Kunde getKunde() {
		return kunde;
	}

	/**
	 * @param kunde Kunde.
	 */
	public void setKunde(Kunde kunde) {
		if(kunde == null)
			throw new NullPointerException("Es muss ein Kunde vorhanden sein.");
		
		this.kunde = kunde;
	}
	
	public URI getKundeUri() {
		return kundeUri;
	}

	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result
				+ ((kundeUri == null) ? 0 : kundeUri.hashCode());
		result = prime * result
				+ ((lieferant == null) ? 0 : lieferant.hashCode());
		result = prime * result
				+ ((rechnung == null) ? 0 : rechnung.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auftrag other = (Auftrag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		if (kundeUri == null) {
			if (other.kundeUri != null)
				return false;
		} else if (!kundeUri.equals(other.kundeUri))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auftrag [id=" + id + ", status=" + status + ", lieferant="
				+ lieferant + ", rechnung=" + rechnung + ", kunde=" + kunde
				+ ", kundeUri=" + kundeUri + "]";
	}
	
	
}
