package no.hib.dat101.modell;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.RollbackException;
import javax.persistence.Table;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "bil", schema = "bilutleie")
public class Bil implements Comparable<Bil> {
	@Id
	private String reg_nummer;
	@Column(name = "merke")
	private String merke;
	@Column(name = "modell")
	private String modell;
	@Column(name = "farge")
	private String farge;
	@Column(name = "er_ledig")
	private Boolean er_ledig;
	@Column(name = "km_stand")
	private Integer km_stand;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kategori", referencedColumnName = "kategori_id")
	private Kategori kategori;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "kontornummer", referencedColumnName = "kontornummer")
	private Utleiekontor kontornummer;

	/**
	 * 
	 * Tom Konstruktør
	 *
	 */
	public Bil() {
		this("", "", "", "", null, Boolean.TRUE, 0, null);
	}

	/**
	 * Konstruktør
	 * 
	 * @param reg_nummer
	 * @param merke
	 * @param modell
	 * @param farge
	 * @param kategori
	 * @param er_ferdig
	 * @param km_stand
	 * @param kontornummer
	 */
	public Bil(String reg_nummer, String merke, String modell, String farge, Kategori kategori, Boolean er_ledig,
			Integer km_stand, Utleiekontor kontornummer) {
		this.reg_nummer = reg_nummer;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
		this.er_ledig = er_ledig;
		this.km_stand = km_stand;
		this.kontornummer = kontornummer;
	}
	
	public void lastOppBilDB(EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(this);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * Sammenligner bilen med denAndreBilen. Sammenligner først reg_nummer,
	 * deretter merke, deretter modell, og tilslutt farge.
	 * 
	 * @param denAndreBilen
	 *            Den andre bilen som skal sammenlignes med
	 * @return 0 hvis de er like.
	 */
	@Override
	public int compareTo(Bil denAndreBilen) {
		Bil b2 = denAndreBilen;
		int resultat = -1;
		if (this.reg_nummer.compareTo(b2.reg_nummer) == 0) {
			resultat = this.merke.compareTo(b2.merke);
			if (resultat == 0) {
				resultat = this.modell.compareTo(b2.modell);
				if (resultat == 0) {
					resultat = this.farge.compareTo(b2.farge);
				}
			}
		} else if (this.reg_nummer.compareTo(b2.reg_nummer) > 1) {
			resultat = 1;
		}
		return resultat;
	}

	/**
	 * @return String representasjon av Bil
	 */
	@Override
	public String toString() {
		return "reg_nummer: " + reg_nummer + ", merke: " + merke + ", modell: " + modell + ", farge: " + farge
				+ ", er_ledig: " + er_ledig + ", km_stand: " + km_stand + ", kategori: " + kategori + ", kontornummer: "
				+ kontornummer;
	}

	/**
	 * @return henter reg_nummer
	 */
	public String getReg_nummer() {
		return reg_nummer;
	}

	/**
	 * @param reg_nummer
	 *            setter reg_nummer
	 */
	public void setReg_nummer(String reg_nummer) {
		this.reg_nummer = reg_nummer;
	}

	/**
	 * @return henter merke
	 */
	public String getMerke() {
		return merke;
	}

	/**
	 * @param merke
	 *            setter merke
	 */
	public void setMerke(String merke) {
		this.merke = merke;
	}

	/**
	 * @return henter modell
	 */
	public String getModell() {
		return modell;
	}

	/**
	 * @param modell
	 *            setter modell
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 * @return henter farge
	 */
	public String getFarge() {
		return farge;
	}

	/**
	 * @param farge
	 *            setter farge
	 */
	public void setFarge(String farge) {
		this.farge = farge;
	}

	/**
	 * @return henter kategori
	 */
	public Kategori getKategori() {
		return kategori;
	}

	/**
	 * @param kategori
	 *            setter kategori
	 */
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	/**
	 * @return henter er_ledig
	 */
	public Boolean getEr_ledig() {
		return er_ledig;
	}

	/**
	 * @param er_ledig
	 *            setter er_ledig
	 */
	public void setEr_ledig(Boolean er_ledig) {
		this.er_ledig = er_ledig;
	}

	/**
	 * @return henter km_stand
	 */
	public Integer getKm_stand() {
		return km_stand;
	}

	/**
	 * @param km_stand
	 *            setter km_stand
	 */
	public void setKm_stand(Integer km_stand) {
		this.km_stand = km_stand;
	}

	/**
	 * @return henter kontornummer
	 */
	public Utleiekontor getKontornummer() {
		return kontornummer;
	}

	/**
	 * @param kontornummer
	 *            setter kontornummer
	 */
	public void setKontornummer(Utleiekontor kontornummer) {
		this.kontornummer = kontornummer;
	}

}
