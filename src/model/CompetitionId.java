package model;

import java.io.Serializable;

public class CompetitionId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int competitionId;
	int bandId;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bandId;
		result = prime * result + competitionId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetitionId other = (CompetitionId) obj;
		if (bandId != other.bandId)
			return false;
		if (competitionId != other.competitionId)
			return false;
		return true;
	}

}
