package application.Model;

import java.io.Serializable;

public class Result implements Serializable {
	private int stdID;
	private String result;
	private String diff;
	private String grade;
	
	public Result(int stdID, String result, String diff, String grade) {
		this.stdID = stdID;
		this.result = result;
		this.diff = diff;
		this.grade = grade;
	}
	
	//make your own getter and setter
	public int getStdID() {
		return stdID;
	}
	
	public String getDiff() {
		return diff;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public String getResult() {
		return result;
	}
	

}
