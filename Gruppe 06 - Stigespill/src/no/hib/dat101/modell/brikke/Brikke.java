package no.hib.dat101.modell.brikke;

import no.hib.dat101.modell.rute.Rute;

public class Brikke {
	private BrikkeFarge farge;
	private Rute posisjon;

	public Brikke(BrikkeFarge farge, Rute posisjon) {
		super();
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
