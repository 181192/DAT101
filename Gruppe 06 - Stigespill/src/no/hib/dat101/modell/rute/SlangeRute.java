package no.hib.dat101.modell.rute;

public class SlangeRute extends Rute {
	private Integer handling;

	public SlangeRute(Integer ruteNr, Integer handling) {
		super(ruteNr);
		this.handling = handling;
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

	@Override
	public void landetPaa() {
		// TODO
	}
}
