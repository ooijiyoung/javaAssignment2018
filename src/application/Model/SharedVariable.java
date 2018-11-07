package application.Model;

public class SharedVariable {
	private int uID;
	private int quizDifficulty;
	
  public void setID(int n) {
  	uID = n;
  }
  
  public int getID() {
  	return uID;
  }
  
  public void setQuizDifficulty(int n) {
	  // 0 = easy, 1 = normal, 2 = hard
	  quizDifficulty = n;
  }
  
  public int getQuizDifficulty() {
	  return quizDifficulty;
  }
}
