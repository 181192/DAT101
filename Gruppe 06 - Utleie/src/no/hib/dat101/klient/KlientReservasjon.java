package no.hib.dat101.klient;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hib.dat101.modell.Reservasjon;
import no.hib.dat101.modell.Retur;
import no.hib.dat101.modell.Utleie;
import no.hib.dat101.ui.SelskapUI;
import no.hib.dat101.ui.Tekstgrensesnitt;

public class KlientReservasjon {
	private static SelskapUI ui;
	private static Reservasjon rs;
	private static Utleie u;
	private static Retur r;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		ui = new Tekstgrensesnitt();
		rs = new Reservasjon();

		String meny = "";
		int valg = 0;
		do {
			System.out.println(meny);
			valg = tast.nextInt();

			switch (valg) {
			case '1':
				// Opprett reservasjon
				r.lagReservasjon();
				if (r.bekreftReservasjon()) {
					u = new Utleie();
					u.setReservasjon(rs);
					u.setKredittkort(ui.lesInnKredittkort());
					u.getBil().setEr_ledig(Boolean.FALSE);
				}
			case '2':
				// Returner bil
				r = new Retur();
				r.info();
				break;
			case '3':
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
}
