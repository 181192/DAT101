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
import no.hib.dat101.modell.rute.Rute;
import no.hib.dat101.utsyn.StigespillUI;

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
	private StigespillUI ui;
	private Boolean spillFerdig;

	/**
	 * Konstruktør for stigespill
	 * 
	 */
	public Stigespill(StigespillUI ui) {
		this.ui = ui;
		antallTrill = 0;
		terning = new Terning();
		spillere = new ArrayList<>();
		brett = new Brett();
		spillFerdig = false;
		settOppSpill();
	}

	/**
	 * Starter stigespillet
	 */
	public void start() {
		int i = 0;
		while (!spillFerdig) {
			spillRunde();
			
			i++;
		}
		System.out.println("Runde avsluttet etter " + i + " trekk");
	}

	/**
	 * Setter opp spillet, oppretter nye spillere, brikker .. etc
	 */
	public void settOppSpill() {
		antallSpillere = ui.lesAntallSpillere();
		spillFerdig = false;
		for (int i = 0; i < antallSpillere; i++) {
			String navn = ui.lesInnSpiller();
			Brikke brikke = new Brikke(ui.lesInnBrikkeFarge(), brett.getRuteTab().get(0));
			Spiller spiller = new Spiller(navn, brikke);
			spillere.add(spiller);
		}
	}

	/**
	 * En spiller har kommet i mål
	 * 
	 * @param rute
	 * @return True visst spiller er i mål
	 */
	public Boolean erFerdig(Spiller spiller) {
		if (spiller.getBrikke().getPosisjon().getRuteNr() == brett.getANTALL_RUTER() - 1) {
			spillFerdig = true;
		}
		return spillFerdig;
	}

	/**
	 * Spiller en runde
	 */
	public void spillRunde() {
		for (int i = 0; i < getAntallSpillere() && !erFerdig(spillere.get(i)); i++) {
			Spiller s = spillere.get(i);
			spillTrekk(s);
			ui.infoOmSpiller(s);
		}
	}

	/**
	 * Spiller skal trille trening eller trille på nytt, finne posisjon til
	 * brikken, og flytte den og sette nyposisjon.
	 * 
	 * @param spiller
	 *            Spiller som skal trekke
	 */
	public void spillTrekk(Spiller spiller) {
		do {
			terning.trill();
			settNyPlass(brett.finnRute(spiller.getBrikke().getPosisjon(), terning.getVerdi()), spiller);
			antallTrill++;
		} while (!erFerdig(spiller) && terning.getVerdi() == 6 && antallTrill < 3);
		
	}
	/**
	 * Flytter brikken til spilleren til en ny rute og tar hensyn til hoppverdi (slange eller stige)
	 * 
	 * @param rute
	 * @param spiller
	 */
	public void settNyPlass(Rute rute, Spiller spiller) {
		spiller.getBrikke().setPosisjon(brett.getRuteTab().get(rute.getRuteNr() + rute.getHopp_verdi()));
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

	public StigespillUI getUi() {
		return ui;
	}

	public void setUi(StigespillUI ui) {
		this.ui = ui;
	}
}
