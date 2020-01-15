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

import com.distribuida.dto.Singer;


@ApplicationScoped
public class SingerImpl implements ISinger {

	@Inject
	private DataSource dataSource;
	

	@Override
	public List<Singer> listarSingers() throws SQLException {
		List<Singer> listaSingers = new ArrayList<Singer>();
		String sql = "SELECT * FROM singer";
		Connection con = null;
		con = dataSource.getConnection();
		Statement statement = con.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String firstName = resulSet.getString("first_name");
			String lastName = resulSet.getString("last_name");
			Date birthDate = resulSet.getDate("birth_date");
			int version = resulSet.getInt("version");

			Singer singer = new Singer(id, firstName, lastName, birthDate, version);
			listaSingers.add(singer);
		}
		resulSet.close();
		statement.close();
		con.close();
		return listaSingers;
	}

	@Override
	public Singer obtenerPorId(int id) throws SQLException {
		Singer singer = null;

		String sql = "SELECT * FROM singer WHERE id= ? ";
			
		Connection con = null;
		con = dataSource.getConnection();
	
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			singer = new Singer(res.getInt("id"), res.getString("first_name"), res.getString("last_name"),
					res.getDate("birth_date"), res.getInt("version"));
		}
		res.close();
		con.close();

		return singer;
	}

}
