package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utleie", schema = "bilutleie")
public class Utleie extends Reservasjon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer utleie_id;

	@Column(name = "kredittkort")
	private Integer kredittkort;

	@OneToOne
	@JoinColumn(name = "reservasjon", referencedColumnName = "reservasjon_id")
	private Reservasjon reservasjon;

	/**
	 * Konstrukt�r
	 * 
	 */
	public Utleie() {
		this(0, 0, null);
	}

	/**
	 * Konstrukt�r
	 * 
	 * @param utleie_id
	 * @param kredittkort
	 * @param reservasjon_id
	 */
	public Utleie(Integer utleie_id, Integer kredittkort, Reservasjon reservasjon) {
		super();
		this.utleie_id = utleie_id;
		this.kredittkort = kredittkort;
		this.reservasjon = reservasjon;
	}

	/**
	 * @return String represenasjon av Utleie
	 */
	@Override
	public String toString() {
		return "utleie_id: " + utleie_id + ", kredittkort: " + kredittkort + ", reservasjon: " + reservasjon;
	}

	/**
	 * @return henter utleie_id
	 */
	public Integer getUtleie_id() {
		return utleie_id;
	}

	/**
	 * @param utleie_id
	 *            setter utleie_id
	 */
	public void setUtleie_id(Integer utleie_id) {
		this.utleie_id = utleie_id;
	}

	/**
	 * @return henter kredittkort
	 */
	public Integer getKredittkort() {
		return kredittkort;
	}

	/**
	 * @param kredittkort
	 *            setter kredittkort
	 */
	public void setKredittkort(Integer kredittkort) {
		this.kredittkort = kredittkort;
	}

	/**
	 * @return henter reservasjon_id
	 */
	public Reservasjon getReservasjon() {
		return reservasjon;
	}

	/**
	 * @param reservasjon_id
	 *            setter reservasjon_id
	 */
	public void setReservasjon(Reservasjon reservasjon) {
		this.reservasjon = reservasjon;
	}

}
