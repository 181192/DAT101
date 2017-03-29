package no.hib.dat101.modell;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import no.hib.dat101.modell.brikke.Brikke;
import no.hib.dat101.modell.brikke.BrikkeFarge;
import no.hib.dat101.modell.rute.Rute;

@Entity
@Table(name = "stigespill", schema = "kristoffer_stigespill")
public class Stigespill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stigespill_id;
	private List<Spiller> spillere;
	private Integer antallSpillere;
	@Column(name = "brett")
	private Brett brett;
	private Terning terning;
	private Integer antallTrill;

	/**
	 * Konstruktør for stigespill
	 * 
	 * @param spillere
	 * @param brett
	 */
	public Stigespill() {
		terning = new Terning();
		spillere = new ArrayList<>();
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
	public void opprettSpiller(String navn, BrikkeFarge farge) {
		Brikke nyBrikke = new Brikke(farge, brett.getRuteTab().get(0));
		Spiller nySpiller = new Spiller(navn, nyBrikke);
		spillere.add(nySpiller);
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
	 * @return Ny verdi på terningen visst det forrige kastet var 6 og ikke
	 *         kastet 6 mer enn 3 ganger. Ellers returnere den 0.
	 */
	public int trillPaaNytt() {
		int nyttKast = 0;
		if (terning.getVerdi() == 6 && antallTrill < 3) {
			terning.trill();
			nyttKast = terning.getVerdi();
			antallTrill++;
		}
		return nyttKast;
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

	public Integer getStigespill_id() {
		return stigespill_id;
	}

	public void setStigespill_id(Integer stigespill_id) {
		this.stigespill_id = stigespill_id;
	}

	public List<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(List<Spiller> spillere) {
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
