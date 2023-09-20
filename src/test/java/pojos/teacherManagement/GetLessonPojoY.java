package pojos.teacherManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetLessonPojoY implements Serializable {
	private int lessonId;
	private String lessonName;
	private int creditScore;
	private boolean compulsory;

	public void setLessonId(int lessonId){
		this.lessonId = lessonId;
	}

	public int getLessonId(){
		return lessonId;
	}

	public void setLessonName(String lessonName){
		this.lessonName = lessonName;
	}

	public String getLessonName(){
		return lessonName;
	}

	public void setCreditScore(int creditScore){
		this.creditScore = creditScore;
	}

	public int getCreditScore(){
		return creditScore;
	}

	public void setCompulsory(boolean compulsory){
		this.compulsory = compulsory;
	}

	public boolean isCompulsory(){
		return compulsory;
	}

	@Override
 	public String toString(){
		return 
			"LessonPojoY{" + 
			"lessonId = '" + lessonId + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			",creditScore = '" + creditScore + '\'' + 
			",compulsory = '" + compulsory + '\'' + 
			"}";
		}

	public GetLessonPojoY() {
	}

	public GetLessonPojoY(int lessonId, String lessonName, int creditScore, boolean compulsory) {
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.creditScore = creditScore;
		this.compulsory = compulsory;
	}
}