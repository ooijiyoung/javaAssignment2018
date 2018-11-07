package application.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import application.Model.Parent;

public class ParentDB {
	ArrayList<Parent> parentDB = new ArrayList <>();
	final String fileName = "Parent.dat";
	Database<Parent> db = new Database<Parent>();
	
	public ParentDB() {
		load();
	}
	
	public void add() {
		//debug purpose
		Parent prt = new Parent();
		System.out.println(prt + " student " + prt.getName());
		parentDB.add(prt);
	}
	

	public void add(String name, LocalDate dob, String ic_no, String contact, String address) {
		Parent prt = new Parent(getNewEmptyIndex(), name,dob,ic_no,contact,address);
		parentDB.add(prt);
		save();
	}
	
	public int getLastID() {
		return parentDB.get(parentDB.size() - 1).getID();
	}
	
	public void load() {
		ArrayList<Parent> tmpDB = (ArrayList<Parent>) db.loadDB(fileName);
		if(tmpDB!=null) {
			parentDB = (ArrayList<Parent>) tmpDB;
			
		}
	}
	
	public void save() {
		db.saveDB(fileName, parentDB);
	}
	
	public void listAllDebug() {
		for(int x=0;x<parentDB.size();x++) {
			System.out.println(parentDB.get(x).getName());
		}
	}
	
	private int getNewEmptyIndex() {
		return (parentDB.size() + 1);
	}
	
	public Parent selectParentWhereID(int prtID) {
		return parentDB.get((prtID-1));
	}

	

}
