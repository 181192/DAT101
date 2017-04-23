/**
 * 
 */
package no.hib.dat101.ui;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import no.hib.dat101.modell.Bil;
import no.hib.dat101.modell.Kategori;
import no.hib.dat101.modell.Retur;
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
		return tast.nextInt();
	}

	@Override
	public String lesInnPoststed() {
		System.out.print("Oppgi poststed: ");
		return tast.next();
	}

	@Override
	public String lesInnReg_nummer() {
		System.out.print("Oppgi registrerings nummer: ");
		return tast.next();
	}

	@Override
	public String lesInnMerke() {
		System.out.print("Oppgi merke: ");
		return tast.next();
	}

	@Override
	public String lesInnModell() {
		System.out.print("Oppgi modell: ");
		return tast.next();
	}

	@Override
	public String lesInnFarge() {
		System.out.print("Oppgi farge: ");
		return tast.next();
	}

	@Override
	public Integer lesInnKm_stand() {
		System.out.print("Oppgi km stand: ");
		return tast.nextInt();
	}

	@Override
	public Character lesInnKategori() {
		System.out.print("Oppgi kategori: ");
		return tast.next().toUpperCase().charAt(0);
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
		return tast.nextInt();
	}

	@Override
	public Integer lesInnKredittkort() {
		System.out.print("Oppgi kredittkort: ");
		return tast.nextInt();
	}

	@Override
	public Time lesInnKlokkeslett() {
		System.out.print("Oppgi klokkeslett på formatet hh:mm:ss : ");
		return Time.valueOf(tast.nextLine());
	}

	@Override
	public Date lesInnDato() {
		System.out.print("Oppgi dato på formatet yyyy-MM-dd : ");
		return Date.valueOf(tast.nextLine());
	}

	@Override
	@SuppressWarnings("unchecked")
	public void visLedigeBiler(Utleiekontor kontor) {
		List<Bil> biler = (List<Bil>) em
				.createQuery(//
						"SELECT b FROM Bil b WHERE b.kontornummer = :kontor AND b.er_ledig = true") //
				.setParameter("kontor", kontor.getKontornummer()) //
				.getResultList();
		for (Bil b : biler) {
			System.out.println(b.toString());
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

		for (Utleiekontor u : kontorer) {
			System.out.println(u.toString());
		}
	}

	@Override
	public void skrivFaktura(Retur retur) {
		// TODO Auto-generated method stub

	}

}
