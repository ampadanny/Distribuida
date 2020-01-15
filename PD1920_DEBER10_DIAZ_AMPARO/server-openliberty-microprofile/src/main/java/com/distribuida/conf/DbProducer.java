package com.distribuida.conf;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class DbProducer {

	public static final String DRIVER_CLASS = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/examen01";
	static final String USERNAME = "postgres";
	static final String PASWOORD = "0601";

	@ApplicationScoped
	@Produces 
	public DataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(DRIVER_CLASS);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASWOORD);
		return ds;
		

	}
}
