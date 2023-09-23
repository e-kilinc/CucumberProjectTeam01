package pojos.lessonManagement;

import java.io.Serializable;

public class LessonGetPojo implements Serializable {
	private ObjectPojoLessonGet object;
	private String message;

	public LessonGetPojo() {
	}

	public LessonGetPojo(ObjectPojoLessonGet object, String message) {
		this.object = object;
		this.message = message;
	}

	public void setObject(ObjectPojoLessonGet object){
		this.object = object;
	}

	public ObjectPojoLessonGet getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"LessonGetPojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}