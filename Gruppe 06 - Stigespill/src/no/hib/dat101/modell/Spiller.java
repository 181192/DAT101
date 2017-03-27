package no.hib.dat101.modell;

import no.hib.dat101.modell.brikke.Brikke;

public class Spiller {

	private String navn;
	private Brikke brikke;

	public Spiller(String navn, Brikke brikke) {

		this.navn = navn;
		this.brikke = brikke;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Brikke getBrikke() {
		return brikke;
	}

	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
	
	public void spillTrekk() {
		// TODO
	}

	@Override
	public String toString() {
		return "Spiller [navn=" + navn + ", brikke=" + brikke + "]";
	}
	
	

}
