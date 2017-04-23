/**
 * 
 */
package no.hib.dat101.ui;

import java.sql.Date;
import java.sql.Time;

import no.hib.dat101.modell.Bil;
import no.hib.dat101.modell.Retur;
import no.hib.dat101.modell.Utleiekontor;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public interface SelskapUI {
	/**
	 * Leser inn gateadressen til Adressen
	 * 
	 * @return
	 */
	public String lesInnGateadresse();

	/**
	 * Leser inn postnummeret til Adressen
	 * 
	 * @return
	 */
	public Integer lesInnPostnummer();

	/**
	 * Leser inn poststedet til Adressen
	 * 
	 * @return
	 */
	public String lesInnPoststed();

	/**
	 * Leser inn registreringsnummeret til bilen
	 * 
	 * @return
	 */
	public String lesInnReg_nummer();

	/**
	 * Leser inn merke til bilen
	 * 
	 * @return
	 */
	public String lesInnMerke();

	/**
	 * Leser inn modellen til bilen
	 * 
	 * @return
	 */
	public String lesInnModell();

	/**
	 * Leser inn fargen til bilen
	 * 
	 * @return
	 */
	public String lesInnFarge();

	/**
	 * Leser inn kategorien til bilen
	 * 
	 * @return
	 */
	public Character lesInnKategori();

	/**
	 * Leser inn km-standen til bilen
	 * 
	 * @return
	 */
	public Integer lesInnKm_stand();

	/**
	 * Leser inn fornavnet til kunden
	 * 
	 * @return
	 */
	public String lesInnFornavn();

	/**
	 * Leser inn etternavnet til kunden
	 * 
	 * @return
	 */
	public String lesInnEtternavn();

	/**
	 * Leser inn adressen til kunden, oppgi både gateadresse, postnummer, og
	 * poststed. Skill med komma mellom hver type.
	 * 
	 * @return
	 */
	public String lesInnAdresse();

	/**
	 * Leser inn telefonnummeret til kunden
	 * 
	 * @return
	 */
	public Integer lesInnTelefonnummer();

	/**
	 * Leser inn kredittkortet til kunden
	 * 
	 * @return
	 */
	public Integer lesInnKredittkort();

	/**
	 * Leser inn klokkeslett
	 * 
	 * @return
	 */
	public Time lesInnKlokkeslett();

	/**
	 * Leser inn dato
	 * 
	 * @return
	 */
	public Date lesInnDato();

	/**
	 * Viser ledige biler på utleiekontoret
	 */
	public void visLedigeBiler(Utleiekontor kontor);

	/**
	 * Viser kategorier bilene er delt opp i
	 */
	public void visKategorier();

	/**
	 * Viser utleiekontorene
	 */
	public void visUtleieKontorer();

	/**
	 * Skriver faktura til kunden
	 */
	public void skrivFaktura(Retur retur);

	/**
	 * Bekrefter med enten True eller False med 0 eller 1 som input
	 * 
	 * @return True eller False
	 */
	public Boolean bekreft();

	/**
	 * Velger en bil med et tall som er indeksen i tabellen fra utleiekontoret
	 * bilene hentes fra
	 * 
	 * @return Bilen som kunden velger
	 */
	public Bil velgBil();

	/**
	 * Velger et Utleiekontor som er indeksen i tabellen fra selskapet som
	 * utleiekontorene hentes fra.
	 * 
	 * @return Utleiekontoret som er valgt
	 */
	public Utleiekontor velgUtleiekontor();
}
