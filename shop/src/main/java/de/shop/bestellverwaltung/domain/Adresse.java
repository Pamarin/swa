package de.shop.bestellverwaltung.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Jean-Luc Burot
 *
 */
@XmlRootElement
public class Adresse {
	@XmlTransient
	private String Strasse;
	@XmlTransient
	private String PLZ;
	@XmlTransient
	private String Stadt;
	@XmlTransient
	private String Land;
	
	/**
	 * @param strasse Straﬂe.
	 * @param pLZ Postleitzahl.
	 * @param stadt Stadt.
	 * @param land Land.
	 */
	public Adresse(String strasse, String pLZ, String stadt, String land) {
		super();
		setStrasse(strasse);
		setPLZ(pLZ);
		setStadt(stadt);
		setLand(land);
	}

	/**
	 * @return Straﬂe.
	 */
	public String getStrasse() {
		return Strasse;
	}
	
	/**
	 * @param strasse Straﬂe.
	 */
	public void setStrasse(String strasse) {
		if(strasse == null || strasse == "")
			throw new NullPointerException("Straﬂe muss einen Namen haben.");
		
		Strasse = strasse;
	}
	
	/**
	 * @return Postleitzahl.
	 */
	public String getPLZ() {
		return PLZ;
	}
	
	/**
	 * @param pLZ Postleitzahl.
	 */
	public void setPLZ(String pLZ) {
		if(pLZ == null || pLZ == "")
			throw new NullPointerException("PLZ muss einen Wert habe.");
		
		PLZ = pLZ;
	}
	
	/**
	 * @return Stadt.
	 */
	public String getStadt() {
		return Stadt;
	}
	
	/**
	 * @param stadt Stadt.
	 */
	public void setStadt(String stadt) {
		if(stadt == null || stadt == "")
			throw new NullPointerException("Stadt muss einen Namen haben.");
		
		Stadt = stadt;
	}
	
	/**
	 * @return Land.
	 */
	public String getLand() {
		return Land;
	}
	
	/**
	 * @param land Land.
	 */
	public void setLand(String land) {
		if(land == null || land == "")
			throw new NullPointerException("Land muss einen Namen haben.");
		
		Land = land;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Land == null) ? 0 : Land.hashCode());
		result = prime * result + ((PLZ == null) ? 0 : PLZ.hashCode());
		result = prime * result + ((Stadt == null) ? 0 : Stadt.hashCode());
		result = prime * result + ((Strasse == null) ? 0 : Strasse.hashCode());
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
		Adresse other = (Adresse) obj;
		if (Land == null) {
			if (other.Land != null)
				return false;
		} else if (!Land.equals(other.Land))
			return false;
		if (PLZ == null) {
			if (other.PLZ != null)
				return false;
		} else if (!PLZ.equals(other.PLZ))
			return false;
		if (Stadt == null) {
			if (other.Stadt != null)
				return false;
		} else if (!Stadt.equals(other.Stadt))
			return false;
		if (Strasse == null) {
			if (other.Strasse != null)
				return false;
		} else if (!Strasse.equals(other.Strasse))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse [Strasse: " + getStrasse() + ", PLZ: "
				+ getPLZ() + ", Stadt: " + getStadt() + ", Land: "
				+ getLand() + "]";
	}
}
