package tests;

import controller.BandHelper;
import model.Band;

public class BandTester {
	static BandHelper bh = new BandHelper();

	public static void main(String[] args) {
		System.out.println("Hello");
		addBand();
		
	}
	
/*	Band bandToUpdate = dao.searchForBandById(tempId);
	bandToUpdate.setBandName(bandName);
	bandToUpdate.setBandLocation(bandLocation);
	bandToUpdate.setNumOfMembers(numOfMembers);
	bandToUpdate.setLevelBandId(levelBandId);
	bandToUpdate.setCostOfParticipation(numOfMembers, levelBandId);*/

	private static void addBand() {
		//Band addBand = new Band(36, "puppies", "New York", 1);
		Band addBand = new Band(75, "puppies", "Orlando", 3);
		//bh.insertBand(addBand);
		System.out.println(addBand.getCostOfParticipation());
		System.out.println(addBand.getNumOfMembers());
		System.out.println(addBand.getLevelBandId());
		System.out.println(addBand.getLevelOfBand());
	} 
}
