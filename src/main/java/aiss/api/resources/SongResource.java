package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.model.Playlist;
import aiss.model.Song;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;

import java.net.URI;
import java.util.Collection;



@Path("/songs")
public class SongResource {

	public static SongResource _instance=null;
	PlaylistRepository repository;
	
	private SongResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static SongResource getInstance()
	{
		if(_instance==null)
			_instance=new SongResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Song> getAll()
	{
		return repository.getAllSongs();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Song get(@PathParam("id") String songId)
	{
		
		Song list = repository.getSong(songId);
		
		if (list == null) {
			throw new NotFoundException("The playlist with id="+ songId+" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Song song) {
		if (song.getTitle() == null || "".equals(song.getTitle()))
			throw new BadRequestException("The name of the song must not be null");
		
		

		repository.addSong(song);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(song.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(song);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Song song) {
		Song oldSong= repository.getSong(song.getId());
		if (oldSong == null) {
			throw new NotFoundException("The song with id="+ song.getId() +" was not found");			
		}
		
				
		// Update name
		if (song.getTitle()!=null)
			oldSong.setTitle(song.getTitle());
		if (song.getArtist()!=null)
			oldSong.setArtist(song.getArtist());
		if (song.getAlbum()!=null)
			oldSong.setAlbum(song.getAlbum());
		if (song.getYear()!=null)
			oldSong.setYear(song.getYear());
		/* Update description
		if (song.getDescription()!=null)
			oldplaylist.setDescription(playlist.getDescription());
		*/
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String songId) {
		
		Song song = repository.getSong(songId);
		
		if (song==null)
			throw new NotFoundException("The song with id=" + songId + " was not found");
		
	
		
		
		repository.deleteSong(songId);		
		
		return Response.noContent().build();
	}
	
}