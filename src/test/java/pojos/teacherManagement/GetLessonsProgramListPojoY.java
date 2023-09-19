package pojos.teacherManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class GetLessonsProgramListPojoY implements Serializable {
	private int id;
	private String day;
	private String startTime;
	private String stopTime;
	private List<GetLessonPojoY> lesson;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
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

	public void setLesson(List<GetLessonPojoY> lesson){
		this.lesson = lesson;
	}

	public List<GetLessonPojoY> getLesson(){
		return lesson;
	}

	@Override
 	public String toString(){
		return 
			"LessonsProgramListPojoY{" + 
			"id = '" + id + '\'' + 
			",day = '" + day + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",lesson = '" + lesson + '\'' + 
			"}";
		}

	public GetLessonsProgramListPojoY() {
	}

	public GetLessonsProgramListPojoY(int id, String day, String startTime, String stopTime, List<GetLessonPojoY> lesson) {
		this.id = id;
		this.day = day;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.lesson = lesson;
	}



}