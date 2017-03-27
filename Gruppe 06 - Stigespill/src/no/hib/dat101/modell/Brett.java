package no.hib.dat101.modell;

import no.hib.dat101.modell.rute.Rute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "brett", schema = "kristoffer_stigespill")
public class Brett {
	private final Integer ANTALL_RUTER = 100;
	private Rute[] ruteTab;
	
	
	public Brett() {
		ruteTab = new Rute[ANTALL_RUTER];
	}
	

	public Rute finnRute(Rute startRute, Integer distanse) {
		// TODO
		return null;
	}
	
	public void nyPlass(Rute rute) {
		// TODO
	}
}
