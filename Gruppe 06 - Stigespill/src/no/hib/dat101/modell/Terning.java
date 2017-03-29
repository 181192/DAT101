package no.hib.dat101.modell;

/**
 * Klassen representerer en terning
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */

public class Terning {
	private Integer terning_id;
	private Integer verdi;

	/**
	 * Konstruktør til en terning
	 * 
	 * @param verdi
	 *            Verdi på terningen
	 */
	public Terning(Integer verdi) {
		this.verdi = verdi;
	}

	/**
	 * Triller terningen, og gir terningen en ny verdi
	 * 
	 * @return Verdien på terningen
	 */
	public int trill() {
		// TODO
		return 0;
	}

	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(Integer verdi) {
		this.verdi = verdi;
	}

	public Integer getTerning_id() {
		return terning_id;
	}

	public void setTerning_id(Integer terning_id) {
		this.terning_id = terning_id;
	}
}
