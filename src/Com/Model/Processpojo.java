package Com.Model;

public class Processpojo {
	
	private String last_date_of_submission;
	private String status;
	private String message;
	private String tranjection_id;
	public String getTranjection_id() {
		return tranjection_id;
	}
	public void setTranjection_id(String tranjection_id) {
		this.tranjection_id = tranjection_id;
	}
	public String getLast_date_of_submission() {
		return last_date_of_submission;
	}
	public void setLast_date_of_submission(String last_date_of_submission) {
		this.last_date_of_submission = last_date_of_submission;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
