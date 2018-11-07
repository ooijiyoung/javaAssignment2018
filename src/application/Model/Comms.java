package application.Model;

//Communicator Class

public class Comms {
	
  private final static Comms instance = new Comms();
  
	public static Comms getInstance() {
	    return instance;
	}

  
  private SharedVariable content = new SharedVariable();

  public SharedVariable shareVar() {
      return content;
  }
    
}
