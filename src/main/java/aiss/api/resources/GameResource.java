package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.model.Player;
import aiss.model.Team;
import aiss.model.Game;
import aiss.model.repository.MapTeamRepository;
import aiss.model.repository.TeamRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@Path("/games")
public class GameResource {

	public static GameResource _instance=null;
	TeamRepository repository;
	
	private GameResource(){
		repository=MapTeamRepository.getInstance();
	}
	
	public static GameResource getInstance()
	{
		if(_instance==null)
			_instance=new GameResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Game> getAll(@QueryParam("goals") Integer goals, 
			@QueryParam("team")String team)
	{
		List<Game> result = new ArrayList<Game>();
		for (Game game: repository.getAllGames()) {
			if ((goals == null || (game.getGoalsHome() + game.getGoalsAway()) >= goals) && 
					(team == null || game.getTeamHome().replaceAll("\\s+","").equals(team) || game.getTeamAway().replaceAll("\\s+","").equals(team))) {
				result.add(game);
			}
		}
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game get(@PathParam("id") String gameId)
	{
		Game game = repository.getGame(gameId);
		
		if (game == null) {
			throw new NotFoundException("The game with id="+ gameId +" was not found");			
		}
		
		return game;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		if (game.getTeamHome() == null || "".equals(game.getTeamHome()) ||game.getTeamAway() == null || "".equals(game.getTeamAway()))
			throw new BadRequestException("The name of the teams must not be null");
		
		repository.addGame(game);

		// Builds the response. Returns the song the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(game.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);			
		return resp.build();
	}
		
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) {
		Game oldGame = repository.getGame(game.getId());
		if (oldGame == null) {
			throw new NotFoundException("The game with id="+ game.getId() +" was not found");			
		}
		
		// Update home team
		if (game.getTeamHome()!=null)
			oldGame.setTeamHome(game.getTeamHome());
		
		// Update away team
		if (game.getTeamAway()!=null)
			oldGame.setTeamAway(game.getTeamAway());
		
		//Update home goals
		if (game.getGoalsHome()!=null && game.getGoalsHome() >= 0)
			oldGame.setGoalsHome(game.getGoalsHome());
		
		//Update away goals
		if (game.getGoalsAway()!=null && game.getGoalsAway() >= 0)
			oldGame.setGoalsAway(game.getGoalsAway());
		
		//update date
		if (game.getDate()!=null)
			oldGame.setDate(game.getDate());
		
		//Update league
		if (game.getLeague()!=null)
			oldGame.setLeague(game.getLeague());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGame(@PathParam("id") String gameId) {
		Game toberemoved=repository.getGame(gameId);
		if (toberemoved == null)
			throw new NotFoundException("The game with id="+ gameId +" was not found");
		else
			repository.deleteGame(gameId);
		
		return Response.noContent().build();
	}
	
}

