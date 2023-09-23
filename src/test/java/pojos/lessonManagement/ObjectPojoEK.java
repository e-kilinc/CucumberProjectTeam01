package pojos.lessonManagement;

import java.util.List;
import java.io.Serializable;

public class ObjectPojoEK implements Serializable {
	private int lessonProgramId;
	private String startTime;
	private String stopTime;
	private List<LessonNamePojoEK> lessonName;
	private String day;

	public ObjectPojoEK() {
	}

	public ObjectPojoEK(int lessonProgramId, String startTime, String stopTime, List<LessonNamePojoEK> lessonName, String day) {
		this.lessonProgramId = lessonProgramId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.lessonName = lessonName;
		this.day = day;
	}

	public void setLessonProgramId(int lessonProgramId){
		this.lessonProgramId = lessonProgramId;
	}

	public int getLessonProgramId(){
		return lessonProgramId;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setStopTime(String stopTime){
		this.stopTime = stopTime;
	}

	public String getStopTime(){
		return stopTime;
	}

	public void setLessonName(List<LessonNamePojoEK> lessonName){
		this.lessonName = lessonName;
	}

	public List<LessonNamePojoEK> getLessonName(){
		return lessonName;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"ObjectPojoEK{" +
			"lessonProgramId = '" + lessonProgramId + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}