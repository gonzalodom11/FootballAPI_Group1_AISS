package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Game;

public class ComparatorGoalsGameReverse implements Comparator<Game>{
	@Override
	public int compare(Game g1, Game g2) {
		return g2.getGoals() - g1.getGoals();
	}

}

