package application.Model;

import java.io.Serializable;
import java.util.Date;

public class Parent {
	private int parentID; 
	private String name;
	private Date dob;
	private String ic_no;
	private String contact;
	private String address;
	
	// Name, DOB, IC_No, Contact No, Address
	public Parent(String name, Date dob, String ic_no, String contact, String address) {
		this.name = name;
		this.dob = dob;
		this.ic_no = ic_no;
		this.contact = contact;
		this.address = address;
	}
	
	public Parent() {
		name = "Default";
		dob = new Date();
		ic_no = "00";
		contact = "00";
		address = "Jalan Duta, Taman Duta";
		
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
	
	public String getContact() {
		return contact;
	}
	
	public String getAddress() {
		return address;
	}
	
}
