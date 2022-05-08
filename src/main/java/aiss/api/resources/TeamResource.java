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

import aiss.model.Team;
import aiss.api.resources.comparators.ComparatorNameTeam;
import aiss.api.resources.comparators.ComparatorNameTeamReverse;
import aiss.model.Player;
import aiss.model.repository.MapTeamRepository;
import aiss.model.repository.TeamRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Path("/teams")
public class TeamResource {
	
	/* Singleton */
	private static TeamResource _instance=null;
	TeamRepository repository;
	
	private TeamResource() {
		repository=MapTeamRepository.getInstance();

	}
	
	public static TeamResource getInstance()
	{
		if(_instance==null)
				_instance=new TeamResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Team> getAll(@QueryParam("order") String order, 
			@QueryParam("name") String name)
	{/*
		List<Team> result = new ArrayList<>(); 
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
		return repository.getAllTeams();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Team get(@PathParam("id") String id)
	{
		Team team = repository.getTeam(id);
		
		if (team == null) {
			throw new NotFoundException("The Team with id="+ id +" was not found");			
		}
		
		return team;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTeam(@Context UriInfo uriInfo, Team team) {
		if (team.getName() == null || "".equals(team.getName()))
			throw new BadRequestException("The name of the team must not be null");
		
		if (team.getPlayers()!=null)
			throw new BadRequestException("The players property is not editable.");

		repository.addTeam(team);

		// Builds the response. Returns the team the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(team.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(team);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateTeam(Team team) {
		Team oldTeam = repository.getTeam(team.getId());
		if (oldTeam == null) {
			throw new NotFoundException("The team with id="+ team.getId() +" was not found");			
		}
		
		if (team.getPlayers()!=null)
			throw new BadRequestException("The teams property is not editable.");
		
		// Update name
		if (team.getName()!=null)
			oldTeam.setName(team.getName());
		
		// Update league
		if (team.getLeague()!=null)
			oldTeam.setLeague(team.getLeague());
		
		//update coach
		if (team.getCoach()!=null)
			oldTeam.setCoach(team.getCoach());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response remoceTeam(@PathParam("id") String id) {
		Team toberemoved=repository.getTeam(id);
		if (toberemoved == null)
			throw new NotFoundException("The team with id="+ id +" was not found");
		else
			repository.deleteTeam(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{teamId}/{playerId}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addPlayer(@Context UriInfo uriInfo,@PathParam("teamId") String teamId, @PathParam("playerId") String playerId)
	{				
		
		Team team = repository.getTeam(teamId);
		Player player = repository.getPlayer(playerId);
		
		if (team==null)
			throw new NotFoundException("The team with id=" + teamId + " was not found");
		
		if (player == null)
			throw new NotFoundException("The player with id=" + playerId + " was not found");
		
		if (team.getPlayer(playerId)!=null)
			throw new BadRequestException("The player is already included in the Team.");
			
		repository.addPlayer(teamId, playerId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(teamId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(team);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{teamId}/{playerId}")
	public Response removePlayer(@PathParam("teamId") String teamId, @PathParam("playerId") String playerId) {
		Team team = repository.getTeam(teamId);
		Player player = repository.getPlayer(playerId);
		
		if (team==null)
			throw new NotFoundException("The team with id=" + teamId + " was not found");
		
		if (player == null)
			throw new NotFoundException("The player with id=" + playerId + " was not found");
		
		
		repository.removePlayer(teamId, playerId);		
		
		return Response.noContent().build();
	}

}

