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
	private Kunde kundenummer;
	private Utleiekontor utleiested;
	private Utleiekontor retursted;
	private Time klokke_forventet;
	private Date dato_forventet;
	private Bil bil;
	private Integer returgebyr;
	
	

	

}
