package de.shop.artikelverwaltung.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fahrrad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3628353876023627522L;

	enum Farbe {
		weiss, schwarz, grau, rot, blau, gelb, gruen, bunt,
	}

	enum Kategorie {
		Mountainbike, Tandem, BMX, Rennrad, Einrad, Laufrad, Strassenfahrrad, Liegerad, Hochrad,
	}

	enum Art {
		Herrenrad, Damenrad, Kinderfahrrad,
	}
	private String gaenge;

	private String zollgroesse;

	private String rahmenhoehe;

	private boolean strassenzulassung;

	public String getGaenge() {
		return gaenge;
	}

	public void setGaenge(String gaenge) {
		this.gaenge = gaenge;
	}

	public String getZollgroesse() {
		return zollgroesse;
	}

	public void setZollgroesse(String zollgroesse) {
		this.zollgroesse = zollgroesse;
	}

	public String getRahmenhoehe() {
		return rahmenhoehe;
	}

	public void setRahmenhoehe(String rahmenhoehe) {
		this.rahmenhoehe = rahmenhoehe;
	}

	public boolean isStrassenzulassung() {
		return strassenzulassung;
	}

	public void setStrassenzulassung(boolean strassenzulassung) {
		this.strassenzulassung = strassenzulassung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gaenge == null) ? 0 : gaenge.hashCode());
		result = prime * result
				+ ((rahmenhoehe == null) ? 0 : rahmenhoehe.hashCode());
		result = prime * result + (strassenzulassung ? 1231 : 1237);
		result = prime * result
				+ ((zollgroesse == null) ? 0 : zollgroesse.hashCode());
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
		Fahrrad other = (Fahrrad) obj;
		if (gaenge == null) {
			if (other.gaenge != null)
				return false;
		} else if (!gaenge.equals(other.gaenge))
			return false;
		if (rahmenhoehe == null) {
			if (other.rahmenhoehe != null)
				return false;
		} else if (!rahmenhoehe.equals(other.rahmenhoehe))
			return false;
		if (strassenzulassung != other.strassenzulassung)
			return false;
		if (zollgroesse == null) {
			if (other.zollgroesse != null)
				return false;
		} else if (!zollgroesse.equals(other.zollgroesse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fahrrad [gaenge=" + gaenge + ", zollgroesse=" + zollgroesse
				+ ", rahmenhoehe=" + rahmenhoehe + ", strassenzulassung="
				+ strassenzulassung + ", getGaenge()=" + getGaenge()
				+ ", getZollgroesse()=" + getZollgroesse()
				+ ", getRahmenhoehe()=" + getRahmenhoehe()
				+ ", isStrassenzulassung()=" + isStrassenzulassung()
				+ ", hashCode()=" + hashCode() + "]";
	}

}