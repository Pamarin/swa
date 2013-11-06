package de.shop.bestellverwaltung.domain;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Jean
 *
 */
public class Auftrag {
	enum AuftragsStatus {
		InBearbeitung,
		Abgeschlossen
	}
	
	private Integer Nr;
	private AuftragsStatus Status;
	private List<Lieferant> Lieferant;
	private List<Rechnung> Rechnung;
	
	/**
	 * @param nr Auftragsnummer.
	 */
	public Auftrag(Integer nr) {
		super();
		setNr(nr);
		setStatus(AuftragsStatus.InBearbeitung);
		Lieferant = new ArrayList<Lieferant>();
		Rechnung = new ArrayList<Rechnung>();
	}

	/**
	 * @return Auftragsnummer.
	 */
	public Integer getNr() {
		return Nr;
	}
	
	/**
	 * @param nr Auftragsnummer.
	 */
	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Auftragsnummer muss einen Wert haben.");
		
		Nr = nr;
	}
	
	/**
	 * @return Auftragsstatus.
	 */
	public AuftragsStatus getStatus() {
		return Status;
	}
	
	/**
	 * @param status Auftragsstatus.
	 */
	public void setStatus(AuftragsStatus status) {
		if(status == null)
			throw new NullPointerException("Auftragsstatus muss einen Wert haben.");
		
		Status = status;
	}
	
	/**
	 * @param lieferant Lieferant.
	 * @throws LieferantException
	 */
	public void addLieferant(Lieferant lieferant) throws LieferantException {
		if(Lieferant.contains(lieferant))
			throw new LieferantException("Lieferant bereits vorhanden.");
		
		Lieferant.add(lieferant);
	}
	
	/**
	 * @param lieferant Lieferant.
	 * @throws LieferantException
	 */
	public void delLieferant(Lieferant lieferant) throws LieferantException {
		if(!Lieferant.contains(lieferant))
			throw new LieferantException("Gesuchter Lieferant nicht vorhanden.");
		
		Lieferant.remove(lieferant);
	}
	
	/**
	 * @param nr Lieferantennummer.
	 * @return Lieferant.
	 * @throws LieferantException
	 */
	public Lieferant getLieferant(Integer nr) throws LieferantException {		
		for(Lieferant lieferant : Lieferant) {
			if(lieferant.getNr() == nr)
				return lieferant;
		}
		
		throw new LieferantException("Gesuchter Lieferant nicht vorhanden.");
	}
	
	/**
	 * @return Lieferantenliste.
	 */
	public List<Lieferant> getLieferantAll() {
		return Lieferant;
	}
	
	/**
	 * @param rechnung Rechnung.
	 * @throws RechnungException
	 */
	public void addRechnung(Rechnung rechnung) throws RechnungException {
		if(Rechnung.contains(rechnung))
			throw new RechnungException("Rechnung bereits vorhanden.");
		
		Rechnung.add(rechnung);
	}
	
	/**
	 * @param rechnung Rechnung.
	 * @throws RechnungException
	 */
	public void delRechnung(Rechnung rechnung) throws RechnungException {
		if(!Rechnung.contains(rechnung))
			throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		Rechnung.remove(rechnung);
	}
	
	/**
	 * @param nr Rechnungsnummer.
	 * @return Rechnung.
	 * @throws RechnungException
	 */
	public Rechnung getRechnung(Integer nr) throws RechnungException {
		if(Rechnung == null)
			throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		for(Rechnung rechnung : Rechnung) {
			if(rechnung.getNr() == nr)
				return rechnung;
		}
		
		throw new RechnungException("Gesuchte Rechnung nicht vorhanden.");
	}
	
	/**
	 * @return Rechnungsliste.
	 */
	public List<Rechnung> getRechnungAll() {
		return Rechnung;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Lieferant == null) ? 0 : Lieferant.hashCode());
		result = prime * result + ((Nr == null) ? 0 : Nr.hashCode());
		result = prime * result
				+ ((Rechnung == null) ? 0 : Rechnung.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
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
		Auftrag other = (Auftrag) obj;
		if (Lieferant == null) {
			if (other.Lieferant != null)
				return false;
		} else if (!Lieferant.equals(other.Lieferant))
			return false;
		if (Nr == null) {
			if (other.Nr != null)
				return false;
		} else if (!Nr.equals(other.Nr))
			return false;
		if (Rechnung == null) {
			if (other.Rechnung != null)
				return false;
		} else if (!Rechnung.equals(other.Rechnung))
			return false;
		if (Status != other.Status)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Auftrag [Nr: " + getNr() + ", Status: " + getStatus()
				+ ", Lieferant: " + getLieferantAll()
				+ ", Rechnung: " + getRechnungAll() + "]";
	}
}
