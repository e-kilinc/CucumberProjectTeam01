package pojos.lessonManagement;

import java.io.Serializable;

public class LessonError1Pojo implements Serializable {
	private String message;
	private int statusCode;
	private String path;
	private long timeStamp;
	private ValidationsPojo validations;

	public LessonError1Pojo() {
	}

	public LessonError1Pojo(String message, int statusCode, String path, long timeStamp, ValidationsPojo validations) {
		this.message = message;
		this.statusCode = statusCode;
		this.path = path;
		this.timeStamp = timeStamp;
		this.validations = validations;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}

	public long getTimeStamp(){
		return timeStamp;
	}

	public void setValidations(ValidationsPojo validations){
		this.validations = validations;
	}

	public ValidationsPojo getValidations(){
		return validations;
	}

	@Override
 	public String toString(){
		return 
			"LessonError1Pojo{" + 
			"message = '" + message + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			",path = '" + path + '\'' + 
			",timeStamp = '" + timeStamp + '\'' + 
			",validations = '" + validations + '\'' + 
			"}";
		}
}