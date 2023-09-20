package pojos.lessonManagement;

import java.io.Serializable;

public class ValidationsPojo implements Serializable {
	private String lessonName;

	public ValidationsPojo() {
	}

	public ValidationsPojo(String lessonName) {
		this.lessonName = lessonName;
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
			"ValidationsPojo{" + 
			"lessonName = '" + lessonName + '\'' + 
			"}";
		}
}