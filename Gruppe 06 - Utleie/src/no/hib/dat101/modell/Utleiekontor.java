package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.RollbackException;
import javax.persistence.Table;

@Entity
@Table(name = "utleiekontor", schema = "FYLLINNN")
public class Utleiekontor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kontornummer;

	@Column(name = "telefonnummer")
	private Integer telefonnummer;

	@Column(name = "adresse")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "selskap_id", referencedColumnName = "selskap")
	private Selskap selskap_id;

	private List<Bil> biler;
	private EntityManager em;

	/**
	 * Konstruktør
	 * 
	 */
	public Utleiekontor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Konstruktør
	 * 
	 * @param kontornummer
	 * @param telefonnummer
	 * @param adresse
	 * @param selskap_id
	 * @param biler
	 */
	public Utleiekontor(Integer kontornummer, Integer telefonnummer, Adresse adresse, Selskap selskap_id,
			List<Bil> biler) {
		super();
		this.kontornummer = kontornummer;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.selskap_id = selskap_id;
		this.biler = biler;
	}

	public void leggTilBil(Bil nybil) {
		biler.add(nybil);
	}

	public Bil slettBil(Bil bil) {
		// TODO Iterere gjennom alle bilene i Listen biler og slette bilen
		return null;
	}

	@SuppressWarnings("unchecked")
	public void hentBilerFraDB() {
		this.setBiler((List<Bil>) em
				.createQuery(//
						"SELECT b FROM Bil b WHERE b.kontornummer = :kontor") //
				.setParameter("kontor", kontornummer) //
				.getResultList());
	}

	public void oppdaterBilerDB() {
		for (int i = 0; i < biler.size(); i++) {
			try {
				em.getTransaction().begin();
				em.persist(biler.get(i));
				em.getTransaction().commit();
			} catch (RollbackException e) {
				em.getTransaction().rollback();
			}
		}
	}

	/**
	 * @return String representasjon av Utleiekontor
	 */
	@Override
	public String toString() {
		return "kontornummer: " + kontornummer + ", telefonnummer: " + telefonnummer + ", adresse: " + adresse
				+ ", selskap_id: " + selskap_id + ", biler: " + biler;
	}

	/**
	 * @return henter kontornummer
	 */
	public Integer getKontornummer() {
		return kontornummer;
	}

	/**
	 * @param kontornummer
	 *            setter kontornummer
	 */
	public void setKontornummer(Integer kontornummer) {
		this.kontornummer = kontornummer;
	}

	/**
	 * @return henter telefonnummer
	 */
	public Integer getTelefonnummer() {
		return telefonnummer;
	}

	/**
	 * @param telefonnummer
	 *            setter telefonnummer
	 */
	public void setTelefonnummer(Integer telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	/**
	 * @return henter adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            setter adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return henter selskap_id
	 */
	public Selskap getSelskap_id() {
		return selskap_id;
	}

	/**
	 * @param selskap_id
	 *            setter selskap_id
	 */
	public void setSelskap_id(Selskap selskap_id) {
		this.selskap_id = selskap_id;
	}

	/**
	 * @return henter biler
	 */
	public List<Bil> getBiler() {
		return biler;
	}

	/**
	 * @param biler
	 *            setter biler
	 */
	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}

}
