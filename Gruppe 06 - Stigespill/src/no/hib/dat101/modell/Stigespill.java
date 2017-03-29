package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import no.hib.dat101.modell.rute.Rute;

@Entity
@Table(name = "stigespill", schema = "kristoffer_stigespill")
public class Stigespill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stigespill_id;
	private Spiller[] spillere;
	private Integer antallSpillere;
	@Column(name = "brett")
	private Brett brett;
	private Terning terning;
	private Integer antallTrill;

	/**
	 * Konstruktør for stigespill
	 * 
	 * @param spillere
	 * @param antallSpillere
	 * @param brett
	 * @param terning
	 */
	public Stigespill(Spiller[] spillere, Integer antallSpillere, Brett brett, Terning terning) {
		this.spillere = spillere;
		this.antallSpillere = antallSpillere;
		this.brett = brett;
		this.terning = terning;
		antallTrill = 0;
	}

	/**
	 * Starter stigespillet
	 */
	public void start() {
		// TODO
	}

	/**
	 * Oppretter en ny spiller
	 */
	public void opprettSpiller() {
		// TODO
	}

	/**
	 * Setter opp spillet
	 */
	public void settOppSpill() {
		// TODO
	}

	/**
	 * Triller terningen på nytt visst en har fått seks
	 * 
	 * @return
	 */
	public Terning trillPaaNytt() {
		// TODO
		return null;
	}

	/**
	 * En spiller har kommet i mål
	 * 
	 * @param rute
	 * @return True visst spiller er i mål
	 */
	public Boolean erFerdig(Rute rute) {
		// TODO
		return false;
	}

	/**
	 * Spiller en runde
	 */
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
