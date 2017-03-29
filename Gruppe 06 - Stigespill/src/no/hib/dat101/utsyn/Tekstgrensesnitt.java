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
		System.out.print("Oppgi navn på spiller: ");
		return tast.next();
	}

	@Override
	public BrikkeFarge lesInnBrikkeFarge() {
		System.out.println("1 = RED, 2 = BLUE, 3 = GREEN, 4 = YELLOW");
		System.out.print("Oppgi fargekode: ");
		Integer nr = tast.nextInt();
		return BrikkeFarge.finnBrikkeFarge(nr);
	}
	
	@Override
	public void infoOmSpiller(Spiller spiller) {
		System.out.println(spiller.toString());
	}
}
