package no.hib.dat101.klient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import no.hib.dat101.modell.Brett;
import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.Stigespill;
import no.hib.dat101.modell.brikke.Brikke;
import no.hib.dat101.modell.rute.Rute;
import no.hib.dat101.utsyn.StigespillUI;
import no.hib.dat101.utsyn.Tekstgrensesnitt;

public class StartSpill {
	private static Brett brett;
	private static Stigespill stigespill;
	private static Spiller spiller;
	private static List<Spiller> spillere;
	private static Rute rute;
	private static StigespillUI ui;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		ui = new Tekstgrensesnitt();
		Stigespill stiges = new Stigespill();

		hentBrett(em, 1);
		hentRuter(em);

		leggInnSpillere(em, ui.lesAntallSpillere(), stiges);

		stiges.setUi(ui);
		stiges.setSpillere(spillere);
		System.out.println("Antall spillere " + spillere.size());
		stiges.setBrett(brett);
		stiges.start();

		em.close();
		entityManagerFactory.close();
		tast.close();
	}

	/**
	 * Legger inn spiller navn fra brukeren. Tilegner spilleren en brikke.
	 * Oppretter spillerne og laster de opp til databasen.
	 * 
	 * @param em
	 * @param antall
	 */
	public static void leggInnSpillere(EntityManager em, Integer antall, Stigespill stigespill_id) {
		spillere = new ArrayList<Spiller>(antall);
		for (int i = 0; i < antall; i++) {
			spiller = new Spiller();
			spiller.setNavn(ui.lesInnSpiller());
			spiller.setBrikke(new Brikke(ui.lesInnBrikkeFarge(), brett.getRuteTab().get(1)));
//			spiller.setStigespill_id(stigespill_id);
			spillere.add(spiller);

			try {
				em.getTransaction().begin();
				em.persist(spiller);
				em.getTransaction().commit();
			} catch (RollbackException e) {
				em.getTransaction().rollback();
			}
		}
	}

	/**
	 * Metoden skal hente stigespillet med stigespill_id fra databasen.
	 * 
	 * @param em
	 */
	public static void hentStigeSpill(EntityManager em, Integer nr) {
		stigespill = em.find(Stigespill.class, nr);
	}

	/**
	 * Metoden skal hente ett ferdig brett som er lagret i databasen. Hvert
	 * spill skal hente ett brett her i fra. Brettene er forhåndsdefinerte.
	 * 
	 * @param em
	 */
	public static void hentBrett(EntityManager em, Integer brett_id) {
		brett = new Brett();
		brett = em.find(Brett.class, brett_id);
		System.out.println("Brettet er hentet! brett_id = " + brett.getNavn().toString());
	}

	/**
	 * Metoden henter rutene fra databasen og legger de til i ArrayListen til
	 * brettet.
	 * 
	 * @param em
	 */
	public static void hentRuter(EntityManager em) {
		for (int i = 0; i < brett.getANTALL_RUTER(); i++) {
			rute = new Rute();
			rute = hentRute(em, i);
			brett.getRuteTab().add(rute);
		}
		System.out.println("Alle rutene er hentet, det er : " + brett.getRuteTab().size() + " ruter på brettet");
		System.out.println("Skriver ut bare for å teste: " + brett.getRuteTab().get(40).getRute_nr().intValue());
	}

	/**
	 * Hjelpe metode for å hente en rute til brettet fra databasen.
	 * 
	 * @param em
	 */
	private static Rute hentRute(EntityManager em, Integer rute_nr) {
		return em.find(Rute.class, rute_nr);
	}

	/**
	 * Metoden henter spillerne fra databasen
	 * 
	 * @param em
	 */
	public static void hentSpillere(EntityManager em, Integer antall) {
		for (int i = 0; i < antall; i++) {
			stigespill.getSpillere().add(hentEnSpiller(em, i));
		}
	}

	/**
	 * Hjelpe metode for å hente en spiller fra databasen
	 * 
	 * @param em
	 * @param spiller_id
	 *            Id'en til spilleren.
	 * @return Returnerer spilleren.
	 */
	private static Spiller hentEnSpiller(EntityManager em, Integer spiller_id) {
		return em.find(Spiller.class, spiller_id);
	}

	/**
	 * Metoden henter loggen fra ett tidligere spill, slik at spillet kan
	 * gjenoppta hvor det stoppet.
	 * 
	 * @param em
	 */
	public static void hentLogg(EntityManager em) {

	}

}
