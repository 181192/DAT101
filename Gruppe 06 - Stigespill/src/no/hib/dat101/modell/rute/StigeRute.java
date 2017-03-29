package no.hib.dat101.modell.rute;

/**
 * Klasse for � representere en stigerute
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class StigeRute extends Rute {
	private Integer handling;

	/**
	 * Konstrukt�r for � opprette en slange rute.
	 * 
	 * @param ruteNr
	 *            Rute nummeret
	 * @param handling
	 *            Antall ruter brikken m� flytte
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
