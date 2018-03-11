package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "band_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue (value = "basic")
@Table(name = "band")

public class Band {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "band_id")
	protected int bandId;
	@Column(name = "num_of_members")
	private int numOfMembers;
	@Column(name = "name_of_band")
	private String bandName;
	@Column(name = "location_of_band")
	private String bandLocation;
	@Column(name = "cost_of_participation")
	protected double costOfParticipation;
	@Column(name = "level_of_band")
	private int levelBandId;
	//differentiates whether the band is basic, pep or marching
	@Column(name = "band_type")
	private String bandType;
	
	@Transient
	private String levelOfBand;
	
	@Transient
	private double quantityDiscount;
	@Transient
	protected int minNumBusNeeded;
	@Transient
	final double ELEMENTARY_COST = 25.00;
	@Transient
	final double JUNIOR_HIGH_COST = 50.00;
	@Transient
	final double HIGH_SCHOOL_COST = 100.00;
	@Transient
	final int ELEMENTARY_LEVEL_ID = 1;
	@Transient
	final int JUNIOR_HIGH_LEVEL_ID = 2;
	@Transient
	final int HIGH_SCHOOL_LEVEL_ID = 3;

	@Transient
	DecimalFormat df = new DecimalFormat("$##0.00");

	public Band() {
		super();
	}

	public Band(int bandId) {
		super();
		this.bandId = bandId;
	}

	public Band(int numOfMembers, String bandName, String bandLocation, double costOfParticipation, int levelBandId) {
		super();
		this.numOfMembers = numOfMembers;
		this.bandName = bandName;
		this.bandLocation = bandLocation;
		this.levelBandId = levelBandId;
		this.costOfParticipation = calcCostOfParticipation(numOfMembers,levelBandId);
	}

	public Band(int numOfMembers, String bandName, String bandLocation) {
		super();
		this.numOfMembers = numOfMembers;
		this.bandName = bandName;
		this.bandLocation = bandLocation;
	} 

	public Band(int numOfMembers, String bandName, String bandLocation, int levelBandId) {
		super();
		setNumOfMembers(numOfMembers);
		this.bandName = bandName;
		setBandLocation(bandLocation);
		setLevelBandId(levelBandId);
		this.costOfParticipation = calcCostOfParticipation(numOfMembers,levelBandId);
	}

	public int getMinNumBusNeeded() {
		return minNumBusNeeded;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}
	
	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	// assigns discount for qty of members
	// assigns # of buses needed for event
