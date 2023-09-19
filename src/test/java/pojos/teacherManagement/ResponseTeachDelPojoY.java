package pojos.teacherManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseTeachDelPojoY implements Serializable {
	private String message;
	private String httpStatus;

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
			"ResponseTeachDelPojoY{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}

	public ResponseTeachDelPojoY() {
	}

	public ResponseTeachDelPojoY(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}
}