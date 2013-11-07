package de.shop.bestellverwaltung.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.util.Adresse;

/**
 * @author Jean-Luc Burot
 *
 */
@XmlRootElement
public class Lieferant {
	@XmlTransient
	private Integer Nr;
	@XmlTransient
	private String Name;
	@XmlTransient
	private Adresse AdresseLieferant;
	@XmlTransient
	private Integer Lieferzeit;
	
	/**
	 * @param nr Lieferantennummer.
	 * @param name Lieferantenname.
	 * @param adresseLieferant Lieferantenadresse.
	 * @param lieferzeit Lieferzeit.
	 */
	public Lieferant(Integer nr, String name, Adresse adresseLieferant, Integer lieferzeit) {
		super();
		setNr(nr);
		setName(name);
		setAdresseLieferant(adresseLieferant);
		setLieferzeit(lieferzeit);
	}

	/**
	 * @return Lieferzeit.
	 */
	public Integer getLieferzeit() {
		return Lieferzeit;
	}

	/**
	 * @param lieferzeit Lieferzeit in Tagen.
	 */
	public void setLieferzeit(Integer lieferzeit) {
		if(lieferzeit == null)
			throw new NullPointerException("Lieferant muss Lieferzeit haben.");
		if(lieferzeit <= 0)
			throw new NullPointerException("Lieferant muss Lieferzeit >0 Tage haben.");
		
		Lieferzeit = lieferzeit;
	}

	/**
	 * @return Lieferantenadresse.
	 */
	public Adresse getAdresseLieferant() {
		return AdresseLieferant;
	}

	/**
	 * @param adresseLieferant Lieferantenadresse.
	 */
	public void setAdresseLieferant(Adresse adresseLieferant) {
		if(adresseLieferant == null)
			throw new NullPointerException("Lieferant muss Adresse haben.");
		
		AdresseLieferant = adresseLieferant;
	}
	
	/**
	 * @return Lieferantennummer.
	 */
	public Integer getNr() {
		return Nr;
	}

	/**
	 * @param nr Lieferantennummer.
	 */
	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Lieferantennummer darf nicht leer sein.");
		
		Nr = nr;
	}
	
	/**
	 * @return Lieferantenname.
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * @param name Lieferantenname.
	 */
	public void setName(String name) {
		if(name == null || name == "")
			throw new NullPointerException("Lieferantenname darf nicht leer sein.");
		
		Name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((AdresseLieferant == null) ? 0 : AdresseLieferant.hashCode());
		result = prime * result
				+ ((Lieferzeit == null) ? 0 : Lieferzeit.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Nr == null) ? 0 : Nr.hashCode());
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
		Lieferant other = (Lieferant) obj;
		if (AdresseLieferant == null) {
			if (other.AdresseLieferant != null)
				return false;
		} else if (!AdresseLieferant.equals(other.AdresseLieferant))
			return false;
		if (Lieferzeit == null) {
			if (other.Lieferzeit != null)
				return false;
		} else if (!Lieferzeit.equals(other.Lieferzeit))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Nr == null) {
			if (other.Nr != null)
				return false;
		} else if (!Nr.equals(other.Nr))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lieferant [Nr: " + getNr() + ", Name: " + getName()
				+ ", Adresse: " + getAdresseLieferant() + "]";
	}
}
