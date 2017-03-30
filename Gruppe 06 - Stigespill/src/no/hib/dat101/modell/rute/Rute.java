package no.hib.dat101.modell.rute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import no.hib.dat101.modell.Brett;

/**
 * Klassen representerer en rute.
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "rute", schema = "kristoffer_stigespill")
public class Rute {
	@Id
	private final Integer ruteNr;

	@ManyToOne
	@JoinColumn(name = "brett", referencedColumnName = "brett_id")
	private Brett brett_id;

	@Column(name = "hopp_verdi")
	private Integer hopp_verdi;

	/**
	 * Konstruktør for å opprette en rute
	 * 
	 * @param ruteNr
	 *            Nummeret på ruten, må være ett tall mellom 0 - 99
	 */
	public Rute(Integer ruteNr) {
		this.ruteNr = ruteNr;
	}

	public Brett getBrett_id() {
		return brett_id;
	}

	public void setBrett_id(Brett brett_id) {
		this.brett_id = brett_id;
	}

	public Integer getHopp_verdi() {
		return hopp_verdi;
	}

	public void setHopp_verdi(Integer hopp_verdi) {
		this.hopp_verdi = hopp_verdi;
	}

	public Integer getRuteNr() {
		return ruteNr;
	}
}
