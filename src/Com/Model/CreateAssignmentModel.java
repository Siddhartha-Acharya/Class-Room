package Com.Model;

public class CreateAssignmentModel {
	
	private String assignment_details;
	private String first_date_submission;
	private String last_date_submission;
	private String department;
	private String year;
	private String teacher_id;
	private String name;
	private String faculty;
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssignment_details() {
		return assignment_details;
	}
	public void setAssignment_details(String assignment_details) {
		this.assignment_details = assignment_details;
	}
	public String getFirst_date_submission() {
		return first_date_submission;
	}
	public void setFirst_date_submission(String first_date_submission) {
		this.first_date_submission = first_date_submission;
	}
	public String getLast_date_submission() {
		return last_date_submission;
	}
	public void setLast_date_submission(String last_date_submission) {
		this.last_date_submission = last_date_submission;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	private String id;
	private String filepath;
	private String filename;

}
