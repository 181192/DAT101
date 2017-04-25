package no.hib.dat101.modell;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;
import javax.persistence.Table;

@Entity
@Table(name = "utleie", schema = "bilutleie")
public class Utleie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer utleie_id;

	@Column(name = "kredittkort")
	private Long kredittkort;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservasjon", referencedColumnName = "reservasjon_id")
	private Reservasjon reservasjon;

	/**
	 * Konstruktør
	 * 
	 */
	public Utleie() {
		this(0, null, null);
	}

	/**
	 * Konstruktør
	 * 
	 * @param utleie_id
	 * @param kredittkort
	 * @param reservasjon_id
	 */
	public Utleie(Integer utleie_id, Long kredittkort, Reservasjon reservasjon) {
		super();
		this.utleie_id = utleie_id;
		this.kredittkort = kredittkort;
		this.reservasjon = reservasjon;
	}

	public void lastOppUtleieDB(EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
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
	public Long getKredittkort() {
		return kredittkort;
	}

	/**
	 * @param kredittkort
	 *            setter kredittkort
	 */
	public void setKredittkort(Long kredittkort) {
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
