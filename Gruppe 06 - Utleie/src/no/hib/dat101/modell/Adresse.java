/**
 * 
 */
package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "adresse", schema = "bilutleie")
public class Adresse implements Comparable<Adresse> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adresse_id;
	@Column(name = "gateadresse")
	private String gateadresse;
	@Column(name = "postnummer")
	private Integer postnummer;
	@Column(name = "poststed")
	private String poststed;

	/**
	 * Tom konstukør
	 */
	public Adresse() {
		this(0, "", 0, "");
	}

	/**
	 * @param adresse_id
	 * @param gateadresse
	 * @param postnummer
	 * @param poststed
	 */
	public Adresse(Integer adresse_id, String gateadresse, Integer postnummer, String poststed) {
		this.adresse_id = adresse_id;
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.poststed = poststed;
	}

	@Override
	public int compareTo(Adresse denAndre) {
		Adresse a2 = (Adresse) denAndre;
		int resultat = -1;
		if (this.adresse_id == a2.adresse_id) {
			resultat = this.gateadresse.compareTo(a2.gateadresse);
			if (resultat == 0) {
				resultat = this.postnummer.compareTo(a2.postnummer);
				if (resultat == 0) {
					resultat = this.poststed.compareTo(poststed);
				}
			}
		} else if (this.adresse_id > a2.adresse_id) {
			resultat = 1;
		}
		return resultat;
	}

	/**
	 * @return String representasjon av Adresse
	 */
	@Override
	public String toString() {
		return "adresse_id: " + adresse_id + ", gateadresse: " + gateadresse + ", postnummer: " + postnummer
				+ ", poststed: " + poststed;
	}

	/**
	 * @return henter adresse_id
	 */
	public Integer getAdresse_id() {
		return adresse_id;
	}

	/**
	 * @param adresse_id
	 *            setter adresse_id
	 */
	public void setAdresse_id(Integer adresse_id) {
		this.adresse_id = adresse_id;
	}

	/**
	 * @return henter gateadresse
	 */
	public String getGateadresse() {
		return gateadresse;
	}

	/**
	 * @param gateadresse
	 *            setter gateadresse
	 */
	public void setGateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	/**
	 * @return henter postnummer
	 */
	public Integer getPostnummer() {
		return postnummer;
	}

	/**
	 * @param postnummer
	 *            setter postnummer
	 */
	public void setPostnummer(Integer postnummer) {
		this.postnummer = postnummer;
	}

	/**
	 * @return henter poststed
	 */
	public String getPoststed() {
		return poststed;
	}

	/**
	 * @param poststed
	 *            setter poststed
	 */
	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

}
