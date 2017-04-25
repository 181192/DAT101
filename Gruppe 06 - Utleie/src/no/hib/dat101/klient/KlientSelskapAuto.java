/**
 * 
 */
package no.hib.dat101.klient;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hib.dat101.modell.Adresse;
import no.hib.dat101.modell.Bil;
import no.hib.dat101.modell.Kategori;
import no.hib.dat101.modell.Selskap;
import no.hib.dat101.modell.Utleiekontor;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class KlientSelskapAuto {
	private static Adresse adr;
	private static Adresse adr1;
	private static Adresse adr2;
	private static Selskap s;
	private static Bil b1;
	private static Bil b2;
	private static Bil b3;
	private static Bil b4;
	private static Bil b5;
	private static Bil b6;
	private static Utleiekontor utleie;
	private static Utleiekontor utleie1;
	private static Kategori a;
	private static Kategori b;
	private static Kategori c;
	private static Kategori d;
	private static List<Utleiekontor> kontorer;
	private static List<Bil> bilerUtleie;
	private static List<Bil> bilerUtleie1;

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		kontorer = new ArrayList<>();
		bilerUtleie = new ArrayList<>();
		bilerUtleie1 = new ArrayList<>();
		
		
		a = new Kategori();
		b = new Kategori();
		c = new Kategori();
		d = new Kategori();
		// Lager nytt selskap
		s = new Selskap();
		s.setEm(em);
		adr = new Adresse();
		s.setFirma_navn("EclipseLease");
		adr.setGateadresse("Inndalsveien 28");
		adr.setPostnummer(5063);
		adr.setPoststed("Bergen");
		s.setFirma_adresse(adr);
		s.setTelefonnummer(55555555);

	

		// Lager utleiekontor 1
		utleie = new Utleiekontor();
		utleie.setSelskap_id(s);
		adr1 = new Adresse();
		adr1.setGateadresse("Flyplassveien 555");
		adr1.setPostnummer(5258);
		adr1.setPoststed("Bergen");
		utleie.setTelefonnummer(55554444);

		utleie.setAdresse(adr1);

		kontorer.add(0, utleie);

		// Lager utleiekontor 2
		utleie1 = new Utleiekontor();
		utleie1.setSelskap_id(s);
		adr2 = new Adresse();
		adr2.setGateadresse("C.Sundtsgate 1");
		adr2.setPostnummer(5004);
		adr2.setPoststed("Bergen");
		utleie1.setTelefonnummer(55553333);

		utleie1.setAdresse(adr2);

		kontorer.add(1, utleie1);

		s.setUtleiekontorer(kontorer);

		b1 = new Bil();
		b1.setKontornummer(utleie);

		b1.setEr_ledig(true);
		b1.setFarge("Sølv");
		b1.setMerke("VW");
		b1.setModell("Up");
		b1.setKm_stand(12000);
		b1.setReg_nummer("SV11111");
		a.setKategori_id('A');
		a.setDagspris(600);
		b1.setKategori(a);

		bilerUtleie.add(0, b1);

		b2 = new Bil();
		b2.setKontornummer(utleie);

		b2.setEr_ledig(true);
		b2.setFarge("Gull");
		b2.setMerke("VW");
		b2.setModell("Passat");
		b2.setKm_stand(15000);
		b2.setReg_nummer("SV22222");
		b.setKategori_id('B');
		b.setDagspris(800);
		b2.setKategori(b);

		bilerUtleie.add(1, b2);

		b3 = new Bil();
		b3.setKontornummer(utleie);

		b3.setEr_ledig(true);
		b3.setFarge("Sort");
		b3.setMerke("Range Rover");
		b3.setModell("Sport HSE");
		b3.setKm_stand(25000);
		b3.setReg_nummer("SV44444");
		c.setKategori_id('C');
		c.setDagspris(1200);
		b3.setKategori(c);

		bilerUtleie.add(2, b3);

		b4 = new Bil();
		b4.setKontornummer(utleie);
		
		b4.setEr_ledig(true);
		b4.setFarge("Rød");
		b4.setMerke("Audi");
		b4.setModell("R8");
		b4.setKm_stand(20000);
		b4.setReg_nummer("SV55555");
		d.setKategori_id('D');
		d.setDagspris(1600);
		b4.setKategori(d);

		bilerUtleie.add(3, b4);

		utleie.setBiler(bilerUtleie);

		b5 = new Bil();
		b5.setKontornummer(utleie1);

		b5.setEr_ledig(true);
		b5.setFarge("Blå");
		b5.setMerke("Ford");
		b5.setModell("Mondeo");
		b5.setKm_stand(11000);
		b5.setReg_nummer("SV66666");
		b5.setKategori(b);

		bilerUtleie1.add(0, b5);

		b6 = new Bil();
		b6.setKontornummer(utleie1);

		b6.setEr_ledig(true);
		b6.setFarge("Grønn");
		b6.setMerke("Mercedes");
		b6.setModell("SL Roadster");
		b6.setKm_stand(13000);
		b6.setReg_nummer("SV77777");
		b6.setKategori(d);

		bilerUtleie1.add(1, b6);

		utleie1.setBiler(bilerUtleie1);
		
		s.lastOppSelskapDB();

		em.close();
		entityManagerFactory.close();

	}
}
