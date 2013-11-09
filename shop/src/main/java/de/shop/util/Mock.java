package de.shop.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import de.shop.bestellverwaltung.domain.Auftrag;
import de.shop.bestellverwaltung.domain.Lieferant;
import de.shop.bestellverwaltung.domain.Rechnung;
import de.shop.bestellverwaltung.domain.Auftrag.AuftragsStatus;
import de.shop.kundenverwaltung.domain.Kunde;

/**
 * Emulation des Anwendungskerns
 * @author Jean-Luc Burot, Jan Krieghoff
 */
public final class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_AUFTRAEGE = 4;
	private static final int MAX_LIEFERANTEN = 8;
	private static final int MAX_RECHNUNGEN = 8;
	
	public static Auftrag findAuftragById(Long id) {
		if(id > MAX_ID)
			return null;
		
		final Auftrag auftrag = new Auftrag();
		auftrag.setId(id);
		auftrag.setStatus(AuftragsStatus.InBearbeitung);
		
		return auftrag;
	}
	
	public static Lieferant findLieferantById(Long id) {
		if(id > MAX_ID)
			return null;
		
		final Lieferant lieferant = new Lieferant();
		lieferant.setId(id);
		lieferant.setLieferzeit(3);
		lieferant.setName("Breisinger Nr." + id);
		lieferant.setAdresseLieferant(new Adresse(id, new Date(), new Date(), "Teststraße", "97a", "12345", "Testhausen", "Testland"));
		
		return lieferant;
	}
	
	public static Rechnung findRechnungById(Long id) {
		if(id > MAX_ID)
			return null;
		
		final Rechnung rechnung = new Rechnung();
		rechnung.setId(id);
		rechnung.setIstBezahlt(false);
		rechnung.setSumme(new BigDecimal(123.45));
		
		return rechnung;
	}
	
	public static List<Rechnung> findRechnungenByAuftrag(Auftrag auftrag) {
		return findAllRechnungen();
	}
	
	public static Kunde findKundeById(Long id) {
		if (id > MAX_ID)
			return null;
		
		final Kunde kunde = new Kunde();
		//kunde.setid(id);
		//kunde.setNachname("Nachname" + id);
		//kunde.setEMail("" + id + "@hska.de");
		
		final Adresse adresse = new Adresse();
		adresse.setId(id + 1);        // andere ID fuer die Adresse
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		kunde.setId((long)5);
		kunde.setNachname("Mustermann");
		kunde.setVorname("Max");
		kunde.setAnrede("Herr");
		kunde.setEMail("test@mail.com");
		kunde.setTelefon("072112345");
		kunde.setAdresse(new Adresse((long) 5, new Date(), new Date(), "Musterallee","101","76327","Pfinztal","Deutschland"));
		
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
	
	public static List<Lieferant> findAllLieferanten() {
		final int anzahl = MAX_LIEFERANTEN;
		final List<Lieferant> lieferanten = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Lieferant lieferant = findLieferantById(Long.valueOf(i));
			lieferanten.add(lieferant);
		}
		return lieferanten;
	}
	
	public static List<Rechnung> findAllRechnungen() {
		final int anzahl = MAX_RECHNUNGEN;
		final List<Rechnung> rechnungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Rechnung rechnung = findRechnungById(Long.valueOf(i));
			rechnungen.add(rechnung);
		}
		return rechnungen;
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
	
	public static Auftrag createAuftrag(Auftrag auftrag) {
		Random randomGenerator = new Random();
		auftrag.setId(randomGenerator.nextLong());
		
		System.out.println("Neuer Aufrag: " + auftrag);
		return auftrag;
	}
	
	public static Kunde createKunde(Kunde kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		//final String nachname = kunde.getNachname();
		//kunde.setid(Long.valueOf(nachname.length()));
		//final Adresse adresse = kunde.getAdresse();
		//adresse.setId((Long.valueOf(nachname.length())) + 1);
		kunde.setAuftraege(null);
		
		kunde.setNachname("Mustermann");
		kunde.setVorname("Max");
		kunde.setAnrede("Herr");
		kunde.setEMail("test@mail.com");
		kunde.setTelefon("072112345");
		kunde.setAdresse(new Adresse((long) 5, new Date(), new Date(), "Musterallee","101","76327","Pfinztal","Deutschland"));
		
		System.out.println("Neuer Kunde: " + kunde);
		return kunde;
	}
	
	public static Lieferant createLieferant(Lieferant lieferant) {
		Random randomGenerator = new Random();
		Long id = randomGenerator.nextLong();
		lieferant.setId(id);
		lieferant.setLieferzeit(3);
		lieferant.setName("Breisinger Nr." + id);
		lieferant.setAdresseLieferant(new Adresse(id, new Date(), new Date(), "Teststraße", "97a", "12345", "Testhausen", "Testland"));
		
		System.out.println("Neuer Lieferant: " + lieferant);
		return lieferant;
	}
	
	public static Rechnung createRechnung(Rechnung rechnung) {
		Random randomGenerator = new Random();
		Long id = randomGenerator.nextLong();
		rechnung.setId(id);
		rechnung.setIstBezahlt(false);
		rechnung.setSumme(new BigDecimal(123.45));
		
		System.out.println("Neue Rechnung. " + rechnung);
		return rechnung;
	}
	
	public static void updateAuftrag(Auftrag auftrag) {
		System.out.println("Aktualisierter Auftrag: " + auftrag);
	}

	public static void updateKunde(Kunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}
	
	public static void updateLieferant(Lieferant lieferant) {
		System.out.println("Aktualisierter Lieferant: " + lieferant);
	}
	
	public static void updateRechnung(Rechnung rechnung) {
		System.out.println("Aktualisierte Rechnung: " + rechnung);
	}
	
	public static void deleteAuftrag(Long id) {
		System.out.println("Auftrag mit ID " + id + " geloescht.");
	}

	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}
	
	public static void deleteLieferant(Long id) {
		System.out.println("Lieferant mit ID=" + id + " geloescht.");
	}
	
	public static void deleteRechnung(Long id) {
		System.out.println("Rechnung mit ID=" + id + " geloescht.");
	}

	private Mock() { /**/ }
}