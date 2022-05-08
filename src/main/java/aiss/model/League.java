package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class League {
	
	private String id;
	private String name;
	private String country;
	private List<Team> teams;
	private List<Game> games;
	
	public League() {
		
	}

	public League(String id, String name, String country, List<Team> teams, List<Game> games) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.teams = teams;
		this.games = games;
	}

	public League(String name, String country, List<Team> teams, List<Game> games) {
		super();
		this.name = name;
		this.country = country;
		this.teams = teams;
		this.games = games;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public Team getTeam(String id) {
		if (teams==null)
			return null;
		
		Team team =null;
		for(Team t: teams)
			if (t.getId().equals(id))
			{
				team=t;
				break;
			}
		
		return team;
	}
	
	public void addTeam(Team t) {
		if (teams==null)
			teams = new ArrayList<Team>();
		teams.add(t);
	}
	
	public void deleteTeam(Team t) {
		teams.remove(t);
	}
	
	public void deleteTeam(String id) {
		Team t = getTeam(id);
		if (t!=null)
			teams.remove(t);
	}
	
	public Game getGame(String id) {
		if (games==null)
			return null;
		
		Game game =null;
		for(Game g: games)
			if (g.getId().equals(id))
			{
				game=g;
				break;
			}
		
		return game;
	}
	
	public void addGame(Game g) {
		if (games==null)
			games = new ArrayList<Game>();
		games.add(g);
	}
	
	public void deleteGame(Game g) {
		games.remove(g);
	}
	
	public void deleteGame(String id) {
		Game g = getGame(id);
		if (g!=null)
			games.remove(g);
	}

}
