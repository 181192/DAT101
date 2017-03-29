package no.hib.dat101.utsyn;

import java.util.Scanner;

import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.brikke.BrikkeFarge;

public class Tekstgrensesnitt implements StigespillUI {
	private Scanner tast;

	@Override
	public Integer lesAntallSpillere() {
		Integer antall = tast.nextInt();
		return antall;
	}

	@Override
	public String lesInnSpiller() {
		String navn = tast.nextLine();
		return navn;
	}

	@Override
	public BrikkeFarge lesInnBrikkeFarge() {
		Integer nr = tast.nextInt();
		return BrikkeFarge.finnBrikkeFarge(nr);
	}
	
	@Override
	public void infoOmSpiller(Spiller spiller) {
		System.out.println(spiller.toString());
	}
}
