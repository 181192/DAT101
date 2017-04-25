package no.hib.dat101.klient;

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
				if (rs.bekreftReservasjon(em)) {
					u = new Utleie();
					u.setReservasjon(rs);
					u.setKredittkort(ui.lesInnKredittkort());
					u.getBil().setEr_ledig(Boolean.FALSE);

					r = new Retur();
					r.info();
				}
			case 2:
				// Returner bil
				break;
			case 3:
				// Avslutt
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
}
