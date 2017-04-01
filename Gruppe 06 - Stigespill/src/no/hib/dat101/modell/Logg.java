package no.hib.dat101.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import no.hib.dat101.modell.rute.Rute;

@Entity
@Table(name = "logg", schema = "kristoffer_stigespill")
public class Logg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer logg_id;

	@JoinColumn(name = "spiller", referencedColumnName = "spiller_id")
	private Spiller spiller;

	@JoinColumn(name = "rute_fra", referencedColumnName = "rute_nr")
	private Rute rute_fra;

	@JoinColumn(name = "rute_til", referencedColumnName = "rute_nr")
	private Rute rute_til;

	/**
	 * Tom konstrukt�r
	 */
	public Logg() {

	}

	public Integer getLogg_id() {
		return logg_id;
	}

	public void setLogg_id(Integer logg_id) {
		this.logg_id = logg_id;
	}

	public Spiller getSpiller() {
		return spiller;
	}

	public void setSpiller(Spiller spiller) {
		this.spiller = spiller;
	}

	public Rute getRute_fra() {
		return rute_fra;
	}

	public void setRute_fra(Rute rute_fra) {
		this.rute_fra = rute_fra;
	}

	public Rute getRute_til() {
		return rute_til;
	}

	public void setRute_til(Rute rute_til) {
		this.rute_til = rute_til;
	}

	@Override
	public String toString() {
		Integer fra = rute_fra.getRute_nr();
		Integer til = rute_til.getRute_nr();
		return "spiller: " + spiller.getNavn() + "\t, rute_fra: " + fra + "\t, rute_til: " + til
				+ "\t, sum = " + (til - fra);
	}
	
	

}
