package aiss.model;

public class Game {
	
	private String id;
	private Team teamHome;
	private Team teamAway;
	private Integer goalsHome;
	private Integer goalsAway;
	private String date;
	private String league;
	
	public Game() {
		
	}
	
	public Game(String id, Team teamHome, Team teamAway, Integer goalsHome, Integer goalsAway, String date, String league, String season) {
		this.id = id;
		this.teamHome = teamHome;
		this.teamAway = teamAway;
		this.goalsHome = goalsHome;
		this.goalsAway = goalsAway;
		this.date = date;
		this.league = league;
	}

	public Game(Team teamHome, Team teamAway, Integer goalsHome, Integer goalsAway, String date, String league) {
		this.teamHome = teamHome;
		this.teamAway = teamAway;
		this.goalsHome = goalsHome;
		this.goalsAway = goalsAway;
		this.date = date;
		this.league = league;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Team getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(Team teamHome) {
		this.teamHome = teamHome;
	}

	public Team getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(Team teamAway) {
		this.teamAway = teamAway;
	}

	public Integer getGoalsHome() {
		return goalsHome;
	}

	public void setGoalsHome(Integer goalsHome) {
		this.goalsHome = goalsHome;
	}

	public Integer getGoalsAway() {
		return goalsAway;
	}

	public void setGoalsAway(Integer goalsAway) {
		this.goalsAway = goalsAway;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}
	
	public int getGoals() {
		return goalsHome + goalsAway;
	}
	
	
	
	
	
	

}
