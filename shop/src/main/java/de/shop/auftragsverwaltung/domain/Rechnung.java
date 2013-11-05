package de.shop.auftragsverwaltung.domain;

public class Rechnung {
	private Integer pID;
	
	public Rechnung(Integer aID) {
		//Check if ID argument is empty.
		if (aID.equals(null) || aID < 0) {
			throw new NullPointerException();
		}

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
