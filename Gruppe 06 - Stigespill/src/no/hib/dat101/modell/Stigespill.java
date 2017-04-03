package no.hib.dat101.modell;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	@Transient
	private List<Logg> logger;
	@Transient
	private Logg logg;
	@Transient
	private Spiller vinner;

	/**
	 * Tom konstrukt�r for stigespill
	 */
	public Stigespill() {
		this(null);
		brett = new Brett();
		spillere = new ArrayList<Spiller>();
		logger = new ArrayList<Logg>();
		terning = new Terning();
		antallTrill = 0;
		spillFerdig = Boolean.FALSE;
	}

	/**
	 * Konstrukt�r for stigespill
	 * 
	 */
	public Stigespill(StigespillUI ui) {
		this.ui = ui;
		brett = new Brett();
		spillere = new ArrayList<Spiller>();
		logger = new ArrayList<Logg>();
		terning = new Terning();
		antallTrill = 0;
		spillFerdig = Boolean.FALSE;
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
		System.out.println("\tSpill avsluttet etter " + i + " runder");
	}

	/**
	 * En spiller har kommet i m�l
	 * 
	 * @param rute
	 * @return True visst spiller er i m�l
	 */
	public Boolean erFerdig(Spiller spiller) {
		if (spiller.getBrikke().getPosisjon().getRute_nr() == brett.getANTALL_RUTER() - 1) {
			spillFerdig = Boolean.TRUE;
			vinner = spiller;
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

		}
	}

	/**
	 * Spiller skal trille trening eller trille p� nytt, finne posisjon til
	 * brikken, og flytte den og sette nyposisjon.
	 * 
	 * @param spiller
	 *            Spiller som skal trekke
	 */
	public void spillTrekk(Spiller spiller) {
		do {
			logg = new Logg();
			logg.setSpiller(spiller);
			logg.setRute_fra(spiller.getBrikke().getPosisjon());

			terning.trill();
			settNyPlass(brett.finnRute(spiller.getBrikke().getPosisjon(), terning.getVerdi()), spiller);

			logg.setRute_til(spiller.getBrikke().getPosisjon());
			// ui.infoOmTrekk(logg);
			logger.add(logg);

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
		logg.setRute_til(spiller.getBrikke().getPosisjon());
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

	public Boolean getSpillFerdig() {
		return spillFerdig;
	}

	public void setSpillFerdig(Boolean spillFerdig) {
		this.spillFerdig = spillFerdig;
	}

	public List<Logg> getLogger() {
		return logger;
	}

	public void setLogger(List<Logg> logger) {
		this.logger = logger;
	}

	public Logg getLogg() {
		return logg;
	}

	public void setLogg(Logg logg) {
		this.logg = logg;
	}

	public Spiller getVinner() {
		return vinner;
	}

	public void setVinner(Spiller vinner) {
		this.vinner = vinner;
	}

}
