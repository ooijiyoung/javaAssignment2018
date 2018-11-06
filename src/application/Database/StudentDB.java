package application.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import application.Model.Student;


public class StudentDB {	
	ArrayList<Student> studentDB = new ArrayList <>();
	final String fileName = "Student.dat";
	Database<Student> db = new Database<Student>();
	
	public StudentDB() {
		load();
	}
	
	public void add() {
		Student std = new Student();
		System.out.println(std + " student " + std.getName());
		studentDB.add(std);
	}
	
	public void add(String name, LocalDate dob, String ic_no, String password, int parentID) {
		Student std = new Student(getNewEmptyIndex(), name, dob, ic_no, password, parentID);
		save();
	}
	
	public void load() {
		ArrayList<Student> tmpDB = (ArrayList<Student>) db.loadDB(fileName);
		if(tmpDB!=null) {
			studentDB = (ArrayList<Student>) tmpDB;
		}
	}
	
	public void save() {
		db.saveDB(fileName, studentDB);
	}
	
	public void listAllStudentDebug() {
		for(int x=0;x<studentDB.size();x++) {
			System.out.println(studentDB.get(x).getName());
		}
	}
	
	private int getNewEmptyIndex() {
		return (studentDB.size() + 1);
	}
	
	public int getLastID() {
		return studentDB.get(studentDB.size() - 1).getStdID();
	}
	


}
