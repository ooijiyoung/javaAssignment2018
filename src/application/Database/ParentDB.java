package application.Database;

import java.util.ArrayList;

import application.Model.Parent;

public class ParentDB {
	ArrayList<Parent> parentDB = new ArrayList <>();
	final String fileName = "Parent.dat";
	int indexid=0;
	Database<Parent> db = new Database<Parent>();
	
	public void add() {
		Parent prt = new Parent();
		System.out.println(prt + " student " + prt.getName());
		parentDB.add(prt);
		indexid ++ ;
	}
	
	public void load() {
		ArrayList<Parent> tmpDB = (ArrayList<Parent>) db.loadDB(fileName);
		if(tmpDB!=null) {
			parentDB = (ArrayList<Parent>) tmpDB;
			indexid = parentDB.size();
		}
	}
	
	public void save() {
		db.saveDB(fileName, parentDB);
	}
	
	public void listAllStudentDebug() {
		for(int x=0;x<parentDB.size();x++) {
			System.out.println(parentDB.get(x).getName());
		}
	}
	
	private int getNewEmptyIndex() {
		return (parentDB.size() + 1);
	}
	

}
