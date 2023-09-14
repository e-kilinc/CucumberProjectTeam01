package pojos.lessonManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseLGetPojoY implements Serializable {
	private int lessonProgramId;
	private String startTime;
	private String stopTime;
	private List<LessonNamePojoY> lessonName;
	private List<Object> teachers;
	private List<Object> students;
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

	public void setTeachers(List<Object> teachers){
		this.teachers = teachers;
	}

	public List<Object> getTeachers(){
		return teachers;
	}

	public void setStudents(List<Object> students){
		this.students = students;
	}

	public List<Object> getStudents(){
		return students;
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
			"ResponseLGetPojoY{" + 
			"lessonProgramId = '" + lessonProgramId + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			",teachers = '" + teachers + '\'' + 
			",students = '" + students + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}

	public ResponseLGetPojoY() {
	}

	public ResponseLGetPojoY(int lessonProgramId, String startTime, String stopTime, List<LessonNamePojoY> lessonName, List<Object> teachers, List<Object> students, String day) {
		this.lessonProgramId = lessonProgramId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.lessonName = lessonName;
		this.teachers = teachers;
		this.students = students;
		this.day = day;
	}
}