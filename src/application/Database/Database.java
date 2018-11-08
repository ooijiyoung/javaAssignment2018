package application.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import application.Interface.AlertBox;



public class Database<T> {
	//final String dir = "../application/Resources/Databases/";
	String dir ="database/";
	
	public List<T> loadDB(String fileName){
		fileName = dir + fileName;
		
		List<T> returnObj = null;
		try{
      File OurDatabase = new File(fileName);
          if(!OurDatabase.exists()) {
          	OurDatabase.createNewFile();
          } 
          else{ //only try to load database if only exist
          FileInputStream databaseFile = new FileInputStream(fileName);
          ObjectInputStream obj = new ObjectInputStream(databaseFile);

          returnObj =  (List<T>) obj.readObject();

          obj.close();
          } // 
      }
      catch(Exception exc){
      	//TODO: implement error message
         //error dont do anything, just keep quiet (either database file empty or cannot load)
      	//screw the user anyway. 
      	AlertBox.exceptionAlert(exc);
    }
		
		return returnObj;
		
		
	}
	
	public void saveDB(String fileName, T object) {
		fileName = dir + fileName;
    try{  
	    FileOutputStream databaseFile=new FileOutputStream(fileName);
	    ObjectOutputStream save = new ObjectOutputStream(databaseFile);
	    save.writeObject(object);
	    save.close(); 
    } catch(Exception exc){
        exc.printStackTrace();
    }
	}

	public void saveDB(String fileName, List<T> arrayObj) {
		fileName = dir + fileName;
		try{  
	    FileOutputStream databaseFile=new FileOutputStream(fileName);
	    ObjectOutputStream save = new ObjectOutputStream(databaseFile);
	    save.writeObject(arrayObj);
	    save.close(); 
    } catch(Exception exc){
    	exc.printStackTrace();
    }
		
	}

	public Database() {
		
		File directory = new File(dir);
    if (! directory.exists()){
        directory.mkdir();
    }
		
	}
}
