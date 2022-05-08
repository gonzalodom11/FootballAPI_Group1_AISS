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

import aiss.model.Game;
import aiss.model.League;
import aiss.model.Player;
import aiss.model.Team;
import aiss.model.repository.MapTeamRepository;
import aiss.model.repository.TeamRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Path("/leagues")
public class LeagueResource {
	/* Singleton */
	private static LeagueResource _instance=null;
	TeamRepository repository;
	
	private LeagueResource() {
		repository=MapTeamRepository.getInstance();

	}
	
	public static LeagueResource getInstance()
	{
		if(_instance==null)
				_instance=new LeagueResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<League> getAll(@QueryParam("order") String order, 
			@QueryParam("name") String name)
	{
		/*List<Team> result = new ArrayList<>(); 
		result = (List<Team>) repository.getAllTeams();
		
		if (order != null) {
			if (order.equals("name")) {
				Collections.sort(result, new ComparatorNameTeam());
			} else if (order.equals("-name")) {
				Collections.sort(result, new ComparatorNameTeamReverse());
			} else {
				throw new BadRequestException("The order parameter must be 'name' or '-name'.");
			}
		}
		return result;*/
		return repository.getAllLeagues();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public League get(@PathParam("id") String id)
	{
		League league = repository.getLeague(id);
		
		if (league == null) {
			throw new NotFoundException("The league with id="+ id +" was not found");			
		}
		
		return league;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addLeague(@Context UriInfo uriInfo, League league) {
		if (league.getName() == null || "".equals(league.getName()))
			throw new BadRequestException("The name of the league must not be null");
		
		if (league.getTeams()!=null || league.getGames()!= null)
			throw new BadRequestException("The teams and games properties are not editable.");

		repository.addLeague(league);

		// Builds the response. Returns the team the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(league.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(league);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateLeague(League league) {
		League oldLeague = repository.getLeague(league.getId());
		if (oldLeague == null) {
			throw new NotFoundException("The league with id="+ league.getId() +" was not found");			
		}
		
		if (league.getTeams()!=null || league.getGames() != null)
			throw new BadRequestException("The teams and games properties are not editable.");
		
		// Update name
		if (league.getName()!=null)
			oldLeague.setName(league.getName());
		
		// Update country
		if (league.getCountry()!=null)
			oldLeague.setCountry(league.getCountry());
		
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeLeague(@PathParam("id") String id) {
		League toberemoved=repository.getLeague(id);
		if (toberemoved == null)
			throw new NotFoundException("The league with id="+ id +" was not found");
		else
			repository.deleteLeague(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{leagueId}/{teamId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addTeam(@Context UriInfo uriInfo,@PathParam("leagueId") String leagueId, @PathParam("teamId") String teamId)
	{				
		
		League league = repository.getLeague(leagueId);
		Team team = repository.getTeam(teamId);
		
		if (league==null)
			throw new NotFoundException("The league with id=" + leagueId + " was not found");
		
		if (team == null)
			throw new NotFoundException("The team with id=" + teamId + " was not found");
		
		if (league.getTeam(teamId)!=null)
			throw new BadRequestException("The team is already included in the Team.");
			
		repository.addTeamLeague(leagueId, teamId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(leagueId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(league);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{leagueId}/{teamId}")
	public Response removeTeam(@PathParam("leagueId") String leagueId, @PathParam("teamId") String teamId) {
		Team team = repository.getTeam(teamId);
		League league = repository.getLeague(leagueId);
		
		if (team==null)
			throw new NotFoundException("The team with id=" + teamId + " was not found");
		
		if (league == null)
			throw new NotFoundException("The plaleagueyer with id=" + leagueId + " was not found");
		
		
		repository.removeTeamLeague(leagueId, teamId);		
		
		return Response.noContent().build();
	}
	
	@POST	
	@Path("/{leagueId}/{gameId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo,@PathParam("leagueId") String leagueId, @PathParam("gameId") String gameId)
	{				
		
		League league = repository.getLeague(leagueId);
		Game game = repository.getGame(gameId);
		
		if (league==null)
			throw new NotFoundException("The league with id=" + leagueId + " was not found");
		
		if (game == null)
			throw new NotFoundException("The game with id=" + gameId + " was not found");
		
		if (league.getGame(gameId)!=null)
			throw new BadRequestException("The game is already included in the Team.");
			
		repository.addTeamLeague(leagueId, gameId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(leagueId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(league);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{leagueId}/{gameId}")
	public Response removeGame(@PathParam("leagueId") String leagueId, @PathParam("gameId") String gameId) {
		Game game = repository.getGame(gameId);
		League league = repository.getLeague(leagueId);
		
		if (game==null)
			throw new NotFoundException("The game with id=" + gameId + " was not found");
		
		if (league == null)
			throw new NotFoundException("The plaleagueyer with id=" + leagueId + " was not found");
		
		
		repository.removeTeamLeague(leagueId, gameId);		
		
		return Response.noContent().build();
	}

}
