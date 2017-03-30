package no.hib.dat101.klient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StartSpill {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.close();
		entityManagerFactory.close();

//		Scanner tast = new Scanner(System.in);
//		Stigespill stiges = new Stigespill(new Tekstgrensesnitt());
//		stiges.start();
//		tast.close();
	}
}
