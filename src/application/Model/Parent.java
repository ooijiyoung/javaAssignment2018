package application.Model;

import java.io.Serializable;
import java.time.LocalDate;


public class Parent implements Serializable {
	private int parentID; 
	private String name;
	private LocalDate dob;
	private String contact;
	private String address;
	
	// Name, DOB, IC_No, Contact No, Address
	public Parent(int prtID, String name, LocalDate dob, String contact, String address) {
		this.parentID = prtID;
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.address = address;
	}
	
	public Parent() {
		LocalDate defaultDate = LocalDate.of(1970, 1, 1);
		name = "Default";
		dob = defaultDate;
		contact = "00";
		address = "Jalan Duta, Taman Duta";
		
	}

	public String getName() {
		return name;
	}
	
	public LocalDate getDOB() {
		return dob;
	}
	
	
	public String getContact() {
		return contact;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getID() {
		return parentID;
	}
	
}
