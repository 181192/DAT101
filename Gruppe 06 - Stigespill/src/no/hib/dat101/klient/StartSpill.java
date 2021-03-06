package no.hib.dat101.klient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import no.hib.dat101.modell.Brett;
import no.hib.dat101.modell.Logg;
import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.Stigespill;
import no.hib.dat101.modell.brikke.Brikke;
import no.hib.dat101.modell.brikke.BrikkeFarge;
import no.hib.dat101.modell.rute.Rute;
import no.hib.dat101.utsyn.Tekstgrensesnitt;

public class StartSpill {

	private static Stigespill stigespill;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
//		stigespill = new Stigespill();
//		stigespill.setUi(new Tekstgrensesnitt());
//
//		stigespill.setBrett(hentBrett(em, stigespill.getUi().velgBrett()));
//		hentRuter(em, stigespill.getBrett());
//		stigespill.getUi().antallRuter(stigespill.getBrett());
//
////		skrivSpillereFerdig(em, 2);
//		 skrivSpillere(em, stigespill.getUi().lesAntallSpillere());
//
//		stigespill.getUi().antallSpillere(stigespill.getSpillere());
//		stigespill.start();
//		stigespill.getUi().vinner(stigespill);
//
//		System.out.println("\n\n\n*********************************************************"
//				+ "\nHenter loggen til spillet fra databasen: \n");
//
//		skrivStigespill(em);
//		skrivLogg(em);
//		hentLogg(em, stigespill);

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
	public static void skrivSpillereFerdig(EntityManager em, Integer antall) {
		stigespill.setSpillere(new ArrayList<Spiller>(antall));
		Spiller s1 = new Spiller();
		Spiller s2 = new Spiller();

		s1.setNavn("Arne");
		s2.setNavn("Peder");
		s1.setBrikke(new Brikke(BrikkeFarge.finnBrikkeFarge(0), stigespill.getBrett().getRuteTab().get(0)));
		s2.setBrikke(new Brikke(BrikkeFarge.finnBrikkeFarge(1), stigespill.getBrett().getRuteTab().get(0)));
		s1.setStigespill_id(stigespill);
		s2.setStigespill_id(stigespill);
		stigespill.getSpillere().add(s1);
		stigespill.getSpillere().add(s2);

		try {
			em.getTransaction().begin();
			em.persist(s1);
			em.persist(s2);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * Metoden laster opp spillere til databasen
	 * 
	 * @param em
	 * @param antall
	 *            Antall spillere
	 */
	public static void skrivSpillere(EntityManager em, Integer antall) {
		stigespill.setSpillere(new ArrayList<Spiller>(antall));
		for (int i = 0; i < antall; i++) {
			Spiller s = new Spiller();
			s.setNavn(stigespill.getUi().lesInnSpiller());
			s.setBrikke(new Brikke(stigespill.getUi().lesInnBrikkeFarge(), stigespill.getBrett().getRuteTab().get(0)));
			s.setStigespill_id(stigespill);
			stigespill.getSpillere().add(s);

			try {
				em.getTransaction().begin();
				em.persist(s);
				em.getTransaction().commit();
			} catch (RollbackException e) {
				em.getTransaction().rollback();
			}
		}
	}

	/**
	 * Metoden skal hente ett ferdig brett som er lagret i databasen. Hvert
	 * spill skal hente ett brett her i fra. Brettene er forh�ndsdefinerte.
	 * 
	 * @param em
	 * @param brett_id
	 *            IDen til brettet
	 * @return Ett brett
	 */
	public static Brett hentBrett(EntityManager em, Integer brett_id) {
		return em.find(Brett.class, brett_id);
	}

	/**
	 * Hjelpe metode for � hente en rute til brettet fra databasen.
	 * 
	 * @param em
	 * @param brett_id
	 *            IDen til brettet
	 * @return Returnerer en liste med alle rutene
	 */
	@SuppressWarnings("unchecked")
	public static void hentRuter(EntityManager em, Brett brett_id) {
		stigespill.getBrett()
				.setRuteTab((List<Rute>) em
						.createQuery(//
								"SELECT r FROM Rute r WHERE r.brett_id = :brett")//
						.setParameter("brett", brett_id)//
						.getResultList());//
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
	 * Hjelpe metode for � hente en spiller fra databasen
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
	@SuppressWarnings("unchecked")
	public static void hentLogg(EntityManager em, Stigespill stiges) {
		stigespill.setLogger((List<Logg>) em.createQuery(//
				"SELECT DISTINCT l FROM Logg l, Spiller s, Stigespill st WHERE l.spiller = s AND s.stigespill_id = :st ORDER BY l.logg_id")//
				.setParameter("st", stiges)//
				.getResultList());//

		for (Logg l : stigespill.getLogger()) {
			System.out.println(l.toString());
		}
	}

	/**
	 * Skriver loggen til databasen.
	 * 
	 * @param em
	 */
	public static void skrivLogg(EntityManager em) {
		for (int i = 0; i < stigespill.getLogger().size(); i++) {
			try {
				em.getTransaction().begin();
				em.persist(stigespill.getLogger().get(i));
				em.getTransaction().commit();
			} catch (RollbackException e) {
				em.getTransaction().rollback();
			}
		}
	}

	/**
	 * Hent ett stigespill fra databasen
	 * 
	 * @param em
	 *            EntityManager
	 * @param stigespill_id
	 *            Id til stigespillet
	 * @return Ett stigespill
	 */
	public static Stigespill hentStigeSpill(EntityManager em, Integer stigespill_id) {
		return em.find(Stigespill.class, stigespill_id);
	}

	/**
	 * Metoden laster opp ett stigespill til databasen
	 * 
	 * @param em
	 */
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
