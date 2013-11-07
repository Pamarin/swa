package de.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.bestellverwaltung.domain.Auftrag.AuftragsStatus;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.kundenverwaltung.domain.Anschrift;

/**
 * Emulation des Anwendungskerns
 */
public final class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_AUFTRAEGE = 4;
	
	public static Auftrag findAuftragById(Long id) {
		if(id > MAX_ID)
			return null;
		
		final Auftrag auftrag = new Auftrag();
		auftrag.setId(id);
		auftrag.setStatus(AuftragsStatus.InBearbeitung);
		
		return auftrag;
	}
	
	public static Kunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final Kunde kunde = new Kunde();
		kunde.setKundeID(id);
		kunde.setNachname("Nachname" + id);
		kunde.setEMail("" + id + "@hska.de");
		
		final Anschrift adresse = new Anschrift();
		adresse.setAnschriftID(id + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		kunde.setAnschrift(adresse);
		
		return kunde;
	}
	
	public static List<Auftrag> findAllAuftraege() {
		final int anzahl = MAX_AUFTRAEGE;
		final List<Auftrag> auftraege = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Auftrag auftrag = findAuftragById(Long.valueOf(i));
			auftraege.add(auftrag);
		}
		return auftraege;
	}

	public static List<Kunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);			
		}
		return kunden;
	}
	
	public static List<Kunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);			
		}
		return kunden;
	}
	

	/*
	public static List<Bestellung> findBestellungenByKunde(AbstractKunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;  // 1, 2, 3 oder 4 Bestellungen
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);			
		}
		kunde.setBestellungen(bestellungen);
		
		return bestellungen;
	}

	public static Bestellung findBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}

		final AbstractKunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
		bestellung.setAusgeliefert(false);
		bestellung.setKunde(kunde);
		
		return bestellung;
	}
	*/

	public static Auftrag createAuftrag(Auftrag auftrag) {
		Random randomGenerator = new Random();
		auftrag.setId(randomGenerator.nextLong());
		
		System.out.println("Neuer Aufrag: " + auftrag);
		return auftrag;
	}
	
	public static Kunde createKunde(Kunde kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setKundeID(Long.valueOf(nachname.length()));
		final Anschrift anschrift = kunde.getAnschrift();
		anschrift.setAnschriftID((Long.valueOf(nachname.length())) + 1);
		kunde.setAuftraege(null);
		
		System.out.println("Neuer Kunde: " + kunde);
		return kunde;
	}
	
	public static void updateAuftrag(Auftrag auftrag) {
		System.out.println("Aktualisierter Auftrag: " + auftrag);
	}

	public static void updateKunde(Kunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}
	
	public static void deleteAuftrag(Long id) {
		System.out.println("Auftrag mit ID " + id + " geloescht.");
	}

	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}

	private Mock() { /**/ }
}