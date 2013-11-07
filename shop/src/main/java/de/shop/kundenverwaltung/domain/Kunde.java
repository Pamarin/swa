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
	
	private URI auftraegeUri1;

	@Id
	@GeneratedValue
	@Column(name = "kunde_ID", nullable = false, updatable = false)
	@XmlAttribute
	private Long kundeID;

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
	private Anschrift anschrift;

	@JoinColumn(name = "kunde_fk", nullable = false)
	@OrderColumn(name = "idx", nullable = false)
	@XmlTransient
	private List<Auftrag> auftraege;

	@Transient
	@XmlElement(name = "auftraege")
	private URI auftraegeUri;

	public URI getAuftraegeUri() {
		return auftraegeUri1;
	}

	public void setAuftraegeUri(URI auftraegeUri) {
		this.auftraegeUri1 = auftraegeUri;
	}

	public void setValues(Kunde k) {
		nachname = k.nachname;
		vorname = k.vorname;
		eMail = k.eMail;
	}

	public Long getKundeID() {
		return this.kundeID;
	}

	public void setKundeID(Long kundeID) {
		this.kundeID = kundeID;
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

	public Anschrift getAnschrift() {
		return anschrift;
	}

	public void setAnschrift(Anschrift anschrift) {
		this.anschrift = anschrift;
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
	
	public URI getAuftraegeUri1() {
		return auftraegeUri1;
	}
	public void setBestellungenUri(URI bestellungenUri) {
		this.auftraegeUri1 = bestellungenUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kundeID == null) ? 0 : kundeID.hashCode());
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
		if (kundeID == null) {
			if (other.kundeID != null)
				return false;
		}
		else if (!kundeID.equals(other.kundeID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kunde [kundeID=" + kundeID + ", anrede=" + anrede + ", eMail="
				+ eMail + ", nachname=" + nachname + ", telefon=" + telefon
				+ ", vorname=" + vorname + ", anschrift=" + anschrift + "]";
	}

}