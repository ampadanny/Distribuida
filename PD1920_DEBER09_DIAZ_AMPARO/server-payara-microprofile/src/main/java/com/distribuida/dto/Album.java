package com.distribuida.dto;

import java.io.Serializable;
import java.sql.Date;



public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int singerId;
	private String title;
	private Date releaseDate;
	private int version;



	public Album() {

	}


	public Album(int id, int singerId, String title, Date releaseDate, int version) {
	
		this.id = id;
		this.singerId = singerId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.version = version;
	}





	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return "Album [id=" + id + ", singerId=" + singerId + ", title=" + title + ", releaseDate=" + releaseDate
				+ ", version=" + version + "]";
	}



	
}
