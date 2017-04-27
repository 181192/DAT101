package no.hib.dat101.klient;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hib.dat101.modell.Adresse;
import no.hib.dat101.modell.Bil;
import no.hib.dat101.modell.Kategori;
import no.hib.dat101.modell.Selskap;
import no.hib.dat101.modell.Utleiekontor;
import no.hib.dat101.ui.Tekstgrensesnitt;

public class KlientSelskap {
	
	private static Tekstgrensesnitt tgr;
	private static Adresse adr;
	private static int valg;
	private static Selskap s;
	private static Bil b;
	private static Utleiekontor utleie;
	private static Kategori k;
	private static List<Utleiekontor> kontorer;
	
	
	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		tgr = new Tekstgrensesnitt();
		
	
		
		
		String meny = "1: Opprett nytt selskap\n2: Opprett Utleiekontor\n3: Legg til biler\n4: Avslutt";
		
		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1: //Opprett selskap
				s = new Selskap();
				adr = new Adresse();
				s.setFirma_navn(tgr.lesInnFirmanavn());
				adr.setGateadresse(tgr.lesInnGateadresse());
				adr.setPostnummer(tgr.lesInnPostnummer());
				adr.setPoststed(tgr.lesInnPoststed());
				s.setFirma_adresse(adr);
				s.setTelefonnummer(tgr.lesInnTelefonnummer());
				
			
				break;
				
			case 2: //Opprett utleiekontor
				utleie = s.opprettUtleiekontor();
				kontorer.add(utleie);
				
				
				break;
				
			case 3: //Legg til biler
				
				
				
				k = new Kategori();
				
				b.setMerke(tgr.lesInnMerke());
				b.setModell(tgr.lesInnModell());
				b.setFarge(tgr.lesInnFarge());
				b.setKm_stand(tgr.lesInnKm_stand());
				b.setReg_nummer(tgr.lesInnReg_nummer());
				k.setKategori_id(tgr.lesInnKategori());
				b.setKategori(k);
				
				for(int i = 0; i < kontorer.size(); i++){
					System.out.println(kontorer.iterator().next().getKontornummer());
				}
				
				System.out.println("Velg kontornummer for å knytte bil til kontor: ");
				
				b.setKontornummer(utleie);
				
				
				utleie.leggTilBil(b);
				
				break;
		
		
		
				}
			
			
		
			} while (valg != 4);
		
		s.lastOppSelskapDB();

		em.close();
		entityManagerFactory.close();
		tast.close();
			
	}
}