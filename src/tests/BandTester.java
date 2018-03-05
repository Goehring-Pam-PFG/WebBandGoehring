package tests;

import controller.BandHelper;
import model.Band;

public class BandTester {
	static BandHelper bh = new BandHelper();

	public static void main(String[] args) {
		addBand();
		
	}

	private static void addBand() {
		Band addBand = new Band(36, "puppies", "New York", 1);
		bh.insertBand(addBand);
	} 
}
