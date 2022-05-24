package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.model.Game;
import aiss.model.League;
import aiss.model.Player;
import aiss.model.Team;

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
		
		
		// create teams for la liga
		Team t1 = new Team();
		t1.setName("Sevilla FC");
		t1.setLeague("La Liga");
		t1.setCoach("Julen Lopetegui");
		addTeam(t1);
		
		Team t2 = new Team();
		t2.setName("Real Betis");
		t2.setLeague("La Liga");
		t2.setCoach("Manuel Pellegrini");
		addTeam(t2);
		
		Team t3 = new Team();
		t3.setName("FC Barcelona");
		t3.setLeague("La Liga");
		t3.setCoach("Xavi Hernández");
		addTeam(t3);
		
		Team t4 = new Team();
		t4.setName("Real Madrid");
		t4.setLeague("La Liga");
		t4.setCoach("Carlo Ancelotti");
		addTeam(t4);
		
		Team t5 = new Team();
		t5.setName("Atlético de Madrid");
		t5.setLeague("La Liga");
		t5.setCoach("Diego Pablo Simeone");
		addTeam(t5);
		
		
		//create teams for premier league
		
		Team t6 = new Team();
		t6.setName("Manchester City");
		t6.setLeague("Premier league");
		t6.setCoach("Pep Guardiola");
		addTeam(t6);
		
		Team t7 = new Team();
		t7.setName("Liverpool");
		t7.setLeague("Premier league");
		t7.setCoach("J. Klopp");
		addTeam(t7);
		
		Team t8 = new Team();
		t8.setName("Chelsea");
		t8.setLeague("Premier league");
		t8.setCoach("T. Tuchel");
		addTeam(t8);
		
		Team t9 = new Team();
		t9.setName("Arsenal");
		t9.setLeague("Premier league");
		t9.setCoach("Mikel Arteta");
		addTeam(t9);
		
		Team t10 = new Team();
		t10.setName("Manchester United");
		t10.setLeague("Premier league");
		t10.setCoach("R. Rangnick");
		addTeam(t10);
		
		
		//create teams for serie A
		
		Team t11 = new Team();
		t11.setName("Juventus");
		t11.setLeague("Serie A");
		t11.setCoach("Massimiliano Allegri");
		addTeam(t11);
		
		Team t12 = new Team();
		t12.setName("Milan");
		t12.setLeague("Serie A");
		t12.setCoach("Stefano Pioli");
		addTeam(t12);
		
		Team t13 = new Team();
		t13.setName("Inter");
		t13.setLeague("Serie A");
		t13.setCoach("Simone Inzaghi");
		addTeam(t13);
		
		Team t14 = new Team();
		t14.setName("Roma");
		t14.setLeague("Serie A");
		t14.setCoach("Jose Mourinho");
		addTeam(t14);
		
		Team t15 = new Team();
		t15.setName("Napoli");
		t15.setLeague("Serie A");
		t15.setCoach("Luciano Spalletti");
		addTeam(t15);
		
		
		
		//create teams for bundesliga
				
		Team t16 = new Team();
		t16.setName("Bayern");
		t16.setLeague("Bundesliga");
		t16.setCoach("Julian Nagelsmann");
		addTeam(t16);
		
		Team t17 = new Team();
		t17.setName("B. Dormund");
		t17.setLeague("Bundesliga");
		t17.setCoach("Marco Rose");
		addTeam(t17);
		
		
		Team t18 = new Team();
		t18.setName("Leverkusen");
		t18.setLeague("Bundesliga");
		t18.setCoach("Gerardo Seoane");
		addTeam(t18);
		
		Team t19 = new Team();
		t19.setName("Leipzig");
		t19.setLeague("Bundesliga");
		t19.setCoach("Domenico Tedesco");
		addTeam(t19);
		
		Team t20 = new Team();
		t20.setName("Mainz 05");
		t20.setLeague("Bundesliga");
		t20.setCoach("Bo Svensson");
		addTeam(t20);
		
		
		
		
		//create teams for ligue 1
		
		Team t21 = new Team();
		t21.setName("Paris Saint Germain");
		t21.setLeague("Ligue 1");
		t21.setCoach("Mauricio Pochettino");
		addTeam(t21);
		
		Team t22 = new Team();
		t22.setName("Marsella");
		t22.setLeague("Ligue 1");
		t22.setCoach("Jorge Sampaoli");
		addTeam(t22);
		
		Team t23 = new Team();
		t23.setName("Monaco");
		t23.setLeague("Ligue 1");
		t23.setCoach("Phillippe Clement");
		addTeam(t23);
		
		Team t24 = new Team();
		t24.setName("Lyon");
		t24.setLeague("Ligue 1");
		t24.setCoach("Peter Bosz");
		addTeam(t24);
		
		Team t25 = new Team();
		t25.setName("Rennes");
		t25.setLeague("Ligue 1");
		t25.setCoach("Bruno Genesio");
		addTeam(t25);
		
		
		
		
		//create players for la liga
		
		Player lo5  = new Player();
		lo5.setName("Ocampos");
		lo5.setSurname("Lucas");
		lo5.setNationality("Argentina");
		lo5.setTeam("FC Sevilla");
		lo5.setAge(27);
		lo5.setPosition("Striker");
		addPlayer(lo5);
		
		addPlayer(t1.getId(), lo5.getId());
		
		Player ir10 = new Player();
		ir10.setName("Ivan");
		ir10.setSurname("Rakitic");
		ir10.setNationality("Croatia");
		ir10.setTeam("FC Sevilla");
		ir10.setAge(34);
		ir10.setPosition("Midfielder");
		addPlayer(ir10);
		
		addPlayer(t1.getId(), ir10.getId());
		
		Player dc20 = new Player();
		dc20.setName("Carlos");
		dc20.setSurname("Diego");
		dc20.setNationality("Brazil");
		dc20.setTeam("FC Sevilla");
		dc20.setAge(29);
		dc20.setPosition("Defender");
		addPlayer(dc20);
		
		addPlayer(t1.getId(), dc20.getId());
		
		
		
		
		
		//create players for premier league
		Player cr7 = new Player();
		cr7.setName("Ronaldo");
		cr7.setSurname("Cristiano");
		cr7.setNationality("Portugal");
		cr7.setTeam("Manchester United");
		cr7.setAge(37);
		cr7.setPosition("Striker");
		addPlayer(cr7);
		
		addPlayer(t10.getId(), cr7.getId());
		
		
		
		
		//create players for ligue 1
		Player lm10 = new Player();
		lm10.setName("Messi");
		lm10.setSurname("Lionel)");
		lm10.setTeam("Paris Saint Germain");
		lm10.setNationality("Argentina");
		lm10.setAge(35);
		lm10.setPosition("Striker");
		addPlayer(lm10);
		
		addPlayer(t21.getId(), lm10.getId());
		
		//create games for la liga
		Game g1 = new Game();
		g1.setTeamHome("Real Betis");
		g1.setTeamAway("FC Sevilla");
		g1.setGoalsHome(0);
		g1.setGoalsAway(2);
		g1.setDate("05.05.2022");
		g1.setLeague("La Liga");
		addGame(g1);
		
		Game g2 = new Game();
		g2.setTeamHome("FC Barcelona");
		g2.setTeamAway("FC Sevilla");
		g2.setGoalsHome(1);
		g2.setGoalsAway(3);
		g2.setDate("04.03.2022");
		g2.setLeague("La Liga");
		addGame(g2);
		
		Game g3 = new Game();
		g3.setTeamHome("Real Madrid");
		g3.setTeamAway("Atletico de Madrid");
		g3.setGoalsHome(1);
		g3.setGoalsAway(1);
		g3.setDate("12.03.2022");
		g3.setLeague("La Liga");
		addGame(g3);
		
		Game g4 = new Game();
		g4.setTeamHome("FC Barcelona");
		g4.setTeamAway("Real Madrid");
		g4.setGoalsHome(4);
		g4.setGoalsAway(0);
		g4.setDate("16.03.2022");
		g4.setLeague("La Liga");
		addGame(g4);
		
		Game g5 = new Game();
		g5.setTeamHome("Real Betis");
		g5.setTeamAway("Atletico de Madrid");
		g5.setGoalsHome(0);
		g5.setGoalsAway(0);
		g5.setDate("24.04.2022");
		g5.setLeague("La Liga");
		addGame(g5);
		
		
		
		
		
		//create Leagues
		League l1 = new League();
		l1.setName("La Liga");
		l1.setCountry("Spain");
		addLeague(l1);
		
		League l2 = new League();
		l2.setName("Premier League");
		l2.setCountry("England");
		addLeague(l2);
		
		League l3 = new League();
		l3.setName("Serie A");
		l3.setCountry("Italy");
		addLeague(l3);
		
		League l4 = new League();
		l4.setName("Bundesliga");
		l4.setCountry("Germany");
		addLeague(l4);
		
		League l5 = new League();
		l5.setName("Ligue 1");
		l5.setCountry("France");
		addLeague(l5);
		
		//add teams and games to la liga
		
		addTeamLeague(l1.getId(), t1.getId());
		addTeamLeague(l1.getId(), t2.getId());
		addTeamLeague(l1.getId(), t3.getId());
		addTeamLeague(l1.getId(), t4.getId());
		addTeamLeague(l1.getId(), t5.getId());
		
		addGameLeague(l1.getId(), g1.getId());
		addGameLeague(l1.getId(), g2.getId());
		addGameLeague(l1.getId(), g3.getId());
		addGameLeague(l1.getId(), g4.getId());
		addGameLeague(l1.getId(), g5.getId());
		
		//add teams and games to premier league
		
		addTeamLeague(l2.getId(), t6.getId());
		addTeamLeague(l2.getId(), t7.getId());
		addTeamLeague(l2.getId(), t8.getId());
		addTeamLeague(l2.getId(), t9.getId());
		addTeamLeague(l2.getId(), t10.getId());
		
		addGameLeague(l2.getId(), g6.getId());
		addGameLeague(l2.getId(), g7.getId());
		addGameLeague(l2.getId(), g8.getId());
		addGameLeague(l2.getId(), g9.getId());
		addGameLeague(l2.getId(), g10.getId());
		
		
		//add teams and games to serie A
		
		addTeamLeague(l3.getId(), t11.getId());
		addTeamLeague(l3.getId(), t12.getId());
		addTeamLeague(l3.getId(), t13.getId());
		addTeamLeague(l3.getId(), t14.getId());
		addTeamLeague(l3.getId(), t15.getId());
		
		addGameLeague(l3.getId(), g11.getId());
		addGameLeague(l3.getId(), g12.getId());
		addGameLeague(l3.getId(), g13.getId());
		addGameLeague(l3.getId(), g14.getId());
		addGameLeague(l3.getId(), g15.getId());
		
		//add teams and games to bundesliga
		
		addTeamLeague(l4.getId(), t16.getId());
		addTeamLeague(l4.getId(), t17.getId());
		addTeamLeague(l4.getId(), t18.getId());
		addTeamLeague(l4.getId(), t19.getId());
		addTeamLeague(l4.getId(), t20.getId());
		
		addGameLeague(l4.getId(), g16.getId());
		addGameLeague(l4.getId(), g17.getId());
		addGameLeague(l4.getId(), g18.getId());
		addGameLeague(l4.getId(), g19.getId());
		addGameLeague(l4.getId(), g20.getId());
		
		
		//add teams and games to ligue 1
		
		addTeamLeague(l5.getId(), t21.getId());
		addTeamLeague(l5.getId(), t22.getId());
		addTeamLeague(l5.getId(), t23.getId());
		addTeamLeague(l5.getId(), t24.getId());
		addTeamLeague(l5.getId(), t25.getId());
		
		addGameLeague(l5.getId(), g21.getId());
		addGameLeague(l5.getId(), g22.getId());
		addGameLeague(l5.getId(), g23.getId());
		addGameLeague(l5.getId(), g24.getId());
		addGameLeague(l5.getId(), g25.getId());
		
		
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
