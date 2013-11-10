package de.shop.kundenverwaltung.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.net.URI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.OrderColumn;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.util.Adresse;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Kunde")
@XmlRootElement
public class Kunde implements Serializable {

	/**
	 * @author Jan Krieghoff
	 */
	private static final long serialVersionUID = -423737514968775456L;
	
	private URI bestellungenUri;

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, updatable = false)
	@XmlAttribute
	private Long id;

	@Column(name = "aktualisiert", nullable = false)
	@Temporal(TIMESTAMP)
	@XmlTransient
	private Date aktualisiert;

	@Column(name = "erzeugt", nullable = false)
	@Temporal(TIMESTAMP)
	@XmlTransient
	private Date erzeugt;

	@Column(name = "anrede")
	@XmlElement(required = true)
	private String anrede;

	@Column(name = "eMail", unique = true, nullable = false)
	@XmlElement(required = true)
	private String eMail;

	@Column(name = "nachname", nullable = false)
	@Pattern(regexp = "[A-ZÄÖÜ][a-zäöüß]+") //TODO Wie war das nochmal mit den Umlauten?
	@XmlElement(required = true)
	private String nachname;

	@Column(name = "vorname", nullable = false)
	@XmlElement(required = true)
	private String vorname;
	
	@Column(name = "telefon")
	@XmlElement(required = true)
	private String telefon;

	@Valid
	private Adresse adresse;
	
	@Valid
	private Bankverbindung bankverbindung;

	@JoinColumn(name = "kunde_fk", nullable = false)
	@OrderColumn(name = "idx", nullable = false)
	@XmlTransient
	private List<Auftrag> auftraege;

	@Transient
	@XmlElement(name = "auftraege")
	private URI auftraegeUri;

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

	public Bankverbindung getBankverbindung() {
		return bankverbindung;
	}

	public void setBankverbindung(Bankverbindung bankverbindung) {
		this.bankverbindung = bankverbindung;
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
				+ ((bankverbindung == null) ? 0 : bankverbindung.hashCode());
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
		if (bankverbindung == null) {
			if (other.bankverbindung != null)
				return false;
		} else if (!bankverbindung.equals(other.bankverbindung))
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
				+ ", adresse=" + adresse + ", bankverbindung=" + bankverbindung
				+ ", auftraege=" + auftraege + ", auftraegeUri=" + auftraegeUri
				+ "]";
	}


}