/**
 * 
 */
package no.hib.dat101.modell;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Adresse {
	private Integer adresse_id;
	private String gateadresse;
	private Integer postnummer;
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
