package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kunde", schema = "bilutleie")
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kundenummer;
	@Column(name = "fornavn")
	private String fornavn;
	@Column(name = "etternavn")
	private String etternavn;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "telefonnummer")
	private Integer telefonnummer;

	/**
	 * Konstruktør
	 * 
	 */
	public Kunde() {
		this(0, "", "", "", 0);
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
	public Kunde(Integer kundenummer, String fornavn, String etternavn, String adresse, Integer telefonnummer) {
		this.kundenummer = kundenummer;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
	}

	/**
	 * 
	 * @return String repersentasjon av klassen Kunde
	 */
	@Override
	public String toString() {
		return "kundenummer: " + kundenummer + ", fornavn: " + fornavn + ", etternavn: " + etternavn + ", adresse: "
				+ adresse + ", telefonnummer: " + telefonnummer;
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
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            setter adresse
	 */
	public void setAdresse(String adresse) {
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
