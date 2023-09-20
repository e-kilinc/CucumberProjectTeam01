package pojos.lessonManagement;

import java.io.Serializable;

public class LessonPostPojo implements Serializable {
	private String compulsory;
	private String creditScore;
	private String lessonName;

	public LessonPostPojo() {
	}

	public LessonPostPojo(String compulsory, String creditScore, String lessonName) {
		this.compulsory = compulsory;
		this.creditScore = creditScore;
		this.lessonName = lessonName;
	}

	public void setCompulsory(String compulsory){
		this.compulsory = compulsory;
	}

	public String getCompulsory(){
		return compulsory;
	}

	public void setCreditScore(String creditScore){
		this.creditScore = creditScore;
	}

	public String getCreditScore(){
		return creditScore;
	}

	public void setLessonName(String lessonName){
		this.lessonName = lessonName;
	}

	public String getLessonName(){
		return lessonName;
	}

	@Override
 	public String toString(){
		return 
			"LessonPostPojo{" + 
			"compulsory = '" + compulsory + '\'' + 
			",creditScore = '" + creditScore + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			"}";
		}
}