package de.shop.bestellverwaltung.domain;
import java.util.ArrayList;
import java.util.List;


public class Auftrag {
	private Integer pID;
	private List<Lieferant> pLieferant;
	private List<Rechnung> pRechnung;
	
	public Auftrag(Integer aID) {
		//Check if ID argument is empty.
		if (aID.equals(null) || aID < 0) {
			throw new NullPointerException();
		}
		
		//Initialize parameters.
		this.pLieferant = new ArrayList<Lieferant>();
		this.pRechnung = new ArrayList<Rechnung>();

		//Set parameters.
		this.pID = aID;
	}
	
	public Integer getID() {
		return this.pID;
	}
	
	public void setID(Integer aID) {
		//Check if ID argument is empty.
		if (aID.equals(null) || aID < 0) {
			throw new NullPointerException();
		}
		
		//Set ID.
		this.pID = aID;
	}
}
