package application;

import java.io.Serializable;
import java.util.Date;

public class Student {
	private int stdID;
	private String name;
	private Date dob;
	private String ic_no;
	private String password;
	private int parentID; 
	
	public Student(String name, Date dob, String ic_no, String password, int parentID) {
		this.name = name;
		this.dob = dob;
		this.ic_no = ic_no;
		this.password = password;
		this.parentID = parentID;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDOB() {
		return dob;
	}
	
	public String getIC() {
		return ic_no;
	}
	
	public int getParentID() {
		return parentID;
	}
}
