package application.Model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private int stdID;
	private String name;
	private Date dob;
	private String ic_no;
	private String password;
	private int parentID; 
	
	
	public Student(int studentID, String name, Date dob, String ic_no, String password, int parentID) {
	//Name, DOB, ICNO, Password, ParentID
		this.stdID = studentID;
		this.name = name;
		this.dob = dob;
		this.ic_no = ic_no;
		this.password = password;
		this.parentID = parentID;
	}
	
	public Student() {
		name = "unammmed student";
		dob = new Date();
		ic_no = "000000000000";
		password = "password";
		parentID = 0;
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
