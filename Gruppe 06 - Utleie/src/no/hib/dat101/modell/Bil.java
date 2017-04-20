package no.hib.dat101.modell;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Bil {
	private Integer reg_nummer;
	private String merke;
	private String modell;
	private String farge;
	private Kategori kategori;
	private Boolean er_ferdig;
	private Integer km_stand;
	private Utleiekontor kontornummer;

	/**
	 * 
	 * Tom Konstruktør
	 *
	 */
	public Bil() {
		this(0, "", "", "", null, null, 0, null);
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
	public Bil(Integer reg_nummer, String merke, String modell, String farge, Kategori kategori, Boolean er_ferdig,
			Integer km_stand, Utleiekontor kontornummer) {
		this.reg_nummer = reg_nummer;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
		this.er_ferdig = er_ferdig;
		this.km_stand = km_stand;
		this.kontornummer = kontornummer;
	}

	/**
	 * @return henter reg_nummer
	 */
	public Integer getReg_nummer() {
		return reg_nummer;
	}

	/**
	 * @param reg_nummer
	 *            setter reg_nummer
	 */
	public void setReg_nummer(Integer reg_nummer) {
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
	 * @return henter er_ferdig
	 */
	public Boolean getEr_ferdig() {
		return er_ferdig;
	}

	/**
	 * @param er_ferdig
	 *            setter er_ferdig
	 */
	public void setEr_ferdig(Boolean er_ferdig) {
		this.er_ferdig = er_ferdig;
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
