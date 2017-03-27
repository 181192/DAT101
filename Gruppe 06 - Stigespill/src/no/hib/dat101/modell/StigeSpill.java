package no.hib.dat101.modell;

import no.hib.dat101.modell.rute.Rute;

public class StigeSpill {
	private Spiller[] spillere;
	private Integer antallSpillere;
	private Brett brett;
	private Terning terning;
	private Integer antallTrill;

	public StigeSpill(Spiller[] spillere, Integer antallSpillere, Brett brett, Terning terning) {
		this.spillere = spillere;
		this.antallSpillere = antallSpillere;
		this.brett = brett;
		this.terning = terning;
		antallTrill = 0;
	}

	public void start() {
		// TODO
	}

	public void opprettSpiller() {
		// TODO
	}

	public void settOppSpill() {
		// TODO
	}

	public Terning trillPaaNytt() {
		// TODO
		return null;
	}

	public Boolean erFerdig(Rute rute) {
		// TODO
		return false;
	}

	public void spillRunde() {
		// TODO
	}

	public Spiller[] getSpillere() {
		return spillere;
	}

	public void setSpillere(Spiller[] spillere) {
		this.spillere = spillere;
	}

	public Integer getAntallSpillere() {
		return antallSpillere;
	}

	public void setAntallSpillere(Integer antallSpillere) {
		this.antallSpillere = antallSpillere;
	}

	public Brett getBrett() {
		return brett;
	}

	public void setBrett(Brett brett) {
		this.brett = brett;
	}

	public Terning getTerning() {
		return terning;
	}

	public void setTerning(Terning terning) {
		this.terning = terning;
	}

	public Integer getAntallTrill() {
		return antallTrill;
	}

	public void setAntallTrill(Integer antallTrill) {
		this.antallTrill = antallTrill;
	}

}
