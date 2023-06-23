package model;

import java.util.Date;

public class Patients {

	static int idSeed = 1;
	private int id;
	private String peopleName;
	private Vaccines givenVaccine;
	private Date firstDate;
	private Date secondDate;
	private int vaccineId;

	public void Patients(String name, Vaccines theirVaccine, Date dayOne, Date dayTwo) {

		this.id = idSeed++;
		this.peopleName = name;
		this.givenVaccine = theirVaccine;
		this.firstDate = dayOne;
		this.secondDate = dayTwo;
	}

	public Patients() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public Vaccines getGivenVaccine() {
		return givenVaccine;
	}

	public void setGivenVaccine(Vaccines givenVaccine) {
		this.givenVaccine = givenVaccine;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

}
