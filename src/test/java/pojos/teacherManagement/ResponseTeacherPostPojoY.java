package pojos.teacherManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseTeacherPostPojoY implements Serializable {
	private ResTeObjectPojoY object;
	private String message;
	private String httpStatus;

	public void setObject(ResTeObjectPojoY object){
		this.object = object;
	}

	public ResTeObjectPojoY getObject(){
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
			"ResponseTeacherPostPojoY{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}

	public ResponseTeacherPostPojoY() {
	}

	public ResponseTeacherPostPojoY(ResTeObjectPojoY object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}