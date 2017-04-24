package no.hib.dat101.modell;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import no.hib.dat101.ui.SelskapUI;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity
@Table(name = "retur", schema = "bilutleie")
public class Retur extends Reservasjon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer retur_id;
	@Column(name = "klokke_retur")
	private Time klokke_retur;
	@Column(name = "dato_retur")
	private Date dato_retur;
	@Column(name = "km_stand_retur")
	private Integer km_stand_retur;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "utleie_id", referencedColumnName = "utleie_id")
	private Utleie utleie_id;

	@Transient
	private SelskapUI ui;

	/**
	 * Konstruktør
	 * 
	 */
	public Retur() {
		this(0, null, null, 0, null);
	}

	/**
	 * Konstruktør
	 * 
	 * @param reservasjon_id
	 * @param klokke_retur
	 * @param dato_retur
	 * @param km_stand_retur
	 * @param utleie_id
	 */
	public Retur(Integer retur_id, Time klokke_retur, Date dato_retur, Integer km_stand_retur, Utleie utleie_id) {
		super();
		this.retur_id = retur_id;
		this.klokke_retur = klokke_retur;
		this.dato_retur = dato_retur;
		this.km_stand_retur = km_stand_retur;
		this.utleie_id = utleie_id;
	}

	public void info() {
		setKlokke_retur(ui.lesInnKlokkeslett());
		setDato_retur(ui.lesInnDato());
		oppdaterKmBil();
		oppdaterUtleiekontor();
		ui.skrivFaktura(lagFaktura());
	}

	/**
	 * Oppdaterer kilometer stand på bilen når bilen blir returnert
	 */
	private void oppdaterKmBil() {
		km_stand_retur = ui.lesInnKm_stand();
		super.getBil().setKm_stand(km_stand_retur);
	}

	/**
	 * Faktura
	 * 
	 * @return Representasjon av en faktura for Retur
	 */
	private ArrayList<String> lagFaktura() {
		ArrayList<String> faktura = new ArrayList<String>();
		faktura.add("Reservasjon: " + super.getReservasjon_id().toString());
		faktura.add("Kundenummer: " + super.getKundenummer().getKundenummer().toString());
		faktura.add("Dato for utlån: " + super.getDato_resv().toString());
		faktura.add("Utlånskontor: " + super.getUtleiested().getAdresse().getGateadresse());
		faktura.add("Dato for retur: " + this.getDato_retur().toString());
		faktura.add("Innleveringssted: " + super.getRetursted().getAdresse().getGateadresse());
		faktura.add("Pris: "
				+ (super.getBil().getKategori().getDagspris() * (this.getDato_retur().getTime() / (1000 * 60 * 60 * 24)
						- this.getDato_resv().getTime() / (1000 * 60 * 60 * 24))));
		return faktura;
	}

	/**
	 * Hvis utleiekontoret er forskjellig fra returkontoret, oppdatert bilen med
	 * retur uteleiekontoret
	 */
	private void oppdaterUtleiekontor() {
		if (super.getUtleiested().compareTo(super.getRetursted()) != 0) {
			super.getBil().setKontornummer(super.getRetursted());
		}
	}

	/**
	 * @return String representasjon av Retur
	 */
	@Override
	public String toString() {
		return "retur_id: " + retur_id + ", klokke_retur: " + klokke_retur + ", dato_retur: " + dato_retur
				+ ", km_stand_retur: " + km_stand_retur + ", utleie_id: " + utleie_id;
	}

	/**
	 * @return henter reservasjon_id
	 */
	public Integer getRetur_id() {
		return retur_id;
	}

	/**
	 * @param reservasjon_id
	 *            setter reservasjon_id
	 */
	public void setRetur_id(Integer retur_id) {
		this.retur_id = retur_id;
	}

	/**
	 * @return henter klokke_retur
	 */
	public Time getKlokke_retur() {
		return klokke_retur;
	}

	/**
	 * @param klokke_retur
	 *            setter klokke_retur
	 */
	public void setKlokke_retur(Time klokke_retur) {
		this.klokke_retur = klokke_retur;
	}

	/**
	 * @return henter dato_retur
	 */
	public Date getDato_retur() {
		return dato_retur;
	}

	/**
	 * @param dato_retur
	 *            setter dato_retur
	 */
	public void setDato_retur(Date dato_retur) {
		this.dato_retur = dato_retur;
	}

	/**
	 * @return henter km_stand_retur
	 */
	public Integer getKm_stand_retur() {
		return km_stand_retur;
	}

	/**
	 * @param km_stand_retur
	 *            setter km_stand_retur
	 */
	public void setKm_stand_retur(Integer km_stand_retur) {
		this.km_stand_retur = km_stand_retur;
	}

	/**
	 * @return henter utleie_id
	 */
	public Utleie getUtleie_id() {
		return utleie_id;
	}

	/**
	 * @param utleie_id
	 *            setter utleie_id
	 */
	public void setUtleie_id(Utleie utleie_id) {
		this.utleie_id = utleie_id;
	}

}
