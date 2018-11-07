package application.Model;

public class SharedVariable {
	private int uID;
	private boolean loggedIn=false;
	
  public void setID(int n) {
  	uID = n;
  }
  
  public int getID() {
  	return uID;
  }
  
  public void setLoggedIn() {
  	loggedIn = true;
  }
  
  public boolean isLoggedIn() {
  	return loggedIn;
  }
  
}
