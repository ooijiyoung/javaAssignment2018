package application.Database;

import java.time.LocalDate;
import java.util.ArrayList;

import application.Interface.AlertBox;
import application.Model.Parent;

public class ParentDB {
	ArrayList<Parent> parentDB = new ArrayList <>();
	final String fileName = "Parent.dat";
	Database<Parent> db = new Database<Parent>();
	
	public ParentDB() {
		load();
	}
	
	public void add() {
		Parent prt = new Parent();
		parentDB.add(prt);
	}
	

	public void add(String name, LocalDate dob, String contact, String address) {
		Parent prt = new Parent(getNewEmptyIndex(), name, dob, contact,address);
		parentDB.add(prt);
		save();
	}
	
	public int getLastID() {
		return parentDB.get(parentDB.size() - 1).getID();
	}
	
	public void load() {
		try {
			ArrayList<Parent> tmpDB = (ArrayList<Parent>) db.loadDB(fileName);
			if(tmpDB!=null) {
				parentDB = (ArrayList<Parent>) tmpDB;
				
			}
		}catch(Exception ex) {
			AlertBox.exceptionAlert(ex, "An Error Occurred While Loading Database File \"Parent.dat\"\n"
					+ "Database file might be corrupted, please remove the file and retry.");
		}
		
	}
	
	public void save() {
		db.saveDB(fileName, parentDB);
	}
	
	public void listAllDebug() {
		for(int x=0;x<parentDB.size();x++) {
			System.out.println(parentDB.get(x).getID() + " " + parentDB.get(x).getName());
		}

	}
	
	public void updateParentProfileByID(int id, String contact, String address) {
		parentDB.get((id-1)).setAddress(address);
		parentDB.get((id-1)).setContact(contact);
		save();
	}
	
	private int getNewEmptyIndex() {
		return (parentDB.size() + 1);
	}
	
	public Parent selectParentWhereID(int prtID) {
		return parentDB.get((prtID-1));
	}

	

}
