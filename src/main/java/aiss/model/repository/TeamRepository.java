package aiss.model.repository;

import java.util.Collection;

import aiss.model.Team;
import aiss.model.Game;
import aiss.model.League;
import aiss.model.Player;

public interface TeamRepository {
	
		// players
		public void addPlayer(Player p);
		public Collection<Player> getAllPlayers();
		public Player getPlayer(String playerId);
		public void updatePlayer(Player p);
		public void deletePlayer(String playerId);
		
		// Teams
		public void addTeam(Team t);
		public Collection<Team> getAllTeams();
		public Team getTeam(String teamId);
		public void updateTeam(Team t);
		public void deleteTeam(String teamId);
		public Collection<Player> getAll(String teamId);
		public void addPlayer(String teamId, String playerId);
		public void removePlayer(String teamId, String playerId);
		
		//games
		public void addGame(Game g);
		public Collection<Game> getAllGames();
		public Game getGame(String gameId);
		public void updateGame(Game g);
		public void deleteGame(String gameId);
		
		// leagues
		public void addLeague(League l);
		public Collection<League> getAllLeagues();
		public League getLeague(String leagueId);
		public void updateLeague(League l);
		public void deleteLeague(String leagueId);
		public Collection<Team> getAllTeamsLeague(String LeagueId);
		public void addTeamLeague(String leagueId, String teamId);
		public void removeTeamLeague(String leagueId, String teamId);
		public Collection<Game> getAllGamesLeague(String leagueId);
		public void addGameLeague(String leagueId, String gameId);
		public void removeGameLeague(String leagueId, String gameId);

}
