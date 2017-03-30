package no.hib.dat101.utsyn;

import java.util.Scanner;

import no.hib.dat101.modell.Spiller;
import no.hib.dat101.modell.brikke.BrikkeFarge;

public class Tekstgrensesnitt implements StigespillUI {
	private Scanner tast = new Scanner(System.in);

	@Override
	public Integer lesAntallSpillere() {
		System.out.print("Oppi antall spillere: ");
		return tast.nextInt();
	}

	@Override
	public String lesInnSpiller() {
		System.out.print("Oppgi navn p� spiller: ");
		return tast.next();
	}

	@Override
	public BrikkeFarge lesInnBrikkeFarge() {
		System.out.println("0 = RED, 1 = BLUE, 2 = GREEN, 3 = YELLOW");
		System.out.print("Oppgi fargekode: ");
		String farge = tast.next();
		BrikkeFarge brikke = BrikkeFarge.finnBrikkeFarge(farge);
		return brikke;
	}
	
	@Override
	public void infoOmSpiller(Spiller spiller) {
		System.out.println(spiller.toString());
	}
}
