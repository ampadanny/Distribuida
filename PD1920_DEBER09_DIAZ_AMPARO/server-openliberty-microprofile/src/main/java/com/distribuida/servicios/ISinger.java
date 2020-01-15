package com.distribuida.servicios;

import java.sql.SQLException;
import java.util.List;

import com.distribuida.dto.Singer;



public interface ISinger {

	public List<Singer> listarSingers() throws SQLException;
	public Singer obtenerPorId(int id) throws SQLException;
	
}