//	public void setNumOfMembers(int numOfMembers) {
//		final int MIN_NUM_MEMBERS_QTY_DISCOUNT = 25;
//		final int DISCOUNT_100 = 100;
//		final double DISCOUNT_HIGH = 15.00;
//		final double DISCOUNT_LOW = 5.50;
//		final int MAX_MEMBERS_PER_BUS = 30;
//
//		this.numOfMembers = numOfMembers;
//
//		if (this.numOfMembers < MIN_NUM_MEMBERS_QTY_DISCOUNT) {
//			quantityDiscount = 0;
//		} else if (this.numOfMembers >= DISCOUNT_100) {
//			quantityDiscount = DISCOUNT_HIGH;
//		} else {
//			quantityDiscount = DISCOUNT_LOW;
//		}
//
//		if (this.numOfMembers > MAX_MEMBERS_PER_BUS) {
//			minNumBusNeeded = (numOfMembers + MAX_MEMBERS_PER_BUS - 1) / MAX_MEMBERS_PER_BUS;
//		} else {
//			minNumBusNeeded = 1;
//		}
//	}

	/*
	 * Method assigns discount for number of members
	 * Also sets the discount per level of band
	 */
	private double calcCostOfParticipation(int numOfMembers, int levelBandId) {
		System.out.println("I'm in the method");
		final int MIN_NUM_MEMBERS_QTY_DISCOUNT = 25;
		final int DISCOUNT_100 = 100;
		final double DISCOUNT_HIGH = 15.00;
		final double DISCOUNT_LOW = 5.50;
		final int MAX_MEMBERS_PER_BUS = 30;
		
		System.out.println("members " + numOfMembers);
		
			//calculates discounts based on member count
			if (this.numOfMembers < MIN_NUM_MEMBERS_QTY_DISCOUNT) {
				quantityDiscount = 0;
			} else if (this.numOfMembers > DISCOUNT_100) {
				quantityDiscount =  DISCOUNT_HIGH;
			} else {
				quantityDiscount = DISCOUNT_LOW;
			}
			
			//calculates number of buses needed
			if (this.numOfMembers > MAX_MEMBERS_PER_BUS) {
				minNumBusNeeded = (numOfMembers + MAX_MEMBERS_PER_BUS - 1) / MAX_MEMBERS_PER_BUS;
			} else {
				minNumBusNeeded = 1;
			}
			
			//calculates cost of participation
			Double totalCostOfParticipation;
			if (this.levelBandId == ELEMENTARY_LEVEL_ID) {
				totalCostOfParticipation = 0.0;
			} else if (this.levelBandId == JUNIOR_HIGH_LEVEL_ID) {
				totalCostOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
			} else {
				totalCostOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
			}
			return totalCostOfParticipation;
	}
	
	public int getLevelBandId() {
		return levelBandId;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getBandLocation() {
		return bandLocation;
	}

	public void setBandLocation(String bandLocation) {
		this.bandLocation = bandLocation;
	}

	public double getCostOfParticipation() {
		return costOfParticipation;
	}
	
	public void setCostOfParticipation(int numOfMembers, int levelBandId) {
		this.costOfParticipation = calcCostOfParticipation(numOfMembers,levelBandId);
	}

//	public String getBandLevel() {
//		return bandLevel;
//	}
	

	public int getBandId() {
		return bandId;
	}

	/*
	 * method sets cost of participation based on band level minus any discounts
	 * provided
	 */
	/*public void setBandLevel(String bandLevel) {
		this.bandLevel = bandLevel;
		if (this.bandLevel.equalsIgnoreCase("HS")) {
			this.costOfParticipation = HIGH_SCHOOL_COST - quantityDiscount;
		} else {
			this.costOfParticipation = JUNIOR_HIGH_COST - quantityDiscount;
		}
	}*/

	public void setLevelBandId(int levelBandId) {
		this.levelBandId = levelBandId;
	}
	
	public String getLevelOfBand() {
		String levelOfBandDesc;
		if (this.levelBandId == ELEMENTARY_LEVEL_ID) {
			levelOfBandDesc = "Elementary";
		} else if (this.levelBandId == JUNIOR_HIGH_LEVEL_ID) {
			levelOfBandDesc = "Junior School";
		} else {
			levelOfBandDesc = "High School";
		}
		return levelOfBandDesc;
		
	}
	
	public void setLevelOfBand(String levelOfBand) {
		this.levelOfBand = levelOfBand;
	}

	@Override
	public String toString() {
		return "Band [numOfMembers=" + numOfMembers + ", bandName=" + bandName + ", bandLocation=" + bandLocation
				+ ", costOfParticipation=" + this.costOfParticipation + ", levelBandId=" + levelBandId + "]";
	}

	public String bandDetails() {
		return "------------------------------------\nBand Name: " + this.bandName + "\nCategory: "
				+ this.getLevelOfBand() + "\nBand Location: " + this.bandLocation + "\n# of Members: "
				+ this.numOfMembers + "\nParticipation Cost: " + df.format(costOfParticipation);
	}
	
	public String returnBandDetails () {
		String bandLevelDescription = "";
		if (levelBandId == 1) {
			bandLevelDescription = "Elementary";
		} else if (levelBandId == 2) {
			bandLevelDescription = "Junior High";
		} else if (levelBandId == 3) {
			bandLevelDescription = "High School";
		}
		return String.format("%-5s %-15s %-15s %10s %15s", bandId, bandName.toUpperCase(), bandLocation.toUpperCase(), getNumOfMembers(), bandLevelDescription);
	}


//	public String show() {
//		String displayLevel = "";
//		if (bandLevel.equalsIgnoreCase("HS")) {
//			displayLevel = "HIGH SCHOOL BAND";
//		} else if (bandLevel.equalsIgnoreCase("JH")) {
//			displayLevel = "JUNIOR HIGH SCHOOL BAND";
//		}
//		return String.format("%-15s %-15s %-15s", "BAND NAME", "LOCATION", "BAND LEVEL") + "\n"
//				+ String.format("%-15s %-15s %-15s", bandName, bandLocation, displayLevel);
//	}

}
