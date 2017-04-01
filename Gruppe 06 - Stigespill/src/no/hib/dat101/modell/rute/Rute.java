package no.hib.dat101.modell.rute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rute_id;

	@Column(name = "rute_nr")
	private Integer rute_nr;

	@ManyToOne
	@JoinColumn(name = "brett_id", referencedColumnName = "brett_id")
	private Brett brett_id;

	@Column(name = "hopp_verdi")
	private Integer hopp_verdi;

	public Rute() {
	}

	public Rute(Integer rute_nr) {
		this.rute_nr = rute_nr;
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

	public Integer getRute_id() {
		return rute_id;
	}

	public void setRute_nr(Integer rute_nr) {
		this.rute_nr = rute_nr;
	}

	public Integer getRute_nr() {
		return rute_nr;
	}
}
