package application.Database;

import java.util.ArrayList;

import application.Model.Student;

public class StudentDB {	
	ArrayList<Student> studentDB = new ArrayList <>();
	final String fileName = "Student.dat";
	int indexid=0;
	Database<Student> db = new Database<Student>();
	
	public void add() {
		Student std = new Student();
		System.out.println(std + " student " + std.getName());
		studentDB.add(std);
		indexid ++ ;
	}
	
	public void load() {
		ArrayList<Student> tmpDB = (ArrayList<Student>) db.loadDB(fileName);
		if(tmpDB!=null) {
			studentDB = (ArrayList<Student>) tmpDB;
			indexid = studentDB.size();
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
	


}
