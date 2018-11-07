package application.Model;

public class SharedVariable {
	private int uID;
	private boolean loggedIn=false;
	private int quizDifficulty;
	private int quizScore;
	private int quizNum;
	
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
  
  public void setQuizDifficulty(int n) {
	  // 0 = easy, 1 = normal, 2 = hard
	  quizDifficulty = n;
  }
  
  public int getQuizDifficulty() {
	  return quizDifficulty;
  }
  
  public void setQuizScore(int n) {
	  quizScore = n;
  }
  
  public int getQuizScore() {
	  return quizScore;
  }
  
  public void setQuizNum(int n) {
	  quizNum = n;
  }
  
  public int getQuizNum() {
	  return quizNum;
  }
  

}
