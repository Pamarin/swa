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

	public Long getid() {
		return this.id;
	}

	public void setid(Long id) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ", anrede=" + anrede + ", eMail="
				+ eMail + ", nachname=" + nachname + ", telefon=" + telefon
				+ ", vorname=" + vorname + ", adresse=" + adresse + "]";
	}

}