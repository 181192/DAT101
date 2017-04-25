package no.hib.dat101.modell;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "utleiekontor", schema = "bilutleie")
public class Utleiekontor implements Comparable<Utleiekontor> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kontornummer;

	@Column(name = "telefonnummer")
	private Integer telefonnummer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse", referencedColumnName = "adresse_id")
	private Adresse adresse;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "selskap_id", referencedColumnName = "selskap_id")
	private Selskap selskap_id;

	@OneToMany(mappedBy = "kontornummer", cascade = CascadeType.ALL)
	private List<Bil> biler;

	@Transient
	private EntityManager em;

	/**
	 * Konstruktør
	 * 
	 */
	public Utleiekontor() {
		this(0, 0, null, null);
		this.biler = new ArrayList<Bil>();
	}

	/**
	 * Konstruktør
	 * 
	 * @param kontornummer
	 * @param telefonnummer
	 * @param adresse
	 * @param selskap_id
	 */
	public Utleiekontor(Integer kontornummer, Integer telefonnummer, Adresse adresse, Selskap selskap_id) {
		this.kontornummer = kontornummer;
		this.telefonnummer = telefonnummer;
		this.adresse = adresse;
		this.selskap_id = selskap_id;
		this.biler = new ArrayList<Bil>();
	}

	/**
	 * Legger til en nybil til utleiekontoret
	 * 
	 * @param nybil
	 */
	public void leggTilBil(Bil nybil) {
		biler.add(nybil);
	}

	/**
	 * Sletter en bil fra utleiekontoret, dette kan være pga bilen er
	 * kondemnert.
	 * 
	 * @param b2
	 *            Bil som skal slettes
	 * @return Bil som er slettet
	 */
	public Bil slettBil(Bil b2) {
		Bil resultat = null;
		for (Bil b : biler) {
			if (b.compareTo(b2) == 0) {
				resultat = b;
				biler.remove(b);
			}
		}
		return resultat;
	}

	/**
	 * Henter biler som ligger i databasen som hører til dette utleiekontoret,
	 * og setter listen av biler i Utleiekontoret til dette.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void hentBilerFraDB() {
		setBiler(em
				.createQuery(//
						"SELECT b FROM Bil b WHERE b.kontornummer = :kontor") //
				.setParameter("kontor", this) //
				.getResultList());
	}

	/**
	 * Oppdaterer bilene til databasen. Dette vil være når bilene har kommet fra
	 * et utleiekontor til ett annet.
	 */
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

	@Override
	public int compareTo(Utleiekontor detAndreKontoret) {
		Utleiekontor u2 = detAndreKontoret;
		int resultat = -1;
		if (this.adresse.compareTo(u2.adresse) == 0) {
			resultat = this.telefonnummer.compareTo(u2.telefonnummer);
			if (resultat == 0) {
				resultat = this.selskap_id.compareTo(u2.selskap_id);
			}
		} else if (this.adresse.compareTo(u2.adresse) > 1) {
			resultat = 1;
		}
		return resultat;
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

	/**
	 * @return henter em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            setter em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
