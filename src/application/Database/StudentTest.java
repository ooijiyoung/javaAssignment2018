package application.Database;

public class StudentTest {
	public static void main(String args[]) {
		StudentDriver sd = new StudentDriver();
		sd.load();
		sd.add();
		sd.listAllStudentDebug();
		
		sd.save();
		sd.load();
		sd.listAllStudentDebug();
		sd.save();
		
	}
}
