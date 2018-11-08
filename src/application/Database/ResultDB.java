package application.Database;
import java.util.ArrayList;

import application.Model.Parent;
import application.Model.Result;
public class ResultDB {
	
	ArrayList<Result> resultDB = new ArrayList <>();
	final String fileName = "Parent.dat";
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
	
}
