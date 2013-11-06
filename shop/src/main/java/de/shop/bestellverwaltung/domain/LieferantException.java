package de.shop.bestellverwaltung.domain;

public class LieferantException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8888165622170465585L;

	public LieferantException() {}
	
	/**
	 * @param beschreibung Exceptionbeschreibung.
	 */
	public LieferantException(String beschreibung) {
		super(beschreibung);
	}
}
