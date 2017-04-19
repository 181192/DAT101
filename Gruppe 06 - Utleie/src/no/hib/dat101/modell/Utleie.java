package no.hib.dat101.modell;

import javax.persistence.*;


@Entity
@Table(name = "utleie", schema = "FYLLINNN!!!")
public class Utleie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "kredittkort")
	private Integer kredittkort;
	
	@OneToMany
	@JoinColumn(name = "bil", referencedColumnName = "regnr")
	private Bil regnr;
	
	
}
