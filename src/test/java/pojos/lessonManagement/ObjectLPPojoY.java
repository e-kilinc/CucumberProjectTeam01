package pojos.lessonManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ObjectLPPojoY implements Serializable {
	private int lessonProgramId;
	private String startTime;
	private String stopTime;
	private List<LessonNamePojoY> lessonName;
	private String day;

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

	public void setLessonName(List<LessonNamePojoY> lessonName){
		this.lessonName = lessonName;
	}

	public List<LessonNamePojoY> getLessonName(){
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
			"ObjectPojo{" +
			"lessonProgramId = '" + lessonProgramId + '\'' +
			",startTime = '" + startTime + '\'' +
			",stopTime = '" + stopTime + '\'' +
			",lessonName = '" + lessonName + '\'' +
			",day = '" + day + '\'' +
			"}";
		}

	public ObjectLPPojoY() {
	}

	public ObjectLPPojoY(int lessonProgramId, String startTime, String stopTime, List<LessonNamePojoY> lessonName, String day) {
		this.lessonProgramId = lessonProgramId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.lessonName = lessonName;
		this.day = day;
	}
}