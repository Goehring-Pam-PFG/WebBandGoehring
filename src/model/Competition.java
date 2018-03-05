package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "participating_bands")

public class Competition {
	@Id
	@Column(name = "competition_id")
	protected int competitionId;
	@Column(name = "band_id")
	private int bandId;
	@Transient
	private List<Band> bandList;
	
	public Competition() {
		super();
	}
	

	public Competition(int competitionId, int bandId) {
		super();
		this.competitionId = competitionId;
		this.bandId = bandId;
	}



	public int getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}

	public int getBand_id() {
		return bandId;
	}

	public void setBand_id(int bandId) {
		this.bandId = bandId;
	}

	
	@Override
	public String toString() {
		return "Competition [competitionId=" + competitionId + ", band_id=" + bandId + "]";
	}


	public String returnCompetitionDetails() {
		return "Band ID: " + bandId + "  Competition ID: " + competitionId;
	}

	
	

}
