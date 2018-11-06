package application.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import application.Model.Student;

public class StudentDriver {
	int indexid;
	ArrayList<Student> StudentDB = new ArrayList <Student>();
	
	
  @SuppressWarnings("unchecked")
	public void dbLoad(){
    try{
        File studentDB = new File("studentDB.dat");
            if(!studentDB.exists()) {
            	studentDB.createNewFile();
            } 
            else{ //only try to load database if only exist
            FileInputStream databaseFile = new FileInputStream("studentDB.dat");
            ObjectInputStream save = new ObjectInputStream(databaseFile);

            StudentDB = (ArrayList<Student> ) save.readObject();

            save.close();
            } // 
        }
        catch(Exception exc){
        	//TODO: implement error message
           //error dont do anything, just keep quiet (either database file empty or cannot load)
        	//screw the user anyway. 
	    }
	}
}
