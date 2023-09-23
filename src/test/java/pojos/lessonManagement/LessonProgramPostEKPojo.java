package pojos.lessonManagement;

import java.io.Serializable;

public class LessonProgramPostEKPojo implements Serializable {
	private ObjectPojoEK object;
	private String message;
	private String httpStatus;

	public LessonProgramPostEKPojo() {
	}

	public LessonProgramPostEKPojo(ObjectPojoEK object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(ObjectPojoEK object){
		this.object = object;
	}

	public ObjectPojoEK getObject(){
		return object;
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
			"LessonProgramPostEKPojo{" +
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}