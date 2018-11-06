package application.Model;

//Communicator Class
//Singleton

public class Comms {
  private final static Comms instance = new Comms();
  private static int quizNum=0;
  private int quizDiff=0;
  
  
  public static Comms getInstance() {
      return instance;
  }
  
  public static void setQuizNum(int num) {
  	quizNum = num;
  }
  
  public static int getQuizNum() {
  	return quizNum;
  }
  
}
