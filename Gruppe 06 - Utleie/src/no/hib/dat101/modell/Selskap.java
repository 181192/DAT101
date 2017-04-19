package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "selskap", schema = "FYLLINN!!")
public class Selskap {
	@Id
	private String selskap;
	
	@Column(name = "telefonnummer")
	private Integer telefonnummer;
	
	@Column(name = "gatenavn")
	private String gatenavn;
	
	@Column(name = "postnummer")
	private Integer postnummer;
	
	@Column(name = "poststed")
	private String poststed;
	
	@OneToMany(mappedBy = "selskap", cascade = CascadeType.ALL)
	private List<Utleiekontor> kontorer;
	
}
