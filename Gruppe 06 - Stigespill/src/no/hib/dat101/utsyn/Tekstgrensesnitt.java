package no.hib.dat101.utsyn;

import java.util.Scanner;

import no.hib.dat101.modell.Logg;
import no.hib.dat101.modell.Stigespill;
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
		System.out.println("0 = RED, 1 = BLUE, 2 = GREEN, 3 = YELLOW");
		System.out.print("Oppgi fargekode: ");
		int farge = tast.nextInt();
		BrikkeFarge brikke = BrikkeFarge.finnBrikkeFarge(farge);
		return brikke;
	}

	@Override
	public String infoOmTrekk(Logg logg) {
		return logg.toString();
	}

	@Override
	public String vinner(Stigespill stigespill) {
		return stigespill.getVinner().getNavn();
	}
	
	
}
