package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.Game;
import aiss.model.League;
import aiss.model.Player;
import aiss.model.Team;
import aiss.model.Player.Position;

public class MapTeamRepository implements TeamRepository{
	
	Map<String, Team> teamMap;
	Map<String, Player> playerMap;
	Map<String, Game> gameMap;
	Map<String, League> leagueMap;
	private static MapTeamRepository instance=null;
	private int index=0;			// Index to create Teams and players' identifiers.
	
	
	public static MapTeamRepository getInstance() {
		
		if (instance==null) {
			instance = new MapTeamRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		teamMap = new HashMap<String,Team>();
		playerMap = new HashMap<String,Player>();
		gameMap = new HashMap<String,Game>();
		leagueMap = new HashMap<String,League>();
		
		
		// create team
		Team t1 = new Team();
		t1.setName("Real Betis");
		t1.setLeague("La Liga");
		t1.setCoach("Manuel Pellegrini");
		addTeam(t1);
		
		Team t2 = new Team();
		t2.setName("FC Sevilla");
		t2.setLeague("La Liga");
		t2.setCoach("Julen Lopetegui");
		addTeam(t2);
		
		//create players
		Player cr7 = new Player();
		cr7.setName("Cristiano");
		cr7.setSurname("Ronaldo");
		cr7.setNationality("Portugal");
		cr7.setTeam("Real Betis");
		cr7.setAge(37);
		cr7.setPosition(Position.STRIKER);
		addPlayer(cr7);
		
		addPlayer(t1.getId(), cr7.getId());
		
		Player lm10 = new Player();
		lm10.setName("Leo");
		lm10.setSurname("Messi");
		lm10.setTeam("FC Sevilla");
		lm10.setNationality("Argentina");
		lm10.setAge(35);
		lm10.setPosition(Position.STRIKER);
		addPlayer(lm10);
		
		addPlayer(t2.getId(), lm10.getId());

		Player gr21 = new Player();
		lm10.setName("Guido");
		lm10.setSurname("Rodríguez");
		lm10.setTeam("Real Betis");
		lm10.setNationality("Argentina");
		lm10.setAge(28);
		lm10.setPosition(Position.MIDFIELDER);
		addPlayer(gr21);
		
		addPlayer(t1.getId(), lm10.getId());


		
		//create game
		Game g1 = new Game();
		g1.setTeamHome("Real Betis");
		g1.setTeamAway("FC Sevilla");
		g1.setGoalsHome(2);
		g1.setGoalsAway(2);
		g1.setDate("05.05.2022");
		g1.setLeague("La Liga");
		addGame(g1);
		
		//create League
		League l1 = new League();
		l1.setName("La Liga");
		l1.setCountry("Spain");
		addLeague(l1);
		
		addTeamLeague(l1.getId(), t1.getId());
		addTeamLeague(l1.getId(), t2.getId());
		
		addGameLeague(l1.getId(), g1.getId());
		
	}
	
	//player related methods
	@Override
	public void addPlayer(Player p) {
		String id = "p" + index++;	
		p.setId(id);
		playerMap.put(id,p);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return playerMap.values();

	}

	@Override
	public Player getPlayer(String playerId) {
		return playerMap.get(playerId);
	}

	@Override
	public void updatePlayer(Player p) {
		Player player = playerMap.get(p.getId());
		player.setName(p.getName());
		player.setSurname(p.getSurname());
		player.setTeam(p.getTeam());
		player.setNationality(p.getNationality());
		player.setAge(p.getAge());
		player.setPosition(p.getPosition());
		
	}

	@Override
	public void deletePlayer(String playerId) {
		playerMap.remove(playerId);
		
	}
	
	//Team related methods
	@Override
	public void addTeam(Team t) {
		String id = "t" + index++;	
		t.setId(id);
		teamMap.put(id,t);
		
	}

	@Override
	public Collection<Team> getAllTeams() {
		return teamMap.values();
	}

	@Override
	public Team getTeam(String teamId) {
		return teamMap.get(teamId);
	}

	@Override
	public void updateTeam(Team t) {
		teamMap.put(t.getId(),t);
		
	}

	@Override
	public void deleteTeam(String teamId) {
		teamMap.remove(teamId);
		
	}

	@Override
	public Collection<Player> getAll(String teamId) {
		return getTeam(teamId).getPlayers();
	}

	@Override
	public void addPlayer(String teamId, String playerId) {
		Team team = getTeam(teamId);
		team.addPlayer(playerMap.get(playerId));
		
	}

	@Override
	public void removePlayer(String teamId, String playerId) {
		getTeam(teamId).deletePlayer(playerId);
		
	}

	@Override
	public void addGame(Game g) {
		String id = "g" + index++;	
		g.setId(id);
		gameMap.put(id,g);
	}

	@Override
	public Collection<Game> getAllGames() {
		return gameMap.values();
	}

	@Override
	public Game getGame(String gameId) {
		return gameMap.get(gameId);
	}
	
	@Override
	public void updateGame(Game g) {
		Game game = gameMap.get(g.getId());
		game.setTeamHome(g.getTeamHome());
		game.setTeamAway(g.getTeamAway());
		game.setGoalsHome(g.getGoalsHome());
		game.setGoalsAway(g.getGoalsAway());
		game.setDate(g.getDate());
		game.setLeague(g.getLeague());
		
	}

	@Override
	public void deleteGame(String gameId) {
		gameMap.remove(gameId);
		
	}

	@Override
	public void addLeague(League l) {
		String id = "l" + index++;	
		l.setId(id);
		leagueMap.put(id,l);
		
	}

	@Override
	public Collection<League> getAllLeagues() {
		return leagueMap.values();
	}

	@Override
	public League getLeague(String leagueId) {
		return leagueMap.get(leagueId);
	}
	
	@Override
	public void updateLeague(League l) {
		leagueMap.put(l.getId(),l);
		
	}

	@Override
	public void deleteLeague(String leagueId) {
		leagueMap.remove(leagueId);
		
	}

	@Override
	public Collection<Team> getAllTeamsLeague(String LeagueId) {
		return getLeague(LeagueId).getTeams();
	}

	@Override
	public void addTeamLeague(String leagueId, String teamId) {
		League league = getLeague(leagueId);
		league.addTeam(teamMap.get(teamId));
		
	}

	@Override
	public void removeTeamLeague(String leagueId, String teamId) {
		getLeague(leagueId).deleteTeam(teamId);
		
	}

	@Override
	public Collection<Game> getAllGamesLeague(String leagueId) {
		return getLeague(leagueId).getGames();
	}

	@Override
	public void addGameLeague(String leagueId, String gameId) {
		League league = getLeague(leagueId);
		league.addGame(gameMap.get(gameId));
		
	}

	@Override
	public void removeGameLeague(String leagueId, String gameId) {
		getLeague(leagueId).deleteGame(gameId);
	}

}
