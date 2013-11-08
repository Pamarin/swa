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
	private Long id;
	@XmlTransient
	private String name;
	@XmlTransient
	private Adresse adresseLieferant;
	@XmlTransient
	private Integer lieferzeit;
	
	/**
	 * 
	 */
	public Lieferant() {
		super();
	}

	/**
	 * @param nr Lieferantennummer.
	 * @param name Lieferantenname.
	 * @param adresseLieferant Lieferantenadresse.
	 * @param lieferzeit Lieferzeit.
	 */
	public Lieferant(Long nr, String name, Adresse adresseLieferant, Integer lieferzeit) {
		super();
		setId(nr);
		setName(name);
		setAdresseLieferant(adresseLieferant);
		setLieferzeit(lieferzeit);
	}

	/**
	 * @return Lieferzeit.
	 */
	public Integer getLieferzeit() {
		return lieferzeit;
	}

	/**
	 * @param lieferzeit Lieferzeit in Tagen.
	 */
	public void setLieferzeit(Integer lieferzeit) {
		if(lieferzeit == null)
			throw new NullPointerException("Lieferant muss Lieferzeit haben.");
		if(lieferzeit <= 0)
			throw new NullPointerException("Lieferant muss Lieferzeit >0 Tage haben.");
		
		this.lieferzeit = lieferzeit;
	}

	/**
	 * @return Lieferantenadresse.
	 */
	public Adresse getAdresseLieferant() {
		return adresseLieferant;
	}

	/**
	 * @param adresseLieferant Lieferantenadresse.
	 */
	public void setAdresseLieferant(Adresse adresseLieferant) {
		if(adresseLieferant == null)
			throw new NullPointerException("Lieferant muss Adresse haben.");
		
		this.adresseLieferant = adresseLieferant;
	}
	
	/**
	 * @return Lieferantennummer.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id Lieferantennummer.
	 */
	public void setId(Long id) {
		if(id == null)
			throw new NullPointerException("Lieferantennummer darf nicht leer sein.");

		this.id = id;
	}
	
	/**
	 * @return Lieferantenname.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name Lieferantenname.
	 */
	public void setName(String name) {
		if(name == null || name == "")
			throw new NullPointerException("Lieferantenname darf nicht leer sein.");
		
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((adresseLieferant == null) ? 0 : adresseLieferant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lieferzeit == null) ? 0 : lieferzeit.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Lieferant other = (Lieferant) obj;
		if (adresseLieferant == null) {
			if (other.adresseLieferant != null)
				return false;
		} else if (!adresseLieferant.equals(other.adresseLieferant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieferzeit == null) {
			if (other.lieferzeit != null)
				return false;
		} else if (!lieferzeit.equals(other.lieferzeit))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lieferant [getLieferzeit()=" + getLieferzeit()
				+ ", getAdresseLieferant()=" + getAdresseLieferant()
				+ ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
