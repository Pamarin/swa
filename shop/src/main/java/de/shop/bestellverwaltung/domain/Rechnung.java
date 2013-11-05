package de.shop.bestellverwaltung.domain;

import java.math.BigDecimal;

public class Rechnung {

	private Integer Nr;
	private Boolean IstBezahlt;
	private BigDecimal Summe;
	
	public Rechnung(Integer nr, Boolean istBezahlt, BigDecimal summe) {
		super();
		setNr(nr);
		setIstBezahlt(istBezahlt);
		setSumme(summe);
	}

	public Integer getNr() {
		return Nr;
	}

	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Rechnungsnummer darf nicht leer sein.");
		
		Nr = nr;
	}

	public Boolean getIstBezahlt() {
		return IstBezahlt;
	}

	public void setIstBezahlt(Boolean istBezahlt) {
		if(istBezahlt == null)
			throw new NullPointerException("Bezahlungsstatus muss richtig oder falsch sein.");
		
		IstBezahlt = istBezahlt;
	}

	public BigDecimal getSumme() {
		return Summe;
	}

	public void setSumme(BigDecimal summe) {
		if(summe == null || summe.compareTo(new BigDecimal(0)) < 0)
			throw new NullPointerException("Summe muss einen positiven oder neutralen Wert haben.");
		
		Summe = summe;
	}
	
	@Override
	public String toString() {
		return "Rechnung [Nr: " + getNr() + ", bezahlt: "
				+ getIstBezahlt() + ", Summe: " + getSumme() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IstBezahlt == null) ? 0 : IstBezahlt.hashCode());
		result = prime * result + ((Nr == null) ? 0 : Nr.hashCode());
		result = prime * result + ((Summe == null) ? 0 : Summe.hashCode());
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
		Rechnung other = (Rechnung) obj;
		if (IstBezahlt == null) {
			if (other.IstBezahlt != null)
				return false;
		} else if (!IstBezahlt.equals(other.IstBezahlt))
			return false;
		if (Nr == null) {
			if (other.Nr != null)
				return false;
		} else if (!Nr.equals(other.Nr))
			return false;
		if (Summe == null) {
			if (other.Summe != null)
				return false;
		} else if (!Summe.equals(other.Summe))
			return false;
		return true;
	}
}
