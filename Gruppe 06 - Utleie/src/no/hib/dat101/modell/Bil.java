package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bil", schema = "FYLLINNN")
public class Bil {
	@Id
	private String regnr;
	
	@Column(name = "merke")
	private String merke;
	
	@Column(name = "modell")
	private String modell;
	
	@Column(name = "farge")
	private String farge;
	
	@Column(name = "bilkategori")
	private Character bilkategori;
	
	@ManyToOne
	@JoinColumn(name = "kontor", referencedColumnName = "id")
	private Utleiekontor utleiekontor;
	
//	@ManyToOne(mappedBy = "bil")
	private List<Utleie> utleie;
}
