package de.shop.artikelverwaltung.domain;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

public class Artikel {
	// geschrieben von Marvin
	// ToDo Beans Validation für Verfügbarkeit
	
	enum Verfügbarkeit{
		istVerfügbar,
		istNichtVerfügbar,
		istNachbestellt,
	}
	
	@NotNull
	@Pattern (regexp = "\\d{8}")
	private String artikelnummer;
	
	@NotNull																//sinnvoll?
	@Size(min =3, max = 30)
	@Pattern(regexp = "[A-Z0123456789][a-z0123456789][a-z 0123456789]+")	// \w?
	private String bezeichnung;
	
	@NotNull
	@DecimalMin("0,99")
	private BigDecimal preis;
	
	private Verfügbarkeit Status;
	
	public BigDecimal getPreis() {
		return preis;
	}
	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getArtikelnummer() {
		return artikelnummer;
	}
	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}
	public Verfügbarkeit getStatus() {
		return Status;
	}
	public void setStatus(Verfügbarkeit status) {
		Status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result
				+ ((artikelnummer == null) ? 0 : artikelnummer.hashCode());
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
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
		Artikel other = (Artikel) obj;
		if (Status != other.Status)
			return false;
		if (artikelnummer == null) {
			if (other.artikelnummer != null)
				return false;
		} else if (!artikelnummer.equals(other.artikelnummer))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (preis == null) {
			if (other.preis != null)
				return false;
		} else if (!preis.equals(other.preis))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Artikel [artikelnummer=" + artikelnummer + ", bezeichnung="
				+ bezeichnung + ", preis=" + preis + ", Status=" + Status + "]";
	}	
}