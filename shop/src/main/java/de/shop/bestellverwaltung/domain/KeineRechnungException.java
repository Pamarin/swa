package de.shop.bestellverwaltung.domain;

public class KeineRechnungException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -157123077582469332L;

	public KeineRechnungException() {}
	
	public KeineRechnungException(String beschreibung) {
		super(beschreibung);
	}
}
