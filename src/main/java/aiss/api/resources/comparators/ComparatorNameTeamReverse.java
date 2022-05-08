package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Team;

public class ComparatorNameTeamReverse implements Comparator<Team>{

	@Override
	public int compare(Team o1, Team o2) {
		return o2.getName().compareTo(o1.getName());
	}

}
