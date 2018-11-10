package application.Database;
import java.util.ArrayList;
import application.Model.Result;

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
	
	public boolean isEmpty() {
		boolean empty = true;
		int count = 0;
		if(resultDB.size() != 0) {
			while(count != resultDB.size()) {
				
				count++;
			}
		}
		
		return empty;
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
	
	public ArrayList<Result> selectResultWhereDiff(String diff) {
		ArrayList<Result> tmpAsList = new ArrayList<Result>();
		for (int x = 0; x < resultDB.size(); x++) {
			if (resultDB.get(x).getDiff().equals(diff)) {
				tmpAsList.add(resultDB.get(x));
			}
		}
		
		return tmpAsList;
	}
	
	public void listAllDebug() {
		for (int x = 0; x < resultDB.size(); x++) {
			System.out.println(x + ": " + resultDB.get(x).getStdID() + " " + resultDB.get(x).getGrade() + " "
					+ resultDB.get(x).getResult() + " " + resultDB.get(x).getDiff());
		}
	}
}
