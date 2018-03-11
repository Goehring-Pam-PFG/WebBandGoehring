package controller;

import java.util.ArrayList;

import model.Band;

public class BandsParticipating {
	private String eventName;
	private ArrayList<Band> bandList = new ArrayList<Band>();

	public BandsParticipating(String eventName) {
		super();
		this.eventName = eventName;
		bandList = new ArrayList<Band>();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public ArrayList<Band> getBandList() {
		return bandList;
	}

	public void setBandList(ArrayList<Band> bandList) {
		this.bandList = bandList;
	}

	// assigning bands to the event list
	public void addToEvent(Band newBand) {
		bandList.add(newBand);
	}

	/*public String displayParticipants() {
		String participants = eventName.toUpperCase() + "\n";

		for (Band band : bandList) {
			participants = participants + band.show() + "\n";
		}

		participants = participants + "\n";

		return "-----------------------------------------------------\n" + participants;
	}*/
}
