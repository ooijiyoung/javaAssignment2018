package application.Database;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import application.Interface.AlertBox;



public class Database<T> {

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
          } 
		}catch(EOFException ex) {
    	  //sometimes we create an empty file so ignore this error
      }
      catch(Exception exc){
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
		    save.flush();
		    save.close(); 
	    } catch(Exception exc){
	    		AlertBox.exceptionAlert(exc);
	    }
	}

	public void saveDB(String fileName, List<T> arrayObj) {
		fileName = dir + fileName;
		try{  
		    FileOutputStream databaseFile=new FileOutputStream(fileName);
		    ObjectOutputStream save = new ObjectOutputStream(databaseFile);
		    save.writeObject(arrayObj);
		    save.flush();
		    save.close(); 
	    } catch(Exception exc){
	    	AlertBox.exceptionAlert(exc);
	    }
		
	}

	public Database() {
		
		File directory = new File(dir);
	    if (! directory.exists()){
	        directory.mkdir();
	    }
		
	}
}
