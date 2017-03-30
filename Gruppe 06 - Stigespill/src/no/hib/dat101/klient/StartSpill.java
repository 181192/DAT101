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

		hentBrett(em, 1);
		hentRuter(em);
		
		em.close();
		entityManagerFactory.close();
		
		System.out.println("Skirver ut bare for å teste: " + brett.getRuteTab().get(14).getRute_nr());
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
			brett.getRuteTab().add(hentRute(em, i));
			System.out.println("Henter rute med rutenr: " + i);
		}
	}

	/**
	 * Metoden henter en rute til brettet fra databasen.
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
