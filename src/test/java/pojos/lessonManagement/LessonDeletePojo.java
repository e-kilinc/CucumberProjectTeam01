package pojos.lessonManagement;

import java.io.Serializable;

public class LessonDeletePojo implements Serializable {
	private String message;
	private String httpStatus;

	public LessonDeletePojo() {
	}

	public LessonDeletePojo(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setHttpStatus(String httpStatus){
		this.httpStatus = httpStatus;
	}

	public String getHttpStatus(){
		return httpStatus;
	}

	@Override
 	public String toString(){
		return 
			"LessonDeletePojo{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}