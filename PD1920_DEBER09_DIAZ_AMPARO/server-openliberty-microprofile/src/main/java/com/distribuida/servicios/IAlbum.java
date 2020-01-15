package com.distribuida.servicios;

import java.sql.SQLException;
import java.util.List;

import com.distribuida.dto.Album;



public interface IAlbum {


	public List<Album> listarAlbums() throws SQLException;
	public Album obtenerPorId(int id) throws SQLException;
	
}
