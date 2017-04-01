package no.hib.dat101.database;

import java.util.ArrayList;
import java.util.List;

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
import no.hib.dat101.utsyn.StigespillUI;

public class DatabaseManager {
	private Brett brett;
	private Stigespill stigespill;
	private List<Spiller> spillere;
	private Spiller spiller;
	private Rute rute;
	private StigespillUI ui;
	private List<Logg> logger;
	private Logg logg;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;

	public DatabaseManager() {

	}

	public DatabaseManager(Stigespill stigespill, StigespillUI ui, Brett brett, List<Logg> logger,
			List<Spiller> spillere) {
		entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		em = entityManagerFactory.createEntityManager();
		this.stigespill = stigespill;
		this.ui = ui;
		this.brett = brett;
		this.logger = logger;
		this.spillere = spillere;
	}
	
	public void setOppStigeSpill() {
		
	}

	/**
	 * Metoden skal hente stigespillet med stigespill_id fra databasen.
	 * 
	 * @param em
	 */
	public Stigespill hentStigeSpill(Integer nr) {
		return em.find(Stigespill.class, nr);
	}

	/**
	 * Metoden skal hente ett ferdig brett som er lagret i databasen. Hvert
	 * spill skal hente ett brett her i fra. Brettene er forhåndsdefinerte.
	 * 
	 * @param em
	 */
	public Brett hentBrett(Integer brett_id) {
		return em.find(Brett.class, brett_id);
	}

	/**
	 * Metoden henter rutene fra databasen og legger de til i ArrayListen til
	 * brettet.
	 * 
	 * @param em
	 */
	public void hentRuter() {
		for (int i = 0; i < brett.getANTALL_RUTER(); i++) {
			rute = new Rute();
			rute = hentRute(i);
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
	private Rute hentRute(Integer rute_id) {
		return em.find(Rute.class, rute_id);
	}

	/**
	 * Metoden henter spillerne fra databasen
	 * 
	 * @param em
	 */
	public void hentSpillere(Integer antall) {
		for (int i = 0; i < antall; i++) {
			stigespill.getSpillere().add(hentEnSpiller(i));
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
	private Spiller hentEnSpiller(Integer spiller_id) {
		return em.find(Spiller.class, spiller_id);
	}

	/**
	 * Legger inn spiller navn fra brukeren. Tilegner spilleren en brikke.
	 * Oppretter spillerne og laster de opp til databasen.
	 * 
	 * @param em
	 * @param antall
	 */
	public void leggInnSpillere(Integer antall, Stigespill stigespill_id) {
		spillere = new ArrayList<Spiller>(antall);
		Spiller s1 = new Spiller();
		Spiller s2 = new Spiller();

		s1.setNavn("Arne");
		s2.setNavn("Peder");

		s1.setBrikke(new Brikke(BrikkeFarge.RED, brett.getRuteTab().get(1)));
		s2.setBrikke(new Brikke(BrikkeFarge.GREEN, brett.getRuteTab().get(1)));

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
	 * Henter logg over alle trekk og implimenterer det i spillet, slik at
	 * spillet kan gjenoppta hvor det stoppet.
	 * 
	 * @param em
	 */
	public void hentLogger() {
		for (int i = 0; i < 100; i++) {
			hentEnLogg(i);
		}
	}

	/**
	 * Metoden henter en logg fra ett tidligere spill
	 * 
	 * @param em
	 */
	private Logg hentEnLogg(Integer logg_id) {
		return em.find(Logg.class, logg_id);
	}

	/**
	 * Skriver loggen til databasen.
	 * 
	 * @param em
	 */
	public void skrivLogg() {
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
	 * Steng kommunikasjonen til databasen
	 */
	public void avslutt() {
		entityManagerFactory.close();
		em.close();
	}

}