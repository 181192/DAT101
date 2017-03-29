package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@OneToOne
	@JoinColumn(name = "brikke", referencedColumnName = "brikke_id")
	private Brikke brikke;

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

	/**
	 * Spille ett trekk som innebærer å trille en terning og flytte en brikke
	 */
	public void spillTrekk() {
		// TODO
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

	/**
	 * String representasjon av en spiller
	 */
	@Override
	public String toString() {
		return "Spiller [navn=" + navn + ", brikke=" + brikke + "]";
	}

}
