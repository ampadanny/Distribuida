package com.distribuida.rest;


import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.dto.Album;
import com.distribuida.servicios.IAlbum;

@Path("/albums")
@ApplicationScoped
public class ServicioAlbumRest {

	@Inject
	private IAlbum albumService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlbums() throws SQLException {

		List<Album> albums = albumService.listarAlbums();
		Album[] arrayAlbums = new Album[albums.size()];
		arrayAlbums = albums.toArray(arrayAlbums);

		if (!albums.isEmpty()) {

			return Response.ok(arrayAlbums).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAlbum(@PathParam("id") int id) throws SQLException {

		Album album = albumService.obtenerPorId(id);

		if (album.getId() != 0) {
			return Response.ok(album).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}


}
