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
	 * @author Jan Krieghoff
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
		//TODO Plausibilität prüfen
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		//TODO Plausibilität prüfen
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		//TODO Plausibilität prüfen
		this.strasse = strasse;
	}

	@Override
	public String toString() {
		return "Anschrift [anschriftID=" + anschriftID + ", aktualisiert="
				+ aktualisiert + ", erzeugt=" + erzeugt + ", hausnummer="
				+ hausnummer + ", ort=" + ort + ", plz=" + plz + ", strasse="
				+ strasse + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aktualisiert == null) ? 0 : aktualisiert.hashCode());
		result = prime * result
				+ ((anschriftID == null) ? 0 : anschriftID.hashCode());
		result = prime * result + ((erzeugt == null) ? 0 : erzeugt.hashCode());
		result = prime * result
				+ ((hausnummer == null) ? 0 : hausnummer.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Anschrift other = (Anschrift) obj;
		if (aktualisiert == null) {
			if (other.aktualisiert != null)
				return false;
		} else if (!aktualisiert.equals(other.aktualisiert))
			return false;
		if (anschriftID == null) {
			if (other.anschriftID != null)
				return false;
		} else if (!anschriftID.equals(other.anschriftID))
			return false;
		if (erzeugt == null) {
			if (other.erzeugt != null)
				return false;
		} else if (!erzeugt.equals(other.erzeugt))
			return false;
		if (hausnummer == null) {
			if (other.hausnummer != null)
				return false;
		} else if (!hausnummer.equals(other.hausnummer))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		return true;
	}

}
