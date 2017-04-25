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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

import no.hib.dat101.ui.SelskapUI;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "selskap", schema = "bilutleie")
public class Selskap implements Comparable<Selskap> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer selskap_id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "firma_adresse", referencedColumnName = "adresse_id")
	private Adresse firma_adresse;
	@Column(name = "telefonnummer")
	private Integer telefonnummer;

	@Column(name = "firma_navn")
	private String firma_navn;

	@OneToMany(mappedBy = "selskap_id", cascade = CascadeType.ALL)
	private List<Utleiekontor> utleiekontorer;

	@Transient
	private EntityManager em;
	@Transient
	private SelskapUI ui;

	/**
	 * Konstruktør
	 * 
	 */
	public Selskap() {
		this(0, null, null, "");
		utleiekontorer = new ArrayList<>();
	}

	/**
	 * Konstruktør
	 * 
	 * @param selskap_id
	 * @param firma_adresse
	 * @param telefonnummer
	 * @param utleiekontorer
	 */
	public Selskap(Integer selskap_id, Adresse firma_adresse, Integer telefonnummer, String firma_navn) {
		this.selskap_id = selskap_id;
		this.firma_adresse = firma_adresse;
		this.telefonnummer = telefonnummer;
		this.firma_navn = firma_navn;
		utleiekontorer = new ArrayList<>();
	}

	/**
	 * Oppretter et utleiekontor
	 * 
	 * @return Utleiekontor
	 */
	public Utleiekontor opprettUtleiekontor() {
		Utleiekontor nyttKontor = new Utleiekontor();
		Adresse adresse = new Adresse();

		nyttKontor.setSelskap_id(this);
		nyttKontor.setTelefonnummer(ui.lesInnTelefonnummer());

		adresse.setGateadresse(ui.lesInnAdresse());
		adresse.setPostnummer(ui.lesInnPostnummer());
		adresse.setPoststed(ui.lesInnPoststed());

		nyttKontor.setAdresse(adresse);

		utleiekontorer.add(nyttKontor);
		return nyttKontor;
	}

	/**
	 * Sletter ett utleiekontor
	 */
	public Utleiekontor slettUtleiekontor(Utleiekontor utk) {
		int i = 0;
		Utleiekontor resultat = null;
		for (Utleiekontor k : utleiekontorer) {
			i++;
			if (k.compareTo(utk) == 0) {
				resultat = utleiekontorer.get(i);
				utleiekontorer.remove(i);
			}
		}
		// oppdatere databasen.
		return resultat;
	}

	@SuppressWarnings("unchecked")
	public void hentKontorerFraDB() {
		this.setUtleiekontorer(em
				.createQuery(//
						"SELECT u FROM Utleiekontor u WHERE u.selskap_id = :selskap") //
				.setParameter("selskap", this) //
				.getResultList());
	}

	/**
	 * Laster opp selskapet til databasen
	 */
	public void lastOppSelskapDB() {
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public int compareTo(Selskap detAndreSelskapet) {
		Selskap s2 = detAndreSelskapet;
		int resultat = -1;
		if (this.telefonnummer.compareTo(s2.telefonnummer) == 0) {
			resultat = this.firma_adresse.compareTo(s2.firma_adresse);
		} else if (this.telefonnummer.compareTo(s2.telefonnummer) > 1) {
			resultat = 1;
		}
		return resultat;
	}

	/**
	 * @return henter selskap_id
	 */
	public Integer getSelskap_id() {
		return selskap_id;
	}

	/**
	 * @param selskap_id
	 *            setter selskap_id
	 */
	public void setSelskap_id(Integer selskap_id) {
		this.selskap_id = selskap_id;
	}

	/**
	 * @return henter firma_adresse
	 */
	public Adresse getFirma_adresse() {
		return firma_adresse;
	}

	/**
	 * @param firma_adresse
	 *            setter firma_adresse
	 */
	public void setFirma_adresse(Adresse firma_adresse) {
		this.firma_adresse = firma_adresse;
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
	 * @return henter utleiekontorer
	 */
	public List<Utleiekontor> getUtleiekontorer() {
		return utleiekontorer;
	}

	/**
	 * @param utleiekontorer
	 *            setter utleiekontorer
	 */
	public void setUtleiekontorer(List<Utleiekontor> utleiekontorer) {
		this.utleiekontorer = utleiekontorer;
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

	/**
	 * @return henter ui
	 */
	public SelskapUI getUi() {
		return ui;
	}

	/**
	 * @param ui
	 *            setter ui
	 */
	public void setUi(SelskapUI ui) {
		this.ui = ui;
	}

	/**
	 * @return henter firma_navn
	 */
	public String getFirma_navn() {
		return firma_navn;
	}

	/**
	 * @param firma_navn  setter firma_navn
	 */
	public void setFirma_navn(String firma_navn) {
		this.firma_navn = firma_navn;
	}
}
