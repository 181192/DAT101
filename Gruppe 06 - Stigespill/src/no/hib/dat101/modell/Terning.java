package no.hib.dat101.modell;

import java.util.Random;

/**
 * Klassen representerer en terning
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */

public class Terning {
	private static final Random RAND = new Random(System.currentTimeMillis());
	private Integer verdi;

	/**
	 * Ny terning
	 */
	public Terning() {
	}

	/**
	 * Triller terningen, og gir terningen en ny verdi
	 * 
	 * @return Verdien på terningen
	 */
	public void trill() {
		verdi = RAND.nextInt(6) + 1;
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(Integer verdi) {
		this.verdi = verdi;
	}
}
