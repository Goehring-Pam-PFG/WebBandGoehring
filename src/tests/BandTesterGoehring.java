package tests;

import java.util.Scanner;

import controller.BandsParticipating;
import model.Band;
import model.MarchingBand;
import model.PepBand;

public class BandTesterGoehring {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Band twistedPipes = new Band(55, "Twisted Pipes", "Norwalk", 1);
		System.out.println(twistedPipes.bandDetails());
		System.out.println("Buses Needed: " + twistedPipes.getMinNumBusNeeded());

		//MarchingBand titans = new MarchingBand(61, "Titans", "New York", 2, true, true, "poms", 3);
		//System.out.println(titans.bandDetails());

		//PepBand bsquad = new PepBand(91, "B-Squad", "Ankeny", 3, "assembly", "Basketball game");
		//System.out.println(bsquad.bandDetails());

		BandsParticipating valentines = new BandsParticipating("Valentine's Day Program");
		//valentines.addToEvent(bsquad);
		//valentines.addToEvent(titans);
		valentines.addToEvent(twistedPipes);
		System.out.println(valentines.displayParticipants());

	}

}
