package de.shop.bestellverwaltung.domain;

public class KeinLieferantException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8888165622170465585L;

	public KeinLieferantException() {}
	
	public KeinLieferantException(String beschreibung) {
		super(beschreibung);
	}
}
