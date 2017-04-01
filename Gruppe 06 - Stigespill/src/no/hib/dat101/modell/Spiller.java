package no.hib.dat101.modell;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import no.hib.dat101.modell.brikke.Brikke;

/**
 * Klasse for å fremstille en spiller
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "spiller", schema = "kristoffer_stigespill")
public class Spiller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer spiller_id;
	@Column(name = "navn")
	private String navn;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "stigespill_id", referencedColumnName = "stigespill_id")
	private Stigespill stigespill_id;
	@Transient
	private Brikke brikke;

	/**
	 * Tom konstruktør for Spiller
	 */
	public Spiller() {
		this("", null);
	}

	/**
	 * Konstruktør for spiller, oppretter en spiller med navn og en brikke
	 * 
	 * @param navn
	 *            Navn på spiller
	 * @param brikke
	 *            Brikke spilleren velger å være
	 */
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

	public Integer getSpiller_id() {
		return spiller_id;
	}

	public void setSpiller_id(Integer spiller_id) {
		this.spiller_id = spiller_id;
	}

	public Stigespill getStigespill_id() {
		return stigespill_id;
	}

	public void setStigespill_id(Stigespill stigespill_id) {
		this.stigespill_id = stigespill_id;
	}

	/**
	 * String representasjon av en spiller
	 */
	@Override
	public String toString() {
		return "navn: " + navn + ",\t\t brikke: " + brikke.getFarge().toString() + ",\t\t posisjon: "
				+ brikke.getPosisjon().getRute_nr().intValue();
	}

}
