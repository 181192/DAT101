package no.hib.dat101.klient;

import java.util.Scanner;

import no.hib.dat101.modell.Stigespill;
import no.hib.dat101.utsyn.Tekstgrensesnitt;

public class StartSpill {
	public static void main(String[] args) {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
//		EntityManager em = entityManagerFactory.createEntityManager();
//
//		em.close();
//		entityManagerFactory.close();

		Scanner tast = new Scanner(System.in);
		Stigespill stiges = new Stigespill(new Tekstgrensesnitt());
		stiges.start();
		tast.close();
		

	}
}
