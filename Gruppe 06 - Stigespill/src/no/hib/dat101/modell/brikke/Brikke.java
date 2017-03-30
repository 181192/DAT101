package no.hib.dat101.modell.brikke;

import no.hib.dat101.modell.rute.Rute;

/**
 * Klasse for � representere en brikke
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Brikke {
	private BrikkeFarge farge;
	private Rute posisjon;

	public Brikke() {
		this(null, null);
	}

	/**
	 * Konstrukt�r for � opprette en ny brikke.
	 * 
	 * @param farge
	 *            Farge p� brikken. Kan velge mellom r�d, bl�, gr�nn og gul
	 * @param posisjon
	 *            Posisjonen p� hvor brikker er p� spillbrettet.
	 */
	public Brikke(BrikkeFarge farge, Rute posisjon) {
		this.farge = farge;
		this.posisjon = posisjon;
	}

	public BrikkeFarge getFarge() {
		return farge;
	}

	public void setFarge(BrikkeFarge farge) {
		this.farge = farge;
	}

	public Rute getPosisjon() {
		return posisjon;
	}

	public void setPosisjon(Rute posisjon) {
		this.posisjon = posisjon;
	}
}
