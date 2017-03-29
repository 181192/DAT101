package no.hib.dat101.modell.rute;

/**
 * Klasse for å representere en slangerute
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class SlangeRute extends Rute {
	private Integer handling;

	/**
	 * Kontruktør for å opprette en slangerute
	 * 
	 * @param ruteNr
	 *            Rute nummeret
	 * @param handling
	 *            Antall ruter brikken må flytte seg.
	 */
	public SlangeRute(Integer ruteNr, Integer handling) {
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
