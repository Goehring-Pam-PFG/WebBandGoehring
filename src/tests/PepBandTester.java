package tests;

import controller.PepBandHelper;
import model.PepBand;

public class PepBandTester {
	static PepBandHelper pbh = new PepBandHelper();
	
	public static void main(String[] args) {
		addPepBand();
	}
	
	private static void addPepBand() {
		PepBand addPepBand = new PepBand(38, "sharks", "Oregon", 2, 2);
		pbh.insertBand(addPepBand);
	} 
}
