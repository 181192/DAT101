/**
 * 
 */
package no.hib.dat101.ui;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import no.hib.dat101.modell.Bil;
import no.hib.dat101.modell.Kategori;
import no.hib.dat101.modell.Utleiekontor;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Tekstgrensesnitt implements SelskapUI {
	private Scanner tast;
	private EntityManager em;

	@Override
	public String lesInnGateadresse() {
		System.out.print("Oppgi gateadresse: ");
		return tast.nextLine();
	}

	@Override
	public Integer lesInnPostnummer() {
		System.out.print("Oppgi postnummer: ");
		Integer postnummer = null;
		try {
			postnummer = Integer.parseInt(tast.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Oppgi tall som postnummer!");
			lesInnPostnummer();
		}
		return postnummer;
	}

	@Override
	public String lesInnPoststed() {
		System.out.print("Oppgi poststed: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnReg_nummer() {
		System.out.print("Oppgi registrerings nummer: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnMerke() {
		System.out.print("Oppgi merke: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnModell() {
		System.out.print("Oppgi modell: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnFarge() {
		System.out.print("Oppgi farge: ");
		return tast.nextLine();
	}

	@Override
	public Integer lesInnKm_stand() {
		System.out.print("Oppgi km stand: ");
		Integer kmstand = null;
		try {
			kmstand = Integer.parseInt(tast.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Oppgi tall som kilometerstand!");
			lesInnKm_stand();
		}
		return kmstand;
	}

	@Override
	public Character lesInnKategori() {
		System.out.print("Oppgi kategori: ");
		return tast.nextLine().toUpperCase().charAt(0);
	}

	@Override
	public String lesInnFornavn() {
		System.out.print("Oppgi fornavn: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnEtternavn() {
		System.out.print("Oppgi etternavn: ");
		return tast.nextLine();
	}

	@Override
	public String lesInnAdresse() {
		System.out.println("Oppgi adresse: ");
		return tast.nextLine();
	}

	@Override
	public Integer lesInnTelefonnummer() {
		System.out.print("Oppgi telefonnummer: ");
		Integer telefonnummer = null;
		try {
			telefonnummer = Integer.parseInt(tast.nextLine());
			if (telefonnummer.toString().length() != 8) {
				System.out.println("Telefonnummer m� v�re 8 siffer langt!");
				lesInnTelefonnummer();
			}
		} catch (NumberFormatException e) {
			System.out.println("Oppgi tall som kilometerstand!");
			lesInnKm_stand();
		}
		return telefonnummer;
	}

	@Override
	public Integer lesInnKredittkort() {
		System.out.print("Oppgi kredittkort: ");
		Integer kredittkort = null;
		try {
			kredittkort = Integer.parseInt(tast.nextLine());
			if (kredittkort.toString().length() != 16) {
				System.out.println("Kredittkort m� best� av 16 siffer!");
				lesInnKredittkort();
			}
		} catch (NumberFormatException e) {
			System.out.println("Oppgi siffer som kredittkort!");
			lesInnKredittkort();
		}
		return kredittkort;
	}

	@Override
	public Time lesInnKlokkeslett() {
		Time tid = null;
		System.out.print("Oppgi klokkeslett p� formatet hh:mm : ");
		String strTime = tast.nextLine();
		if (strTime.charAt(2) == ':') {
			try {
				String numString = "" + strTime.charAt(0) + strTime.charAt(1) + strTime.charAt(3) + strTime.charAt(4);
				Integer.parseInt(numString); // Selve testen

				tid = Time.valueOf(strTime + ":00");
			} catch (NumberFormatException e) {
				System.out.println("Feil i syntax, pr�v igjen");
				lesInnKlokkeslett();
			}
		} else {
			System.out.println("Feil i syntax, pr�v igjen");
			lesInnKlokkeslett();
		}
		return tid;
	}

	@Override
	public Date lesInnDato() {
		Date dato = null;
		System.out.print("Oppgi dato p� formatet yyyy-MM-dd : ");
		String strDato = tast.nextLine();
		if (strDato.charAt(4) == '-' && strDato.charAt(7) == ':') {
			try {
				String dateString = strDato.substring(0, 4) + strDato.substring(5, 7) + strDato.substring(8);
				Integer.parseInt(dateString);

				dato = Date.valueOf(strDato);
			} catch (NumberFormatException e) {
				System.out.println("Feil i syntax, pr�v igjen");
				lesInnDato();
			}
		} else {
			System.out.println("Feil i syntax, pr�v igjen");
			lesInnDato();
		}

		return dato;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void visLedigeBiler(Utleiekontor kontor) {
		List<Bil> biler = (List<Bil>) em
				.createQuery(//
						"SELECT b FROM Bil b WHERE b.kontornummer = :kontor AND b.er_ledig = true") //
				.setParameter("kontor", kontor.getKontornummer()) //
				.getResultList();
		int i = 0;
		for (Bil b : biler) {
			System.out.println(i + " : " + b.toString());
			i++;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void visKategorier() {
		List<Kategori> kategorier = (List<Kategori>) em
				.createQuery(//
						"SELECT k FROM Kategori k") //
				.getResultList();

		for (Kategori k : kategorier) {
			System.out.println(k.toString());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void visUtleieKontorer() {
		List<Utleiekontor> kontorer = (List<Utleiekontor>) em
				.createQuery(//
						"SELECT u FROM Utleiekontor u") //
				.getResultList();

		int i = 0;
		for (Utleiekontor u : kontorer) {
			System.out.println(i + " : " + u.toString());
		}
	}

	@Override
	public void skrivFaktura(ArrayList<String> faktura) {
		for (String s : faktura) {
			System.out.println(s);
		}
	}

	@Override
	public Boolean bekreft() {
		// TODO Switch case som du velger enten 0 eller 1 ogs� returnerer en av
		// de True eller false
		String meny = "\nVennligst bekreft reservasjonen: \nY - Bekreft\nN - Avbryt";
		Character valg = 0;
		Boolean resultat = Boolean.FALSE;
		do {
			System.out.println(meny);
			valg = tast.next().toUpperCase().charAt(0);

			switch (valg) {
			case 'Y':
				resultat = Boolean.TRUE;
			case 'N':
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 'Y' || valg != 'N');
		return resultat;
	}

	@Override
	public Bil velgBil() {

		return null;
	}

	@Override
	public Utleiekontor velgUtleiekontor() {
		// TODO Auto-generated method stub
		return null;
	}

}
