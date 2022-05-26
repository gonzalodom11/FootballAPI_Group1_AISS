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
		
		Player cb25 = new Player();
		cb25.setName("Claudio");
		cb25.setSurname("Bravo");
		cb25.setNationality("Chile");
		cb25.setTeam("Real Betis");
		cb25.setAge(38);
		cb25.setPosition("Goalkeeper");
		addPlayer(cb25);
		
		addPlayer(t2.getId(), cb25.getId());
		
		Player jm7 = new Player();
		jm7.setName("Miguel");
		jm7.setSurname("Juan");
		jm7.setNationality("Spain");
		jm7.setTeam("Real Betis");
		jm7.setAge(28);
		jm7.setPosition("Midfielder");
		addPlayer(jm7);
		
		addPlayer(t2.getId(), jm7.getId());
		
		Player nf8 = new Player();
		nf8.setName("Fekir");
		nf8.setSurname("Nabil");
		nf8.setNationality("France");
		nf8.setTeam("Real Betis");
		nf8.setAge(28);
		nf8.setPosition("Midfielder");
		addPlayer(nf8);
		
		addPlayer(t2.getId(), nf8.getId());
		
		Player pg16 = new Player();
		pg16.setName("Pedro");
		pg16.setSurname("Gonzalez");
		pg16.setNationality("Spain");
		pg16.setTeam("FC Barcelona");
		pg16.setAge(19);
		pg16.setPosition("Midfielder");
		addPlayer(pg16);
		
		addPlayer(t3.getId(), pg16.getId());
		
		
		Player at11 = new Player();
		at11.setName("Adama");
		at11.setSurname("Traore");
		at11.setNationality("Spain");
		at11.setTeam("FC Barcelona");
		at11.setAge(26);
		at11.setPosition("Striker");
		addPlayer(at11);
		
		addPlayer(t3.getId(), at11.getId());
		
		
		Player ts1 = new Player();
		ts1.setName("Marc-Andre");
		ts1.setSurname("Ter Stegen");
		ts1.setNationality("Germany");
		ts1.setTeam("FC Barcelona");
		ts1.setAge(30);
		ts1.setPosition("Goalkeeper");
		addPlayer(ts1);
		
		addPlayer(t3.getId(), ts1.getId());
		
		
		Player tc1 = new Player();
		tc1.setName("Courtois");
		tc1.setSurname("Thibaut");
		tc1.setNationality("Belgium");
		tc1.setTeam("Real Madrid");
		tc1.setAge(29);
		tc1.setPosition("Goalkeeper");
		addPlayer(tc1);
		
		addPlayer(t4.getId(), tc1.getId());
		
		Player kb9 = new Player();
		kb9.setName("Benzema");
		kb9.setSurname("Kareem");
		kb9.setNationality("France");
		kb9.setTeam("Real Madrid");
		kb9.setAge(34);
		kb9.setPosition("Striker");
		addPlayer(kb9);
		
		addPlayer(t4.getId(), kb9.getId());
		
		Player dc19 = new Player();
		dc19.setName("Ceballos");
		dc19.setSurname("Daniel");
		dc19.setNationality("Spain");
		dc19.setTeam("Real Madrid");
		dc19.setAge(25);
		dc19.setPosition("Midfielder");
		addPlayer(dc19);
		
		addPlayer(t4.getId(), dc19.getId());
		
		
		Player ag8 = new Player();
		ag8.setName("Griezmann");
		ag8.setSurname("Antoine");
		ag8.setNationality("France");
		ag8.setTeam("Atletico de Madrid");
		ag8.setAge(31);
		ag8.setPosition("Striker");
		addPlayer(ag8);
		
		addPlayer(t5.getId(), ag8.getId());
		
		Player jo13 = new Player();
		jo13.setName("Oblak");
		jo13.setSurname("Jan");
		jo13.setNationality("Slovenia");
		jo13.setTeam("Atletico de Madrid");
		jo13.setAge(29);
		jo13.setPosition("Goalkeeper");
		addPlayer(jo13);
		
		addPlayer(t5.getId(), jo13.getId());
		
		
		Player ls9 = new Player();
		ls9.setName("Suarez");
		ls9.setSurname("Luis");
		ls9.setNationality("Uruguay");
		ls9.setTeam("Atletico de Madrid");
		ls9.setAge(35);
		ls9.setPosition("Striker");
		addPlayer(ls9);
		
		addPlayer(t5.getId(), ls9.getId());
		
		
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
		
		
		//create players for serie A
		
		
		
		
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
		
		
		//create games for premier league
		
		Game g6 = new Game();
		g6.setTeamHome("Manchester City");
		g6.setTeamAway("Liverpool");
		g6.setGoalsHome(2);
		g6.setGoalsAway(1);
		g6.setDate("29.04.2022");
		g6.setLeague("Premier League");
		addGame(g6);
		
		Game g7 = new Game();
		g7.setTeamHome("Manchester United");
		g7.setTeamAway("Arsenal");
		g7.setGoalsHome(5);
		g7.setGoalsAway(7);
		g7.setDate("01.04.2022");
		g7.setLeague("Premier League");
		addGame(g7);
		
		Game g8 = new Game();
		g8.setTeamHome("Liverpool");
		g8.setTeamAway("Manchester United");
		g8.setGoalsHome(6);
		g8.setGoalsAway(2);
		g8.setDate("29.03.2022");
		g8.setLeague("Premier League");
		addGame(g8);
		
		Game g9 = new Game();
		g9.setTeamHome("Manchester City");
		g9.setTeamAway("Chelsea");
		g9.setGoalsHome(10);
		g9.setGoalsAway(3);
		g9.setDate("08.02.2022");
		g9.setLeague("Premier League");
		addGame(g9);
		
		Game g10 = new Game();
		g10.setTeamHome("Chelsea");
		g10.setTeamAway("Liverpool");
		g10.setGoalsHome(1);
		g10.setGoalsAway(0);
		g10.setDate("22.05.2022");
		g10.setLeague("Premier League");
		addGame(g10);
		
		//create games for serie A
		
		Game g11 = new Game();
		g11.setTeamHome("Juventus");
		g11.setTeamAway("Napoli");
		g11.setGoalsHome(2);
		g11.setGoalsAway(1);
		g11.setDate("20.01.2022");
		g11.setLeague("Serie A");
		addGame(g11);
		
		
		Game g12 = new Game();
		g12.setTeamHome("Inter");
		g12.setTeamAway("Milan");
		g12.setGoalsHome(5);
		g12.setGoalsAway(5);
		g12.setDate("16.03.2022");
		g12.setLeague("Serie A");
		addGame(g12);
		
		Game g13 = new Game();
		g13.setTeamHome("Roma");
		g13.setTeamAway("Napoli");
		g13.setGoalsHome(2);
		g13.setGoalsAway(3);
		g13.setDate("20.04.2022");
		g13.setLeague("Serie A");
		addGame(g13);
		
		Game g14 = new Game();
		g14.setTeamHome("Juventus");
		g14.setTeamAway("Inter");
		g14.setGoalsHome(0);
		g14.setGoalsAway(0);
		g14.setDate("10.02.2022");
		g14.setLeague("Serie A");
		addGame(g14);
		
		Game g15 = new Game();
		g15.setTeamHome("Milan");
		g15.setTeamAway("Roma");
		g15.setGoalsHome(3);
		g15.setGoalsAway(1);
		g15.setDate("30.05.2022");
		g15.setLeague("Serie A");
		addGame(g15);
		
		//create games for bundesliga
		
		Game g16 = new Game();
		g16.setTeamHome("Bayern");
		g16.setTeamAway("B. Dormund");
		g16.setGoalsHome(5);
		g16.setGoalsAway(2);
		g16.setDate("16.04.2022");
		g16.setLeague("Bundesliga");
		addGame(g16);
		
		Game g17 = new Game();
		g17.setTeamHome("Leipzig");
		g17.setTeamAway("Mainz 05");
		g17.setGoalsHome(6);
		g17.setGoalsAway(1);
		g17.setDate("13.04.2022");
		g17.setLeague("Bundesliga");
		addGame(g17);
		
		Game g18 = new Game();
		g18.setTeamHome("Leverkusen");
		g18.setTeamAway("B. Dormund");
		g18.setGoalsHome(3);
		g18.setGoalsAway(3);
		g18.setDate("03.02.2022");
		g18.setLeague("Bundesliga");
		addGame(g18);
		
		Game g19 = new Game();
		g19.setTeamHome("Bayern");
		g19.setTeamAway("Mainz 05");
		g19.setGoalsHome(8);
		g19.setGoalsAway(3);
		g19.setDate("16.01.2022");
		g19.setLeague("Bundesliga");
		addGame(g19);
		
		Game g20 = new Game();
		g20.setTeamHome("Mainz 05");
		g20.setTeamAway("Leverkusen");
		g20.setGoalsHome(0);
		g20.setGoalsAway(0);
		g20.setDate("22.02.2022");
		g20.setLeague("Bundesliga");
		addGame(g20);
		
		
		//create games for ligue 1
		
		Game g21 = new Game();
		g21.setTeamHome("Paris Saint Germain");
		g21.setTeamAway("Lyon");
		g21.setGoalsHome(4);
		g21.setGoalsAway(0);
		g21.setDate("13.02.2022");
		g21.setLeague("Ligue 1");
		addGame(g21);
		
		Game g22 = new Game();
		g22.setTeamHome("Monaco");
		g22.setTeamAway("Rennes");
		g22.setGoalsHome(1);
		g22.setGoalsAway(0);
		g22.setDate("17.01.2022");
		g22.setLeague("Ligue 1");
		addGame(g22);
		
		Game g23 = new Game();
		g23.setTeamHome("Marsella");
		g23.setTeamAway("Lyon");
		g23.setGoalsHome(2);
		g23.setGoalsAway(1);
		g23.setDate("23.04.2022");
		g23.setLeague("Ligue 1");
		addGame(g23);
		
		Game g24 = new Game();
		g24.setTeamHome("Monaco");
		g24.setTeamAway("Paris Saint Germain");
		g24.setGoalsHome(3);
		g24.setGoalsAway(6);
		g24.setDate("26.03.2022");
		g24.setLeague("Ligue 1");
		addGame(g24);
		
		
		Game g25 = new Game();
		g25.setTeamHome("Monaco");
		g25.setTeamAway("Lyon");
		g25.setGoalsHome(3);
		g25.setGoalsAway(1);
		g25.setDate("24.01.2022");
		g25.setLeague("Ligue 1");
		addGame(g25);
		
		
		
		
		
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
