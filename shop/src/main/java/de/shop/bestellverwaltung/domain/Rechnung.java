package de.shop.bestellverwaltung.domain;

import java.math.BigDecimal;

public class Rechnung {

	private Integer Nr;
	private Boolean IstBezahlt;
	private BigDecimal Summe;
	
	/**
	 * @param nr Rechnungsnummer.
	 * @param istBezahlt Bezahltstatus.
	 * @param summe Monetärer Betrag.
	 */
	public Rechnung(Integer nr, Boolean istBezahlt, BigDecimal summe) {
		super();
		setNr(nr);
		setIstBezahlt(istBezahlt);
		setSumme(summe);
	}

	/**
	 * @return Rechnungsnummer.
	 */
	public Integer getNr() {
		return Nr;
	}

	/**
	 * @param nr Rechnungsnummer.
	 */
	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Rechnungsnummer darf nicht leer sein.");
		
		Nr = nr;
	}

	/**
	 * @return Bezahltstatus.
	 */
	public Boolean getIstBezahlt() {
		return IstBezahlt;
	}

	/**
	 * @param istBezahlt Bezahltstatus.
	 */
	public void setIstBezahlt(Boolean istBezahlt) {
		if(istBezahlt == null)
			throw new NullPointerException("Bezahlungsstatus muss richtig oder falsch sein.");
		
		IstBezahlt = istBezahlt;
	}

	/**
	 * @return Monetäre Summe.
	 */
	public BigDecimal getSumme() {
		return Summe;
	}

	/**
	 * @param summe Monetäre Summe.
	 */
	public void setSumme(BigDecimal summe) {
		if(summe == null || summe.compareTo(new BigDecimal(0)) < 0)
			throw new NullPointerException("Summe muss einen positiven oder neutralen Wert haben.");
		
		Summe = summe;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rechnung [Nr: " + getNr() + ", bezahlt: "
				+ getIstBezahlt() + ", Summe: " + getSumme() + "]";
	}
}
