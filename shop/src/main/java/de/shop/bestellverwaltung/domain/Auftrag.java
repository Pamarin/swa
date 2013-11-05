package de.shop.bestellverwaltung.domain;
import java.util.ArrayList;
import java.util.List;


public class Auftrag {
	enum AuftragsStatus {
		InBearbeitung,
		Abgeschlossen
	}
	
	private Integer Nr;
	private List<Lieferant> Lieferant;
	private List<Rechnung> Rechnung;
	private AuftragsStatus Status;
	
	public Auftrag(Integer nr) {
		super();
		setNr(nr);
	}

	public Integer getNr() {
		return Nr;
	}
	
	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Auftragsnummer muss einen Wert haben.");
		
		Nr = nr;
	}
	
	public AuftragsStatus getStatus() {
		return Status;
	}
	
	public void setStatus(AuftragsStatus status) {
		if(status == null)
			throw new NullPointerException("Auftragsstatus muss einen Wert haben.");
		
		Status = status;
	}
	
	public void addLieferant(Lieferant lieferant) {
		if(Lieferant == null)
			Lieferant = new ArrayList<Lieferant>();
		
		Lieferant.add(lieferant);
	}
	
	public void delLieferant(Lieferant lieferant) throws KeinLieferantException {
		if(Lieferant == null || Lieferant.contains(lieferant) == false)
			throw new KeinLieferantException("Gesuchter Lieferant nicht vorhanden.");
		
		Lieferant.remove(lieferant);
	}
	
	public Lieferant getLieferant(Integer nr) throws KeinLieferantException {
		if(Lieferant == null)
			throw new KeinLieferantException("Gesuchter Lieferant nicht vorhanden.");
		
		for(Lieferant lieferant : Lieferant) {
			if(lieferant.getNr() == nr)
				return lieferant;
		}
		
		throw new KeinLieferantException("Gesuchter Lieferant nicht vorhanden.");
	}
	
	public void addRechnung(Rechnung rechnung) {
		if(Rechnung == null)
			Rechnung = new ArrayList<Rechnung>();
		
		Rechnung.add(rechnung);
	}
	
	public void delRechnung(Rechnung rechnung) throws KeineRechnungException {
		if(Rechnung == null || Rechnung.contains(rechnung) == false)
			throw new KeineRechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		Rechnung.remove(rechnung);
	}
	
	public Rechnung getRechnung(Integer nr) throws KeineRechnungException {
		if(Rechnung == null)
			throw new KeineRechnungException("Gesuchte Rechnung nicht vorhanden.");
		
		for(Rechnung rechnung : Rechnung) {
			if(rechnung.getNr() == nr)
				return rechnung;
		}
		
		throw new KeineRechnungException("Gesuchte Rechnung nicht vorhanden.");
	}
}
