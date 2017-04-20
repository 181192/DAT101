package no.hib.dat101.modell;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "utleie", schema = "FYLLINNN!!!")
public class Utleie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer utleie_id;
	
	private Time klokke_forventet;
	private Date dato_forventet;
	
	@Column(name = "kredittkort")
	private Integer kredittkort;
	
	private Reservasjon reservasjon_id;
	
}
