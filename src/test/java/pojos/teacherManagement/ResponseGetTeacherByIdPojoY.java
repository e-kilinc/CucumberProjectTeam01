package pojos.teacherManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseGetTeacherByIdPojoY implements Serializable {
	private GetObjectPojoY object;
	private String message;
	private String httpStatus;

	public void setObject(GetObjectPojoY object){
		this.object = object;
	}

	public GetObjectPojoY getObject(){
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
			"ResponseGetTeacherByIdPojoY{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}

	public ResponseGetTeacherByIdPojoY() {
	}

	public ResponseGetTeacherByIdPojoY(GetObjectPojoY object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}



}