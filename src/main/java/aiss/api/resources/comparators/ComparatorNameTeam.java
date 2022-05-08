package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Team;

public class ComparatorNameTeam implements Comparator<Team>{

	@Override
	public int compare(Team t1, Team t2) {
		return t1.getName().compareTo(t2.getName());
	}

}
