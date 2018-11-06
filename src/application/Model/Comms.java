package application.Model;

//Communicator Class
//Singleton

public class Comms {
  private final static Comms instance = new Comms();

  public static Comms getInstance() {
      return instance;
  }
  
  
}
