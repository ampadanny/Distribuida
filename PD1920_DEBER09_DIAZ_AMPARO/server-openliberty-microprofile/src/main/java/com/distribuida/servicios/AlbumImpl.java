package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.dto.Album;


@ApplicationScoped
public class AlbumImpl implements IAlbum {
	@Inject
	private DataSource dataSource;

	@Override
	public List<Album> listarAlbums() throws SQLException {
		List<Album> listaAlbums = new ArrayList<Album>();
		
		String sql = "SELECT * FROM album";
		Connection con = null;
		con = dataSource.getConnection();
		Statement statement = con.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			int singerId = resulSet.getInt("singer_id");
			String title = resulSet.getString("title");
			Date releaseDate = resulSet.getDate("release_date");
			int version = resulSet.getInt("version");

			Album album = new Album(id, singerId, title,releaseDate, version);
			listaAlbums.add(album);
		}
		resulSet.close();
		statement.close();
		con.close();
		return listaAlbums;
	}

	@Override
	public Album obtenerPorId(int id) throws SQLException {
		Album album = null;

		String sql = "SELECT * FROM album WHERE id= ? ";
		Connection con = null;
		con = dataSource.getConnection();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			album = new Album(res.getInt("id"), res.getInt("singer_id"), res.getString("title"),
					res.getDate("release_date"), res.getInt("version"));
		}
		res.close();
		con.close();

		return album;
	}



}
