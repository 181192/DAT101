package no.hib.dat101.modell;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "utleiekontor", schema = "FYLLINNN")
public class Utleiekontor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "telefonnummer")
	private Integer telefonnummer;
	
	@Column(name = "gatenavn")
	private String gatenavn;
	
	@Column(name = "postnummer")
	private Integer postnummer;
	
	@Column(name = "poststed")
	private String poststed;
	
	@ManyToOne
	@JoinColumn(name = "selskap", referencedColumnName = "selskap")
	private Selskap selskap;
	
	@OneToMany(mappedBy = "kontor")
    private List<Bil> biler;
	
	
}
