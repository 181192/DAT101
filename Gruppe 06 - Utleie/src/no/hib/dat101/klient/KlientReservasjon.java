package no.hib.dat101.klient;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hib.dat101.modell.Reservasjon;

public class KlientReservasjon {
	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		Reservasjon r = new Reservasjon();
		r.lagReservasjon();
		
		em.close();
		entityManagerFactory.close();
		tast.close();
	}
}
