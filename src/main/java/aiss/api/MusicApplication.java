package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.GameResource;
import aiss.api.resources.LeagueResource;
import aiss.api.resources.PlayerResource;
import aiss.api.resources.TeamResource;


public class MusicApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public MusicApplication() {

		singletons.add(TeamResource.getInstance());
		singletons.add(PlayerResource.getInstance());
		singletons.add(GameResource.getInstance());
		singletons.add(LeagueResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
