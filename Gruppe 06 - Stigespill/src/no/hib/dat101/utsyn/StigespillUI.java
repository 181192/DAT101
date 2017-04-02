package no.hib.dat101.utsyn;

import java.util.List;

import no.hib.dat101.modell.Brett;
import no.hib.dat101.modell.Logg;
import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.Stigespill;
import no.hib.dat101.modell.brikke.BrikkeFarge;

public interface StigespillUI {

	/**
	 * Leser inn antall spillere fra brukeren
	 * 
	 * @return Antall spillere
	 */
	public Integer lesAntallSpillere();

	/**
	 * Leser inn spiller navnet fra brukeren
	 * 
	 * @return Navnet p� spilleren
	 */
	public String lesInnSpiller();

	/**
	 * Metode for � lese inn fargen p� brikken fra brukeren, tall mellom 0-3.
	 * Hvor 1 = RED, 2 = BLUE, 3 = GREEN, 4 = YELLOW
	 * 
	 * @return BrikkeFarge (Enum)
	 */
	public BrikkeFarge lesInnBrikkeFarge();

	/**
	 * Returnerer info om en spiller i konsollen
	 * 
	 * @param spiller
	 */
	public String infoOmTrekk(Logg logg);

	/**
	 * Metode for � finne ut hvem som vant
	 * 
	 * @return Hvem som vant
	 */
	public void vinner(Stigespill stigespill);

	/**
	 * Metode for � velge brettet man skal spille p�
	 * 
	 * @return brett_id
	 */
	public Integer velgBrett();

	/**
	 * Metode for � skrive ut antall ruter
	 */
	public void antallRuter(Brett brett);

	/**
	 * Metode for � skrive ut antall spillere i spillet
	 * 
	 * @param spillere
	 *            Tabell av spillere
	 */
	public void antallSpillere(List<Spiller> spillere);
}
