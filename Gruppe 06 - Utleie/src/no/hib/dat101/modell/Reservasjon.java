package no.hib.dat101.modell;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Reservasjon {
	private Integer reservasjon_id;
	private Time klokkeslett_resv;
	private Date dato_resv;
	private Integer antall_dager;
	private Kunde kundenummer;
	private Utleiekontor utleiested;
	private Utleiekontor retursted;
	private Bil bil;
	private Integer returgebyr;

	/**
	 * Konstruktør
	 * 
	 */
	public Reservasjon() {
		this(0, null, null, 0, null, null, null, null, 0);
	}

	/**
	 * Konstruktør
	 * 
	 * @param reservasjon_id
	 * @param klokkeslett_resv
	 * @param dato_resv
	 * @param antall_dager
	 * @param kundenummer
	 * @param utleiested
	 * @param retursted
	 * @param bil
	 * @param returgebyr
	 */
	public Reservasjon(Integer reservasjon_id, Time klokkeslett_resv, Date dato_resv, Integer antall_dager,
			Kunde kundenummer, Utleiekontor utleiested, Utleiekontor retursted, Bil bil, Integer returgebyr) {
		super();
		this.reservasjon_id = reservasjon_id;
		this.klokkeslett_resv = klokkeslett_resv;
		this.dato_resv = dato_resv;
		this.antall_dager = antall_dager;
		this.kundenummer = kundenummer;
		this.utleiested = utleiested;
		this.retursted = retursted;
		this.bil = bil;
		this.returgebyr = returgebyr;
	}

	/**
	 * @return henter reservasjon_id
	 */
	public Integer getReservasjon_id() {
		return reservasjon_id;
	}

	/**
	 * @param reservasjon_id
	 *            setter reservasjon_id
	 */
	public void setReservasjon_id(Integer reservasjon_id) {
		this.reservasjon_id = reservasjon_id;
	}

	/**
	 * @return henter klokkeslett_resv
	 */
	public Time getKlokkeslett_resv() {
		return klokkeslett_resv;
	}

	/**
	 * @param klokkeslett_resv
	 *            setter klokkeslett_resv
	 */
	public void setKlokkeslett_resv(Time klokkeslett_resv) {
		this.klokkeslett_resv = klokkeslett_resv;
	}

	/**
	 * @return henter dato_resv
	 */
	public Date getDato_resv() {
		return dato_resv;
	}

	/**
	 * @param dato_resv
	 *            setter dato_resv
	 */
	public void setDato_resv(Date dato_resv) {
		this.dato_resv = dato_resv;
	}

	/**
	 * @return henter antall_dager
	 */
	public Integer getAntall_dager() {
		return antall_dager;
	}

	/**
	 * @param antall_dager
	 *            setter antall_dager
	 */
	public void setAntall_dager(Integer antall_dager) {
		this.antall_dager = antall_dager;
	}

	/**
	 * @return henter kundenummer
	 */
	public Kunde getKundenummer() {
		return kundenummer;
	}

	/**
	 * @param kundenummer
	 *            setter kundenummer
	 */
	public void setKundenummer(Kunde kundenummer) {
		this.kundenummer = kundenummer;
	}

	/**
	 * @return henter utleiested
	 */
	public Utleiekontor getUtleiested() {
		return utleiested;
	}

	/**
	 * @param utleiested
	 *            setter utleiested
	 */
	public void setUtleiested(Utleiekontor utleiested) {
		this.utleiested = utleiested;
	}

	/**
	 * @return henter retursted
	 */
	public Utleiekontor getRetursted() {
		return retursted;
	}

	/**
	 * @param retursted
	 *            setter retursted
	 */
	public void setRetursted(Utleiekontor retursted) {
		this.retursted = retursted;
	}

	/**
	 * @return henter bil
	 */
	public Bil getBil() {
		return bil;
	}

	/**
	 * @param bil
	 *            setter bil
	 */
	public void setBil(Bil bil) {
		this.bil = bil;
	}

	/**
	 * @return henter returgebyr
	 */
	public Integer getReturgebyr() {
		return returgebyr;
	}

	/**
	 * @param returgebyr
	 *            setter returgebyr
	 */
	public void setReturgebyr(Integer returgebyr) {
		this.returgebyr = returgebyr;
	}

}
