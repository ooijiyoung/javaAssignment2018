package application.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import application.Model.Student;

public class Database {
	
	//
	public <T> T loadDB(String FileName){
		T returnObj = null;
		try{
      File OurDatabase = new File(FileName);
          if(!OurDatabase.exists()) {
          	OurDatabase.createNewFile();
          } 
          else{ //only try to load database if only exist
          FileInputStream databaseFile = new FileInputStream(FileName);
          ObjectInputStream obj = new ObjectInputStream(databaseFile);

          returnObj =  (T) obj.readObject();

          obj.close();
          } // 
      }
      catch(Exception exc){
      	//TODO: implement error message
         //error dont do anything, just keep quiet (either database file empty or cannot load)
      	//screw the user anyway. 
    }
		
		return returnObj;
		
		
	}
	
	
}
