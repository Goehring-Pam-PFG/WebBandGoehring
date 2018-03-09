package tests;

import java.util.List;
import java.util.Scanner;

import controller.CompetitionHelper;
import model.Competition;


public class CompetitionTester {
	static Scanner in = new Scanner(System.in);
	static CompetitionHelper ch = new CompetitionHelper();
	
	public static void main(String[] args) {
		//addCompetition();
		viewCompetitionRoster();
	}
	
	
	private static void addCompetition() {
		Competition addCompetition = new Competition(1, 45);
		ch.insertCompetition(addCompetition);
	}
	
	private static void viewCompetitionRoster() {
		List<Competition> allItems = ch.showAllCompetition();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		for (Competition roster : allItems) {
			System.out.println(roster.toString());
		}
	}

}
