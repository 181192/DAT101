package no.hib.dat101.modell.brikke;

public enum BrikkeFarge {
	
	RED(0), BLUE(1), GREEN(2), YELLOW(3);
	
	private Integer nr;
	
	private BrikkeFarge(Integer nr) {
		this.nr = nr;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}
	
	public BrikkeFarge finnBrikkeFarge(Integer nr) {
		// TODO
		return null;
		
	}
}
