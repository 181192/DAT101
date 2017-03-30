package no.hib.dat101.modell.brikke;

import no.hib.dat101.modell.rute.Rute;

/**
 * Klasse for å representere en brikke
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
	 * Konstruktør for å opprette en ny brikke.
	 * 
	 * @param farge
	 *            Farge på brikken. Kan velge mellom rød, blå, grønn og gul
	 * @param posisjon
	 *            Posisjonen på hvor brikker er på spillbrettet.
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
