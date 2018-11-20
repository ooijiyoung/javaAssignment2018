package application.Database;

import java.time.LocalDate;
import java.util.ArrayList;

import application.Interface.AlertBox;
import application.Model.Student;

public class StudentDB {
	ArrayList<Student> studentDB = new ArrayList<>();
	final String fileName = "Student.dat";
	Database<Student> db = new Database<Student>();

	public StudentDB() {
		load();
	}

	public void add() {
		// testing one
		Student std = new Student();
		studentDB.add(std);
	}

	public void add(String name, LocalDate dob, String email, String password, int parentID) {
		Student std = new Student(getNewEmptyIndex(), name, dob, email, password, parentID);
		studentDB.add(std);
		save();
	}

	public void load() {
		try {
			ArrayList<Student> tmpDB = (ArrayList<Student>) db.loadDB(fileName);
			if (tmpDB != null) {
				studentDB = (ArrayList<Student>) tmpDB;
			}
		}catch(Exception ex) {
			AlertBox.exceptionAlert(ex, "An Error Occurred While Loading Database File \"Student.dat\"\n"
					+ "Database file might be corrupted, please remove the file and retry.");
		}
	
	}

	public void save() {
		db.saveDB(fileName, studentDB);
	}

	public void listAllStudentDebug() {
		for (int x = 0; x < studentDB.size(); x++) {
			System.out.println(
					studentDB.get(x).getStdID() + " " + studentDB.get(x).getName() + " " + studentDB.get(x).getEmail());
		}
	}

	private int getNewEmptyIndex() {
		return (studentDB.size() + 1);
	}

	public int getLastID() {
		return studentDB.get(studentDB.size() - 1).getStdID();
	}

	public int selectStdIDFromEmail(String email) {
		int stdID = 0;
		for (int x = 0; x < studentDB.size(); x++) {
			if (studentDB.get(x).getEmail().equals(email)) {
				stdID = studentDB.get(x).getStdID();
			}
		}
		return stdID;
	}

	public boolean isPwdCorrectFromStdID(int stdID, String password) {
		return studentDB.get((stdID - 1)).verifyPassword(password);
	}

	public Student selectStudentWhereID(int stdID) {
		return studentDB.get((stdID - 1));
	}

}
