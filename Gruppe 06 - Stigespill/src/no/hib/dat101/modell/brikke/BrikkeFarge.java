package no.hib.dat101.modell.brikke;

/**
 * Enum klasse for å representerere fargene som spill brikkene kan være.
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public enum BrikkeFarge {

	RED(0), BLUE(1), GREEN(2), YELLOW(3);

	private Integer nr;

	private BrikkeFarge(Integer nr) {
		this.nr = nr;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	/**
	 * Metode for å finne brikke fargen ved å sende inn ett tall i stedet
	 * @param nr Nummer for å representere en farge 0 - 3
	 * @return returnerer fargen som en enum.
	 */
	public static BrikkeFarge finnBrikkeFarge(Integer nr) {
		// TODO
		return null;

	}
}
