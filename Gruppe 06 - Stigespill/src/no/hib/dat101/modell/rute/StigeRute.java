package no.hib.dat101.modell.rute;

/**
 * Klasse for å representere en stigerute
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class StigeRute extends Rute {
	private Integer handling;

	/**
	 * Konstruktør for å opprette en slange rute.
	 * 
	 * @param ruteNr
	 *            Rute nummeret
	 * @param handling
	 *            Antall ruter brikken må flytte
	 */
	public StigeRute(Integer ruteNr, Integer handling) {
		super(ruteNr);
		this.handling = handling;
	}

	@Override
	public void landetPaa() {
		// TODO
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

}
