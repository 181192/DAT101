package no.hib.dat101.modell;

public class Kunde {
	private Integer kundenummer;
	private String fornavn;
	private String etternavn;
	private Adresse adresse;
	private Integer telefonnummer;

	/**
	 * Konstruktør
	 * 
	 */
	public Kunde() {
		this(0, "", "", null, 0);
	}

	/**
	 * Konstruktør
	 * 
	 * @param kundenummer
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param telefonnummer
	 */
	public Kunde(Integer kundenummer, String fornavn, String etternavn, Adresse adresse, Integer telefonnummer) {
		this.kundenummer = kundenummer;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
	}

	/**
	 * @return henter kundenummer
	 */
	public Integer getKundenummer() {
		return kundenummer;
	}

	/**
	 * @param kundenummer
	 *            setter kundenummer
	 */
	public void setKundenummer(Integer kundenummer) {
		this.kundenummer = kundenummer;
	}

	/**
	 * @return henter fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * @param fornavn
	 *            setter fornavn
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * @return henter etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * @param etternavn
	 *            setter etternavn
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
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

}
