package pojos.lessonManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseLPAssignPojoY implements Serializable {
	private ObjectLPAssignPojoY object;
	private String message;
	private String httpStatus;

	public void setObject(ObjectLPAssignPojoY object){
		this.object = object;
	}

	public ObjectLPAssignPojoY getObject(){
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
			"ResponseLPAssignPojoY{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}