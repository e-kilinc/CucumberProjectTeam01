package pojos.lessonManagement;

import java.io.Serializable;

public class ResponseDelPojoY implements Serializable {
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
			"ResponseDelPojoY{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}

	public ResponseDelPojoY() {
	}

	public ResponseDelPojoY(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

}