package no.hib.dat101.utsyn;

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
	 * @return Navnet på spilleren
	 */
	public String lesInnSpiller();

	/**
	 * Metode for å lese inn fargen på brikken fra brukeren, tall mellom 0-3.
	 * Hvor 1 = RED, 2 = BLUE, 3 = GREEN, 4 = YELLOW
	 * 
	 * @return BrikkeFarge (Enum)
	 */
	public BrikkeFarge lesInnBrikkeFarge();
}
