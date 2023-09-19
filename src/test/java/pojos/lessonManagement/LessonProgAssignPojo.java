package pojos.lessonManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class LessonProgAssignPojo implements Serializable {
	private List<String> lessonProgramId;
	private String teacherId;

	public void setLessonProgramId(List<String> lessonProgramId){
		this.lessonProgramId = lessonProgramId;
	}

	public List<String> getLessonProgramId(){
		return lessonProgramId;
	}

	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}

	public String getTeacherId(){
		return teacherId;
	}

	@Override
 	public String toString(){
		return 
			"LessonProgAssignPojo{" + 
			"lessonProgramId = '" + lessonProgramId + '\'' + 
			",teacherId = '" + teacherId + '\'' + 
			"}";
		}

	public LessonProgAssignPojo() {
	}

	public LessonProgAssignPojo(List<String> lessonProgramId, String teacherId) {
		this.lessonProgramId = lessonProgramId;
		this.teacherId = teacherId;
	}
}