package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "selskap", schema = "bilutleie")
public class Selskap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer selskap_id;
	@Column(name = "firma_adresse")
	private Adresse firma_adresse;
	@Column(name = "telefonnummer")
	private Integer telefonnummer;
	@Transient
	private List<Utleiekontor> utleiekontorer;

	/**
	 * Konstruktør
	 * 
	 */
	public Selskap() {
		this(0, null, null, null);
	}

	/**
	 * Konstruktør
	 * 
	 * @param selskap_id
	 * @param firma_adresse
	 * @param telefonnummer
	 * @param utleiekontorer
	 */
	public Selskap(Integer selskap_id, Adresse firma_adresse, Integer telefonnummer,
			List<Utleiekontor> utleiekontorer) {
		super();
		this.selskap_id = selskap_id;
		this.firma_adresse = firma_adresse;
		this.telefonnummer = telefonnummer;
		this.utleiekontorer = utleiekontorer;
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

}
