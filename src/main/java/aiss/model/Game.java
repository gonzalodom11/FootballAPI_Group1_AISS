package aiss.model;

public class Game {
	
	private String id;
	private String teamHome;
	private String teamAway;
	private Integer goalsHome;
	private Integer goalsAway;
	private String date;
	private String league;
	
	public Game() {
		
	}
	
	public Game(String id, String teamHome, String teamAway, Integer goalsHome, Integer goalsAway, String date, String league, String season) {
		this.id = id;
		this.teamHome = teamHome;
		this.teamAway = teamAway;
		this.goalsHome = goalsHome;
		this.goalsAway = goalsAway;
		this.date = date;
		this.league = league;
	}

	public Game(String teamHome, String teamAway, Integer goalsHome, Integer goalsAway, String date, String league) {
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

	public String getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(String teamHome) {
		this.teamHome = teamHome;
	}

	public String getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(String teamAway) {
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
	
	
	
	
	
	

}
