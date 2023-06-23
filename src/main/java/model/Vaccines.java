package model;

import java.util.ArrayList;
import java.util.List;

public class Vaccines {

	static int idSeed = 1;
	private String name;
	private int id;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int totalDosesReceived;
	private int totalDosesLeft;

	public void Vaccine(String name, int dosesRequired, int daysBetweenDoses, int totalDosesReceived,
			int totalDosesLeft) {
		this.name = name;
		this.dosesRequired = dosesRequired;
		this.daysBetweenDoses = daysBetweenDoses;
		this.totalDosesReceived = totalDosesReceived;
		this.totalDosesLeft = totalDosesLeft;
		this.id = idSeed++;

	}
	
	public Vaccines() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDosesRequired() {
		return dosesRequired;
	}

	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}

	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}

	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}

	public int getTotalDosesReceived() {
		return totalDosesReceived;
	}

	public void setTotalDosesReceived(int totalDosesReceived) {
		this.totalDosesReceived = totalDosesReceived;
	}

	public int getTotalDosesLeft() {
		return totalDosesLeft;
	}

	public void setTotalDosesLeft(int totalDosesLeft) {
		this.totalDosesLeft = totalDosesLeft;
	}
	
	public static int getIdSeed() {
		return idSeed;
	}


	public static void setIdSeed(int idSeed) {
		Vaccines.idSeed = idSeed;
	}

}
