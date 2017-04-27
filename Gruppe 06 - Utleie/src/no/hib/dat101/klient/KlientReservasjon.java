package no.hib.dat101.klient;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hib.dat101.modell.Reservasjon;
import no.hib.dat101.modell.Retur;
import no.hib.dat101.modell.Selskap;
import no.hib.dat101.modell.Utleie;
import no.hib.dat101.modell.Utleiekontor;
import no.hib.dat101.ui.SelskapUI;
import no.hib.dat101.ui.Tekstgrensesnitt;

public class KlientReservasjon {
	private static SelskapUI ui;
	private static Selskap selskap;
	private static Reservasjon rs;
	private static Utleie u;
	private static Retur r;
	private static int valg;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		ui = new Tekstgrensesnitt();

		selskap = hentSelskap(em, 1);
		selskap.setEm(em);
		selskap.hentKontorerFraDB();

		for (Utleiekontor u : selskap.getUtleiekontorer()) {
			u.setEm(em);
		}

		String meny = "\n1 - Opprett reservasjon\n2 - Lever inn bil\n3 - Avslutt\nValg : ";
		do {
			System.out.print(meny);
			valg = Integer.parseInt(tast.nextLine());

			switch (valg) {
			case 1:
				// Opprett reservasjon
				rs = new Reservasjon();
				rs.setUi(ui);
				rs.lagReservasjon(selskap);
				rs.getKundenummer().lastOppKundeDB(em);

				if (rs.bekreftReservasjon(em)) {
					u = new Utleie();
					u.setReservasjon(rs);
					u.setKredittkort(ui.lesInnKredittkort());
					u.getReservasjon().getBil().setEr_ledig(Boolean.FALSE);
					ui.skrivUtleieKvittering(u);
					u.lastOppUtleieDB(em);
				}
				rs.lastOppReservasjonDB(em);
				break;
			case 2:
				// Returner bil
				u = hentUtleie(em, ui.lesInnUtleie_id());
				rs = hentReservasjon(em, u.getReservasjon().getReservasjon_id());
				u.setReservasjon(rs);
				r = new Retur();
				r.setUtleie_id(u);
				r.lastOppReturDB(em);
				r.info();
				break;
			case 3:
				// Avslutt
				break;
			case 4:
				rs = new Reservasjon();
				rs.setUi(ui);
				rs.setUtleiested(selskap.getUtleiekontorer().get(0));
				rs.setRetursted(selskap.getUtleiekontorer().get(1));
				rs.setKlokkeslett_resv(Time.valueOf("10:20:00"));
				rs.setDato_resv(Date.valueOf("1993-10-10"));
				rs.setKlokke_forventet(Time.valueOf("10:40:00"));
				rs.setDato_forventet(Date.valueOf("1993-12-12"));
				rs.getUtleiested().hentBilerFraDB();
				rs.setBil(selskap.getUtleiekontorer().get(0).getBiler().get(0));
				rs.setKundenummer(rs.hentKundeInformasjonFerdig());
				if (rs.bekreftReservasjon(em)) {

					u = new Utleie();
					u.setReservasjon(rs);
					u.setKredittkort(Long.valueOf("3124124124124"));
					u.getReservasjon().getBil().setEr_ledig(Boolean.FALSE);
					u.lastOppUtleieDB(em);

					r = new Retur();
					r.setUtleie_id(u);
					r.infoFerdig();
					r.getUtleie_id().getReservasjon().getBil().setEr_ledig(Boolean.TRUE);
					r.lastOppReturDB(em);
					rs.lastOppReservasjonDB(em);
				}
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);

		em.close();
		entityManagerFactory.close();
		tast.close();
	}

	public static Selskap hentSelskap(EntityManager em, Integer selskap_id) {
		return em.find(Selskap.class, selskap_id);
	}

	public static Reservasjon hentReservasjon(EntityManager em, Integer reservasjon_id) {
		return em.find(Reservasjon.class, reservasjon_id);
	}

	public static Utleie hentUtleie(EntityManager em, Integer utleie_id) {
		return em.find(Utleie.class, utleie_id);
	}
}
