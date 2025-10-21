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
import aiss.model.Player;
import aiss.model.repository.MapTeamRepository;
import aiss.model.repository.TeamRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/players")
public class PlayerResource {
	
	public static PlayerResource _instance=null;
	TeamRepository repository;
	
	private PlayerResource(){
		repository=MapTeamRepository.getInstance();
	}
	
	public static PlayerResource getInstance()
	{
		if(_instance==null)
			_instance=new PlayerResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Player> getAll(@QueryParam("nationality") String nationality, @QueryParam("ageOver") Integer ageOver, @QueryParam("ageUnder") Integer ageUnder, @QueryParam("position") String position)
	{	
		List<Player> result = new ArrayList<>();
		
		if (ageOver<0) throw new BadRequestException("ageOver must be >=0 but was "+ageOver+"!");
		if (ageUnder<0) throw new BadRequestException("ageUnder must be >=0 but was "+ageUnder+"!");
		
		for (Player player: repository.getAllPlayers()) {
			if ((nationality == null || player.getNationality().equals(nationality)) && (ageOver == null || player.getAge() >= ageOver) && (ageUnder == null || player.getAge() <= ageUnder) && (position == null || position.equals(player.getPosition()))) {
				result.add(player);
			}
		}
		
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Player get(@PathParam("id") String playerId)
	{
		Player player = repository.getPlayer(playerId);
		
		if (player == null) {
			throw new NotFoundException("The player with id="+ playerId +" was not found");			
		}
		
		return player;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlayer(@Context UriInfo uriInfo, Player player) {
		if (player.getName() == null || "".equals(player.getName()))
			throw new BadRequestException("The name of the player must not be null");
		
		repository.addPlayer(player);
		//repository.addPlayer(player.getTeam(), player.getId());

		// Builds the response. Returns the song the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(player.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(player);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updatePlayer(Player player) {
		Player oldPlayer = repository.getPlayer(player.getId());
		if (oldPlayer == null) {
			throw new NotFoundException("The player with id="+ player.getId() +" was not found");			
		}
		
		// Update name
		if (player.getName()!=null)
			oldPlayer.setName(player.getName());
		
		// Update description
		if (player.getSurname()!=null)
			oldPlayer.setSurname(player.getSurname());
		
		if (player.getTeam()!=null)
			oldPlayer.setTeam(player.getTeam());
		
		if (player.getNationality()!=null)
			oldPlayer.setNationality(player.getNationality());
		
		if (player.getAge()!=0)
			oldPlayer.setAge(player.getAge());
		
		if (player.getPosition()!=null)
			oldPlayer.setPosition(player.getPosition());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePlayer(@PathParam("id") String playerId) {
		Player toberemoved=repository.getPlayer(playerId);
		if (toberemoved == null)
			throw new NotFoundException("The player with id="+ playerId +" was not found");
		else
			repository.deletePlayer(playerId);
		
		return Response.noContent().build();
	}
}
