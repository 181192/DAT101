package no.hib.dat101.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utleiekontor", schema = "FYLLINNN")
public class Utleiekontor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kontornummer;

	@Column(name = "telefonnummer")
	private Integer telefonnummer;

	@Column(name = "adresse")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "selskap_id", referencedColumnName = "selskap")
	private Selskap selskap_id;

}
