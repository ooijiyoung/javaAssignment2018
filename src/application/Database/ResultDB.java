package application.Database;
import java.time.LocalDate;
import java.util.ArrayList;
import application.Model.Result;
import application.Model.Student;

public class ResultDB {
	
	ArrayList<Result> resultDB = new ArrayList <>();
	final String fileName = "Results.dat";
	Database<Result> db = new Database<Result>();
	
	public ResultDB() {
		load();
	}
	
	public void load() {
		ArrayList<Result> tmpDB = (ArrayList<Result>) db.loadDB(fileName);
		if(tmpDB!=null) {
			resultDB = (ArrayList<Result>) tmpDB;
			
		}
	}
	
	public void save() {
		db.saveDB(fileName, resultDB);
	}
	
	public void add(int stdID, String result, String diff, String grade) {
		Result results = new Result(stdID, result, diff, grade);
		resultDB.add(results);
		save();
	}
	
	public ArrayList<Result> selectResultWhereStdID(int stdID) {
		ArrayList<Result> tmpAsList = new ArrayList<Result>();
		for (int x = 0; x < resultDB.size(); x++) {
			if (resultDB.get(x).getStdID() == stdID) {
				tmpAsList.add(resultDB.get(x));
			}
		}
		
		return tmpAsList;
	}
	
}
