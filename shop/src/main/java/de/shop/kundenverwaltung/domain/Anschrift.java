package de.shop.kundenverwaltung.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class Anschrift implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2761718968924894847L;

	@Id
	@GeneratedValue
	@Column(name = "anschrift_ID", nullable = false, updatable = false)
	@XmlAttribute
	private Long anschriftID;

	@Column(name = "aktualisiert", nullable = false)
	@Temporal(TIMESTAMP)
	private Date aktualisiert;

	@Column(name = "erzeugt", nullable = false)
	@Temporal(TIMESTAMP)
	@XmlTransient
	private Date erzeugt;

	@Column(name = "hausnummer", nullable = false)
	@XmlElement(required = true)
	private String hausnummer;

	@Column(name = "ort", nullable = false)
	@XmlElement(required = true)
	private String ort;

	@Column(name = "plz", nullable = false)
	@XmlElement(required = true)
	private String plz;

	@Column(name = "strasse", nullable = false)
	@XmlElement(required = true)
	private String strasse;

	public Long getAnschriftID() {
		return anschriftID;
	}

	public void setAnschriftID(Long anschriftID) {
		this.anschriftID = anschriftID;
	}

	public Date getAktualisiert() {
		return aktualisiert;
	}

	public void setAktualisiert(Date aktualisiert) {
		this.aktualisiert = aktualisiert;
	}

	public Date getErzeugt() {
		return erzeugt;
	}

	public void setErzeugt(Date erzeugt) {
		this.erzeugt = erzeugt;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

}
