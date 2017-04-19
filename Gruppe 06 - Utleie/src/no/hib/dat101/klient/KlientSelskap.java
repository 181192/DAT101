package no.hib.dat101.klient;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KlientSelskap {
	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.close();
		entityManagerFactory.close();
		tast.close();
	}
}
