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

import com.distribuida.dto.Singer;
import com.distribuida.servicios.ISinger;


@Path ("/singers")
@ApplicationScoped
public class ServicioSingerRest {

	@Inject private ISinger singerService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingers() throws SQLException {

		List<Singer> singers = singerService.listarSingers();
			Singer[] arraySingers = new Singer[singers.size()];
			 arraySingers = singers.toArray(arraySingers);
			  
			 if (!singers.isEmpty()) {

					return Response.ok(arraySingers).build();
				} else {
					return Response.status(Response.Status.NOT_FOUND).build();
				}

		
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSinger(@PathParam("id") int id) throws SQLException {

		Singer singer = singerService.obtenerPorId(id);

		if (singer.getId() != 0) {
			return Response.ok(singer).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	
}