package no.hib.dat101.modell;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.RollbackException;
import javax.persistence.Table;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "kategori", schema = "bilutleie")
public class Kategori {
	@Id
	private Character kategori_id;
	private Integer dagspris;

	/**
	 * Tom konstruktør
	 * 
	 */
	public Kategori() {
		this(null, 0);
	}

	/**
	 * Konstruktør
	 * 
	 * @param kategori_id
	 * @param dagspris
	 */
	public Kategori(Character kategori_id, Integer dagspris) {
		this.kategori_id = kategori_id;
		this.dagspris = dagspris;
	}

	public void lastOppKategoriDB(EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * @return String representasjon av Kategori
	 */
	@Override
	public String toString() {
		return "kategori_id: " + kategori_id + ", dagspris: " + dagspris;
	}

	/**
	 * @return henter kategori_id
	 */
	public Character getKategori_id() {
		return kategori_id;
	}

	/**
	 * @param kategori_id
	 *            setter kategori_id
	 */
	public void setKategori_id(Character kategori_id) {
		this.kategori_id = kategori_id;
	}

	/**
	 * @return henter dagspris
	 */
	public Integer getDagspris() {
		return dagspris;
	}

	/**
	 * @param dagspris
	 *            setter dagspris
	 */
	public void setDagspris(Integer dagspris) {
		this.dagspris = dagspris;
	}

}
