package Com.Dao;

import java.sql.DriverManager;
import java.util.UUID;

import Com.Model.Submissionpojo;

public class SubmissionDao {
	
	public String submit(Submissionpojo c){
		String sql="insert into student_submission (teacher_id,student_id,id,submission_date,department,year,identity) values(?,?,?,?,?,?,?)";
	
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		java.sql.Connection con=null;
		java.sql.PreparedStatement stmt=null;
		
		String id=UUID.randomUUID().toString();
		id=id.replace("-", "");
		int rs=0;
		String submission_date=java.time.LocalDateTime.now().toString();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,username,password);

			stmt=con.prepareStatement(sql);
			stmt.setString(1, c.getTeacher_id());
			stmt.setString(2, c.getStudent_id());
			stmt.setString(3, c.getId());
			stmt.setString(4, submission_date);
			stmt.setString(5, c.getDepartment());
			stmt.setString(6, c.getYear());
			stmt.setString(7, c.getIdentity());
			
			System.out.println(stmt);
			rs=stmt.executeUpdate();
			
			
			if(rs!=0){
				return "SUCCESS";
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "something went worng please try again";
		
	}


}
