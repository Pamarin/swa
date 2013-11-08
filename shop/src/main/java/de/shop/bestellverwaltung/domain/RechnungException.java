package de.shop.bestellverwaltung.domain;

public class RechnungException extends Exception {
	/**
	 * @author Jean-Luc Burot
	 */
	private static final long serialVersionUID = -157123077582469332L;

	public RechnungException() {}
	
	/**
	 * @param beschreibung Exceptionbeschreibung.
	 */
	public RechnungException(String beschreibung) {
		super(beschreibung);
	}
}
