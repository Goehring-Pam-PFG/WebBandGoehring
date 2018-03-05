package tests;

import java.util.List;
import java.util.Scanner;

import controller.MarchingBandHelper;
import model.MarchingBand;

public class MarchingBandTester {
	static Scanner in = new Scanner(System.in);
	static MarchingBandHelper mbh = new MarchingBandHelper();
	
	public static void main(String[] args) {
		addMarchingBand();
		deleteMarchingBand();
		viewMarchingBands();
	}

	private static void addMarchingBand() {
		MarchingBand addMarchingBand = new MarchingBand(102, "apples", "South Carolina", 2, true, true, "signs");
		mbh.insertBand(addMarchingBand);
	} 
	
	private static void deleteMarchingBand() {
		MarchingBand toDelete = new MarchingBand(50);
		mbh.deleteMarchingBand(toDelete);
	}
	
	private static void viewMarchingBands() {
		List<MarchingBand> allItems = mbh.showAllMarchingBands();
		System.out.println(String.format("%-5s %-15s %-15s %10s %10s %10s %10s %10s", "ID", "BAND NAME", "BAND LOCATION", "# MEMBERS", "COLOR GUARD", "PROPS", "# BUSES", "PARTICIPATION COST"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (MarchingBand marchingbands : allItems) {
			System.out.println(marchingbands.returnBandDetails());
		}
	}
}
