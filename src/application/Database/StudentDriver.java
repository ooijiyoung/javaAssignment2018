package application.Database;

import java.util.ArrayList;
import java.util.List;

import application.Model.Student;

public class StudentDriver {	
	ArrayList<Student> studentDB = new ArrayList <>();
	final String fileName = "Student.dat";
	int indexid;
	Database<Student> db = new Database<Student>();
	
	protected void add() {
		Student std = new Student();
		System.out.println(std + " student " + std.getName());
		try {
			studentDB.add(std);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	protected void load() {
		ArrayList<Student> tmpDB = (ArrayList<Student>) db.loadDB(fileName);
		if(tmpDB!=null) {
			studentDB = (ArrayList<Student>) tmpDB;
		}
	}
	
	protected void save() {
		db.saveDB(fileName, studentDB);
	}
	
	protected void listAllStudentDebug() {
		for(int x=0;x<studentDB.size();x++) {
			System.out.println(studentDB.get(x).getName());
		}
	}
	


}
