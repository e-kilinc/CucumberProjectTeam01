package pojos.lessonManagement;

import java.io.Serializable;

public class LessonResponsePojo implements Serializable {
	private ObjectPojo1 object;
	private String message;
	private String httpStatus;

	public LessonResponsePojo() {
	}

	public LessonResponsePojo(ObjectPojo1 object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(ObjectPojo1 object){
		this.object = object;
	}

	public ObjectPojo1 getObject(){
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
			"LessonResponsePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}
