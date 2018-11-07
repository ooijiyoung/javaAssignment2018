package application.Model;

public class SharedVariable {
	private int uID;
	private int quizDifficulty;
	private int quizScore;
	
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
  
  public void setQuizScore(int n) {
	  // 0 = easy, 1 = normal, 2 = hard
	  quizScore = n;
  }
  
  public int getQuizScore() {
	  return quizScore;
  }
  
  
}
