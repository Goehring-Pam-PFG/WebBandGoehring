package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue(value = "pep")
@Table(name = "pep_band")
public class PepBand extends Band {
	@Column(name = "event_id")
	private int eventId;
	@Transient
	private String event;
	@Transient
	private String eventName;
	@Column(name = "playing_position")
	private String playingPosition;

	public PepBand() {
		super();
	}
	

	public PepBand(int bandId) {
		super(bandId);
	}



	public PepBand(int numOfMembers, String bandName, String bandLocation, int levelBandId, int eventId) {
		super(numOfMembers, bandName, bandLocation, levelBandId);
		this.eventId = eventId;
		setPlayingPosition(bandLocation);
		setNumOfMembers(numOfMembers);
	}

	/*
	 * public PepBand(int numOfMembers, String bandName, String bandLocation, int
	 * levelBandId, String event, String eventName) { super(numOfMembers, bandName,
	 * bandLocation, levelBandId); setEvent(eventName); this.eventName = eventName;
	 * }
	 */

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setPlayingPosition(String playingPosition) {
		this.playingPosition = playingPosition;
		if (this.eventId <= 4) {
			this.playingPosition = "sitting";
		} else {
			this.playingPosition = "standing";
		}
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlayingPosition() {
		return playingPosition;
	}

	@Override
	public String bandDetails() {
		return super.bandDetails() + "\nEvent: " + this.event + "\nEvent Name: " + this.eventName
				+ "\nPlaying Position: " + this.playingPosition;
	}
	
	@Override
	public String returnBandDetails() {
		return super.returnBandDetails() + "     " + String.format("%-10s", this.getPlayingPosition());
	}

}
