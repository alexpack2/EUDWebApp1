package com.eud;

public class Member {
	private int id;
	private String name, surname, gender, birthdate, waddress, haddress;
	
	public Member() {
		super();
	}
	
	

	public Member(int id,String name, String surname, String gender, String birthdate, String waddress, String haddress) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.waddress = waddress;
		this.haddress = haddress;
	}
	
	public Member(String name, String surname, String gender, String birthdate, String waddress, String haddress) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.waddress = waddress;
		this.haddress = haddress;
	}

	public int getId() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String getWaddress() {
		return waddress;
	}



	public void setWaddress(String waddress) {
		this.waddress = waddress;
	}



	public String getHaddress() {
		return haddress;
	}



	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}



	
}
