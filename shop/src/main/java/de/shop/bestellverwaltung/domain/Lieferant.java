package de.shop.bestellverwaltung.domain;

public class Lieferant {
	private Integer Nr;
	private String Name;
	
	public Integer getNr() {
		return Nr;
	}
	
	public void setNr(Integer nr) {
		if(nr == null)
			throw new NullPointerException("Lieferantennummer darf nicht leer sein.");
		
		Nr = nr;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		if(name == null || name == "")
			throw new NullPointerException("Lieferantenname darf nicht leer sein.");
		
		Name = name;
	}
}
