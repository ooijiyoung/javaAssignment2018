package application.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable{
	private int stdID;
	private String name;
	private LocalDate dob;
	private String email;
	private String password;
	private int parentID; 
	
	
	public Student(int studentID, String name, LocalDate dob, String email, String password, int parentID) {
	//Name, DOB, ICNO, Password, ParentID
		this.stdID = studentID;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.parentID = parentID;
	}
	
	public Student() {
		LocalDate defaultDate = LocalDate.of(1970, 1, 1);
		name = "unammmed student";
		dob = defaultDate;
		email = "helpdesk@ooijiyoung.com";
		password = "password";
		parentID = 0;
	}

	public String getName() {
		return name;
	}
	
	public LocalDate getDOB() {
		return dob;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getStdID() {
		return stdID;
	}
	
	public int getParentID() {
		return parentID;
	}
	
	public boolean verifyPassword(String password) {
		
		if(this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
		
	}
}
