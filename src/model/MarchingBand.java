package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "band_id", referencedColumnName = "band_id")
@DiscriminatorValue (value = "marching")
@Table(name = "marching_band")


public class MarchingBand extends Band {
	public MarchingBand() {
		super();
	}

	@Transient
	private boolean hasProps;
	@Column(name = "has_color_guard")
	private boolean hasColorGuard;
	@Column(name = "types_of_props")
	private String typesOfProps;
	@Column(name = "number_of_buses")
	private int numOfBuses;

	public MarchingBand(int numOfMembers, String bandName, String bandLocation, int levelBandId, boolean hasProps,
			boolean hasColorGuard, String typesOfProps) {
		super(numOfMembers, bandName, bandLocation, levelBandId);
		setHasProps(hasProps);
		setHasColorGuard(hasColorGuard);
		this.typesOfProps = typesOfProps;
		this.numOfBuses = getMinNumBusNeeded() + numOfBuses;
	}

	public MarchingBand(boolean hasProps, boolean hasColorGuard, String typesOfProps) {
		super();
		setHasProps(hasProps);
		setHasColorGuard(hasColorGuard);
		this.typesOfProps = typesOfProps;
		numOfBuses = getMinNumBusNeeded() + numOfBuses;
	}
	
	

	public MarchingBand(int bandId) {
		super(bandId);
	}

	public boolean isHasProps() {
		return hasProps;
	}

	/*
	 * increases the number of buses if the band has props included with them
	 */
	public void setHasProps(boolean hasProps) {
		this.hasProps = hasProps;
		if (hasProps) {
			this.numOfBuses = numOfBuses + 1;
		}
	}

	public boolean isHasColorGuard() {
		return hasColorGuard;
	}

	/*
	 * increases the number of buses if the band has color guard included with them
	 */
	public void setHasColorGuard(boolean hasColorGuard) {
		this.hasColorGuard = hasColorGuard;
		if (hasColorGuard) {
			this.numOfBuses = numOfBuses + 1;
		}
	}

	public String getTypesOfProps() {
		return typesOfProps;
	}

	public void setTypesOfProps(String typesOfProps) {
		this.typesOfProps = typesOfProps;
	}

	public int getNumOfBuses() {
		return numOfBuses;
	}

	@Override
	public String bandDetails() {
		return super.bandDetails() + "\nBus Count: " + this.numOfBuses + "\nColor Guard: " + this.hasColorGuard
				+ "\nProps: " + this.hasProps;
	}

	@Override
	public String returnBandDetails() {
		String colorGuard = "";
		if (this.hasColorGuard) {
			colorGuard = "Y";
		} else {
			colorGuard = "N";
		}
		return super.returnBandDetails() + "     " + String.format("%-10s %-10s %-10s %10s", colorGuard, this.typesOfProps, this.numOfBuses, this.costOfParticipation);
	}

	
	
	

}
