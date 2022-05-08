package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String id;
	private String name;
	private String league;
	private List<Player> players;
	
	
	
	public Team(String name) {
		this.name = name;
	}
	
	protected void setPlayers(List<Player> p) {
		players = p;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league= league;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(String id) {
		if (players==null) {
			return null;
		}
		Player player =null;
		for(Player p: players)
			if (p.getId().equals(id))
			{
				player=p;
				break;
			}
		
		return player;
	}
	
	public void addPlayer(Player p) {
		if (players==null) {
			players = new ArrayList<Player>();}
		players.add(p);
	}
	
	public void deletePlayer(Player p) {
		players.remove(p);
	}
	
	public void deleteSong(String id) {
		Player p = getPlayer(id);
		if (p!=null)
			players.remove(p);
	}

}
