package no.hib.dat101.klient;

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
	private static Brikke brikke;
	private static Rute rute;
	private static StigespillUI ui;

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.close();
		entityManagerFactory.close();

		ui = new Tekstgrensesnitt();
		// Scanner tast = new Scanner(System.in);
		// Stigespill stiges = new Stigespill(new Tekstgrensesnitt());
		// stiges.start();
		// tast.close();
	}

	/**
	 * Legger inn spiller navn fra brukeren. Tilegner spilleren en brikke.
	 * Oppretter spillerne og laster de opp til databasen.
	 * 
	 * @param em
	 * @param antall
	 */
	public static void leggInnSpiller(EntityManager em, int antall) {
		for (int i = 0; i < antall; i++) {
			spiller = new Spiller();
			spiller.setNavn(ui.lesInnSpiller());
			spiller.setBrikke(new Brikke(ui.lesInnBrikkeFarge(), brett.getRuteTab().get(0)));
			stigespill.getSpillere().add(spiller);

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
	public static void hentStigeSpill(EntityManager em) {

	}

	/**
	 * Metoden skal hente ett ferdig brett som er lagret i databasen. Hvert
	 * spill skal hente ett brett her i fra. Brettene er forhåndsdefinerte.
	 * 
	 * @param em
	 */
	public static void hentBrett(EntityManager em) {
		brett = new Brett();
		brett.setNavn("Brett1");
		brett.settOppBrett();

		try {
			em.getTransaction().begin();
			em.persist(brett);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * Metoden henter rutene til brettet fra databasen.
	 * 
	 * @param em
	 */
	public static void hentRuter(EntityManager em) {

	}

	/**
	 * Metoden henter spillerne fra databasen
	 * 
	 * @param em
	 */
	public static void hentSpillere(EntityManager em) {

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
