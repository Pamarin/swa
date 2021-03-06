package de.shop.bestellverwaltung.domain;

import java.math.BigDecimal;
import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jean-Luc Burot
 *
 */
@XmlRootElement
public class Rechnung {
	private Long id;
	private Boolean istBezahlt;
	private BigDecimal summe;
	URI auftragUri;
	Auftrag auftrag;
	
	/**
	 * 
	 */
	public Rechnung() {
		super();
	}

	/**
	 * @param nr Rechnungsnummer.
	 * @param istBezahlt Bezahltstatus.
	 * @param summe Monet�rer Betrag.
	 */
	public Rechnung(Long nr, Boolean istBezahlt, BigDecimal summe) {
		super();
		setId(nr);
		setIstBezahlt(istBezahlt);
		setSumme(summe);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id == null)
			throw new NullPointerException("Rechnungsnummer darf nicht leer sein.");

		this.id = id;
	}

	
	
	public Auftrag getAuftrag() {
		return auftrag;
	}

	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}

	public URI getAuftragUri() {
		return auftragUri;
	}
	public void setAuftragUri(URI auftragUri) {
		this.auftragUri = auftragUri;
	}

	/**
	 * @return Bezahltstatus.
	 */
	public Boolean getIstBezahlt() {
		return istBezahlt;
	}

	/**
	 * @param istBezahlt Bezahltstatus.
	 */
	public void setIstBezahlt(Boolean istBezahlt) {
		if(istBezahlt == null)
			throw new NullPointerException("Bezahlungsstatus muss richtig oder falsch sein.");
		
		this.istBezahlt = istBezahlt;
	}

	/**
	 * @return Monet�re Summe.
	 */
	public BigDecimal getSumme() {
		return summe;
	}

	/**
	 * @param summe Monet�re Summe.
	 */
	public void setSumme(BigDecimal summe) {
		if(summe == null || summe.compareTo(new BigDecimal(0)) < 0)
			throw new NullPointerException("Summe muss einen positiven oder neutralen Wert haben.");
		
		this.summe = summe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((istBezahlt == null) ? 0 : istBezahlt.hashCode());
		result = prime * result + ((summe == null) ? 0 : summe.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (istBezahlt == null) {
			if (other.istBezahlt != null)
				return false;
		} else if (!istBezahlt.equals(other.istBezahlt))
			return false;
		if (summe == null) {
			if (other.summe != null)
				return false;
		} else if (!summe.equals(other.summe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rechnung [getId()=" + getId() + ", getIstBezahlt()="
				+ getIstBezahlt() + ", getSumme()=" + getSumme() + "]";
	}
}
