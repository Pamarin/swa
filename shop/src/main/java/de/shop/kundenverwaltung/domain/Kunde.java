package de.shop.kundenverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.util.Adresse;

@XmlRootElement
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Kunde implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2403403122238680481L;
	/**
	 * @author Jan Krieghoff
	 */
	
	private URI bestellungenUri;
	private Long id;
	private Date aktualisiert;
	private Date erzeugt;
	private String anrede;
	private String eMail;
	private String nachname;
	private String vorname;
	private String telefon;
	private Adresse adresse;
	private URI auftraegeUri;
	
	@XmlTransient
	private List<Auftrag> auftraege;
	
	public URI getAuftraegeUri() {
		return auftraegeUri;
	}

	public void setAuftraegeUri(URI auftraegeUri) {
		this.auftraegeUri = auftraegeUri;
	}

	public void setValues(Kunde k) {
		nachname = k.nachname;
		vorname = k.vorname;
		eMail = k.eMail;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAktualisiert() {
		return (Date) this.aktualisiert.clone();
	}

	public void setAktualisiert(Date aktualisiert) {
		this.aktualisiert = (Date) aktualisiert.clone();
	}

	public String getAnrede() {
		return this.anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String paramEMail) {
		this.eMail = paramEMail;
	}

	public Date getErzeugt() {
		return (Date) this.erzeugt.clone();
	}

	public void setErzeugt(Date erzeugt) {
		this.erzeugt = (Date) erzeugt.clone();
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<Auftrag> getAuftraege() {
		return Collections.unmodifiableList(auftraege);
	}

	public void setAuftraege(List<Auftrag> auftraege) {
		if (this.auftraege == null) {
			this.auftraege = auftraege;
			return;
		}

		this.auftraege.clear();
		if (auftraege != null) {
			this.auftraege.addAll(auftraege);
		}
	}

	public Kunde addAuftrag(Auftrag auftrag) {
		if (auftraege == null) {
			auftraege = new ArrayList<>();
		}
		auftraege.add(auftrag);
		return this;
	}
	
	public URI getBestellungenUri() {
		return bestellungenUri;
	}
	public void setBestellungenUri(URI bestellungenUri) {
		this.bestellungenUri = bestellungenUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((aktualisiert == null) ? 0 : aktualisiert.hashCode());
		result = prime * result + ((anrede == null) ? 0 : anrede.hashCode());
		result = prime * result
				+ ((auftraege == null) ? 0 : auftraege.hashCode());
		result = prime * result
				+ ((auftraegeUri == null) ? 0 : auftraegeUri.hashCode());
		result = prime * result
				+ ((bestellungenUri == null) ? 0 : bestellungenUri.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((erzeugt == null) ? 0 : erzeugt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((telefon == null) ? 0 : telefon.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Kunde other = (Kunde) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (aktualisiert == null) {
			if (other.aktualisiert != null)
				return false;
		} else if (!aktualisiert.equals(other.aktualisiert))
			return false;
		if (anrede == null) {
			if (other.anrede != null)
				return false;
		} else if (!anrede.equals(other.anrede))
			return false;
		if (auftraege == null) {
			if (other.auftraege != null)
				return false;
		} else if (!auftraege.equals(other.auftraege))
			return false;
		if (auftraegeUri == null) {
			if (other.auftraegeUri != null)
				return false;
		} else if (!auftraegeUri.equals(other.auftraegeUri))
			return false;
		if (bestellungenUri == null) {
			if (other.bestellungenUri != null)
				return false;
		} else if (!bestellungenUri.equals(other.bestellungenUri))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (erzeugt == null) {
			if (other.erzeugt != null)
				return false;
		} else if (!erzeugt.equals(other.erzeugt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kunde [bestellungenUri=" + bestellungenUri + ", id=" + id
				+ ", aktualisiert=" + aktualisiert + ", erzeugt=" + erzeugt
				+ ", anrede=" + anrede + ", eMail=" + eMail + ", nachname="
				+ nachname + ", vorname=" + vorname + ", telefon=" + telefon
				+ ", adresse=" + adresse + ", auftraegeUri=" + auftraegeUri
				+ ", auftraege=" + auftraege + "]";
	}
}