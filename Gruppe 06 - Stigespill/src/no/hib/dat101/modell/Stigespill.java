package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import no.hib.dat101.modell.brikke.Brikke;
import no.hib.dat101.modell.rute.Rute;
import no.hib.dat101.utsyn.StigespillUI;

@Entity
@Table(name = "stigespill", schema = "kristoffer_stigespill")
public class Stigespill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stigespill_id;

	@JoinColumn(name = "brett", referencedColumnName = "brett_id")
	private Brett brett;

	@Transient
	private Terning terning;
	@Transient
	private Integer antallTrill;
	@Transient
	private StigespillUI ui;
	@Transient
	private Boolean spillFerdig;
	@Transient
	private List<Spiller> spillere;

	/**
	 * Tom konstruktør for stigespill
	 */
	public Stigespill() {
		this(null, null, null);
		terning = new Terning();
		antallTrill = 0;
		spillFerdig = Boolean.FALSE;
	}

	/**
	 * Konstruktør for stigespill
	 * 
	 */
	public Stigespill(StigespillUI ui, Brett brett, List<Spiller> spillere) {
		this.spillere = spillere;
		this.brett = brett;
		this.ui = ui;
		terning = new Terning();
		antallTrill = 0;
		spillFerdig = Boolean.FALSE;
		// settOppSpill();
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
		spillFerdig = Boolean.FALSE;
		for (int i = 0; i < antallSpillere(); i++) {
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
		if (spiller.getBrikke().getPosisjon().getRute_nr() == brett.getANTALL_RUTER() - 1) {
			spillFerdig = Boolean.TRUE;
		}
		return spillFerdig;
	}

	/**
	 * Spiller en runde
	 */
	public void spillRunde() {
		for (int i = 0; i < antallSpillere() && !erFerdig(spillere.get(i)); i++) {
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
	 * Flytter brikken til spilleren til en ny rute og tar hensyn til hoppverdi
	 * (slange eller stige)
	 * 
	 * @param rute
	 * @param spiller
	 */
	public void settNyPlass(Rute rute, Spiller spiller) {
		spiller.getBrikke().setPosisjon(brett.getRuteTab().get(rute.getRute_nr() + rute.getHopp_verdi()));
	}

	/**
	 * Antall spillere i Arrayen
	 * 
	 * @return Returnerer antall spillere som integer
	 */
	public Integer antallSpillere() {
		return spillere.size();
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
