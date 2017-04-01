package no.hib.dat101.klient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import no.hib.dat101.modell.Brett;
import no.hib.dat101.modell.Logg;
import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.Stigespill;
import no.hib.dat101.modell.brikke.Brikke;
import no.hib.dat101.modell.brikke.BrikkeFarge;
import no.hib.dat101.modell.rute.Rute;
import no.hib.dat101.utsyn.StigespillUI;
import no.hib.dat101.utsyn.Tekstgrensesnitt;

public class StartSpill {
	private static Brett brett;
	private static Stigespill stigespill;
	private static List<Spiller> spillere;
	private static Spiller spiller;
	private static Rute rute;
	private static StigespillUI ui;
	private static List<Logg> logger;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		ui = new Tekstgrensesnitt();
		logger = new ArrayList<Logg>();

		stigespill = new Stigespill();

		brett = hentBrett(em, 2);
		hentRuter(em);

		// leggInnSpillere(em, ui.lesAntallSpillere(), stiges);
		skrivSpillere(em, 2, stigespill);

		stigespill.setUi(ui);
		stigespill.setSpillere(spillere);
		System.out.println("Antall spillere " + spillere.size());
		stigespill.setLogger(logger);
		stigespill.setBrett(brett);
		stigespill.start();
		System.out.println(ui.vinner(stigespill) + " vant denne runden!");
		System.out.println("\nHenter loggen til spillet fra databasen: \n");
		
		skrivStigespill(em);
		skrivLogg(em);
		hentLogger(em);
		
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
	public static void skrivSpillere(EntityManager em, Integer antall, Stigespill stigespill_id) {
		spillere = new ArrayList<Spiller>(antall);
		Spiller s1 = new Spiller();
		Spiller s2 = new Spiller();

		s1.setNavn("Arne");
		s2.setNavn("Peder");

		s1.setBrikke(new Brikke(BrikkeFarge.finnBrikkeFarge(0), brett.getRuteTab().get(1)));
		s2.setBrikke(new Brikke(BrikkeFarge.finnBrikkeFarge(1), brett.getRuteTab().get(1)));
		
		s1.setStigespill_id(stigespill);
		s2.setStigespill_id(stigespill);

		spillere.add(s1);
		spillere.add(s2);
		// for (int i = 0; i < antall; i++) {
		// spiller = new Spiller();
		// spiller.setNavn(ui.lesInnSpiller());
		// spiller.setBrikke(new Brikke(ui.lesInnBrikkeFarge(),
		// brett.getRuteTab().get(1)));
		// // spiller.setStigespill_id(stigespill_id);
		// spillere.add(spiller);

		try {
			em.getTransaction().begin();
			em.persist(s1);
			em.persist(s2);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
		// }
	}

	/**
	 * Metoden skal hente ett ferdig brett som er lagret i databasen. Hvert
	 * spill skal hente ett brett her i fra. Brettene er forhåndsdefinerte.
	 * 
	 * @param em
	 */
	public static Brett hentBrett(EntityManager em, Integer brett_id) {
		return em.find(Brett.class, brett_id);
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
		System.out.println("Alle rutene er hentet, det er : " + (brett.getRuteTab().size() - 1) + " ruter på brettet");
		System.out.println("Skriver rute_nr til rute 40 ut bare for å teste: "
				+ brett.getRuteTab().get(40).getRute_nr().intValue());
	}

	/**
	 * Hjelpe metode for å hente en rute til brettet fra databasen.
	 * 
	 * @param em
	 */
	private static Rute hentRute(EntityManager em, Integer rute_id) {
		return em.find(Rute.class, rute_id);
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
	 * Henter logg over alle trekk og implimenterer det i spillet, slik at
	 * spillet kan gjenoppta hvor det stoppet.
	 * 
	 * @param em
	 */
	public static void hentLogger(EntityManager em) {
		for (int i = 1; i < logger.size(); i++) {
			System.out.println(hentEnLogg(em, i).toString());
		}
	}

	/**
	 * Metoden henter en logg fra ett tidligere spill
	 * 
	 * @param em
	 */
	private static Logg hentEnLogg(EntityManager em, Integer logg_id) {
		return em.find(Logg.class, logg_id);
	}

	/**
	 * Skriver loggen til databasen.
	 * 
	 * @param em
	 */
	public static void skrivLogg(EntityManager em) {
		for (int i = 0; i < logger.size(); i++) {
			try {
				em.getTransaction().begin();
				em.persist(logger.get(i));
				em.getTransaction().commit();
			} catch (RollbackException e) {
				em.getTransaction().rollback();
			}
		}
	}
	
	/**
	 * Hent ett stigespill fra databasen
	 * @param em EntityManager
	 * @param stigespill_id Id til stigespillet
	 * @return Ett stigespill
	 */
	public static Stigespill hentStigeSpill(EntityManager em, Integer stigespill_id) {
		return em.find(Stigespill.class, stigespill_id);
	}
	
	public static void skrivStigespill(EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(stigespill);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

}
