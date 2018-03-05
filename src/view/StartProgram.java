package view;

import java.util.List;
import java.util.Scanner;

import controller.BandHelper;
import controller.MarchingBandHelper;
import controller.PepBandHelper;
import model.Band;
//import controller.BandsParticipating;
//import model.Band;
import model.MarchingBand;
import model.PepBand;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static BandHelper bh = new BandHelper();
	static MarchingBandHelper mbh = new MarchingBandHelper();
	static PepBandHelper pbh = new PepBandHelper();

	private static void addABand() {
		System.out.print("Enter name of your band: ");
		String bandName = in.nextLine();
		System.out.print("Where is your band located: ");
		String bandLocation = in.nextLine();
		System.out.print("How many members in your band: ");
		int numOfMembers = in.nextInt();
		System.out.println(bandLocation);
		System.out.print("What is the level of your band? 1 for Elementary, 2 for Junior High 3 for High School: ");
		int levelBandId = in.nextInt();

		Band addBand = new Band(numOfMembers, bandName, bandLocation, levelBandId);
		bh.insertBand(addBand);
		System.out.println("You have successfully entered " + addBand.getBandName());
	}

	private static void addMarchingBand() {
		System.out.print("Enter name of your band: ");
		String bandName = in.nextLine();
		System.out.print("Where is your band located: ");
		String bandLocation = in.nextLine();
		System.out.print("How many members in your band: ");
		int numOfMembers = in.nextInt();
		String props = "no props";
		System.out.print("Does your band use props: True or False ");
		boolean hasProps = in.nextBoolean();
		if (hasProps) {
			System.out.print("Enter types of props: ");
			props = in.next();
		}
		System.out.print("What is the level of your band? 1 for Elementary, 2 for Junior High 3 for High School: ");
		int levelBandId = in.nextInt();
		System.out.print("Does your band have a color guard? True or False ");
		boolean hasColorGuard = in.nextBoolean();
		MarchingBand addMarchingBand = new MarchingBand(numOfMembers, bandName, bandLocation, levelBandId, hasProps,
				hasColorGuard, props);
		mbh.insertBand(addMarchingBand);
		System.out.println(String.format("%-5s %-15s %-15s %10s %10s %10s %10s %10s", "ID", "BAND NAME", "BAND LOCATION", "# MEMBERS", "COLOR GUARD", "PROPS", "# BUSES", "PARTICIPATION COST"));
		System.out.println(addMarchingBand.returnBandDetails());
	}
	
	private static void addPepBand() {
		System.out.print("Enter name of your band: ");
		String bandName = in.nextLine();
		System.out.print("Where is your band located: ");
		String bandLocation = in.nextLine();
		System.out.print("How many members in your band: ");
		int numOfMembers = in.nextInt();
		System.out.print("What is the level of your band? 1 for Elementary, 2 for Junior High 3 for High School: ");
		int levelBandId = in.nextInt();
		System.out.print("Is this a sporting or an assembly event? 1 for Sporting, 2 for Assembly: ");
		int eventId = in.nextInt();
		PepBand addPepBand = new PepBand(numOfMembers, bandName, bandLocation, levelBandId, eventId);
		pbh.insertBand(addPepBand);
		System.out.println(String.format("%-5s %-15s %-15s %10s %10s", "ID", "BAND NAME", "BAND LOCATION", "# MEMBERS", "POSITION"));
		System.out.println(addPepBand.returnBandDetails());
	}

	private static void deleteBand() {
		viewBands();
		System.out.print("Enter id of band to delete: ");
		int id = in.nextInt();
		Band toDelete = new Band(id);
		bh.deleteBand(toDelete);
	}
	
	private static void deleteMarchingBand() {
		viewMarchingBands();
		System.out.println("Enter id of marching band to delete: ");
		int id = in.nextInt();
		MarchingBand toDelete = new MarchingBand(id);
		mbh.deleteMarchingBand(toDelete);
	}
	
	private static void deletePepBand() {
		viewPepBands();
		System.out.println("Enter id of pep band to delete: ");
		int id = in.nextInt();
		PepBand toDelete = new PepBand(id);
		pbh.deletePepBand(toDelete);
	}
	

	private static void viewBands() {
		List<Band> allItems = bh.showAllBands();
		System.out.println(String.format("%-5s %-15s %-15s %10s %15s", "ID", "BAND NAME", "BAND LOCATION", "# of MEMBERS", "BAND LEVEL"));
		System.out.println("------------------------------------------------------------------------");
		for (Band bands : allItems) {
			System.out.println(bands.returnBandDetails());
		}
	}
	
	private static void viewMarchingBands() {
		List<MarchingBand> allItems = mbh.showAllMarchingBands();
		System.out.println(String.format("%-5s %-15s %-15s %10s %10s %10s %10s %10s", "ID", "BAND NAME", "BAND LOCATION", "# MEMBERS", "COLOR GUARD", "PROPS", "# BUSES", "PARTICIPATION COST"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (MarchingBand marchingbands : allItems) {
			System.out.println(marchingbands.returnBandDetails());
		}
	}
	
	private static void viewPepBands() {
		List<PepBand> allItems = pbh.showAllPepBands();
		System.out.println(String.format("%-5s %-15s %-15s %10s", "ID", "BAND NAME", "BAND LOCATION", "# MEMBERS"));
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (PepBand pepbands : allItems) {
			System.out.println(pepbands.returnBandDetails());
		}
	}

	private static void editBand() {
		viewBands();
		System.out.print("Which ID to edit: ");
		int idToEdit = in.nextInt();
		Band toEdit = bh.searchForBandById(idToEdit);
		System.out.println(toEdit.returnBandDetails());
		System.out.println("Enter which field you'd like to update: ");
		System.out.println("1 : Update Band Name");
		System.out.println("2 : Update Band Location");
		System.out.println("3 : Update # of Members");
		int update = in.nextInt();
		in.nextLine();

		if (update == 1) {
			System.out.print("Enter updated band name: ");
			String newBandName = in.nextLine();
			toEdit.setBandName(newBandName);
		} else if (update == 2) {
			System.out.print("Enter updated band location: ");
			String newBandLocation = in.nextLine();
			toEdit.setBandLocation(newBandLocation);
			;
		} else if (update == 3) {
			System.out.print("Enter updated # of members: ");
			int newBandCount = in.nextInt();
			toEdit.setNumOfMembers(newBandCount);
		}
		bh.updateBand(toEdit);
		viewBands();

	}

	
	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to Band World Expo! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*******ADD A BAND*******");
			System.out.println("*  1 -- Add Band");
			System.out.println("*  2 -- Add Marching Band");
			System.out.println("*  3 -- Add Pep Band");
			System.out.println("*******DELETE A BAND*******");
			System.out.println("*  4 -- Delete Band");
			System.out.println("*  5 -- Delete Marching Band");
			System.out.println("*  6 -- Delete Pep Band");
			System.out.println("*******VIEW BANDS*******");
			System.out.println("*  7 -- View Bands");
			System.out.println("*  8 -- View Marching bands");
			System.out.println("*  9 -- View Pep bands");
			System.out.println("*******EDIT BANDS*******");
			System.out.println("*  10 -- Edit a band");
			System.out.println("*  11 -- Exit the band expo program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addABand();
			} else if (selection == 2) {
				addMarchingBand();
			} else if (selection == 3) {
				addPepBand();
			} else if (selection == 4) {
				deleteBand();
			} else if (selection == 5) {
				deleteMarchingBand();
			} else if (selection == 6) {
				deletePepBand();
			} else if (selection == 7) {
				viewBands();
			} else if (selection == 8) {
				viewMarchingBands();
			} else if (selection == 9) {
				viewPepBands();
			} else if (selection == 10) {
				editBand();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}

	}
}
