package com.distribuida.dto;

import java.io.Serializable;
import java.sql.Date;




public class Singer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int version;


	
	public Singer() {
		
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


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public Singer(int id, String firstName, String lastName, Date birthDate, int version) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.version = version;
	}



	@Override
	public String toString() {
		return "Singer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", version=" + version + "]";
	}


	

	
}
