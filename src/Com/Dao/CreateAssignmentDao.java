package Com.Dao;

import Com.Model.CreateAssignmentModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.UUID;

public class CreateAssignmentDao {
	
	public String upload(CreateAssignmentModel c) throws ParseException{
		
		String sql="insert into teacherassignment (first_date_submission,last_date_submission,teacher_id,id,filename,filepath) values(?,?,?,?,?,?)";
		
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		Connection con=null;
		PreparedStatement stmt=null;
		String firstdate=java.time.LocalDateTime.now().toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdf.parse(firstdate));
		c1.add(Calendar.DATE, 7);
		String lastdate = sdf.format(c1.getTime());
		
		String id=UUID.randomUUID().toString();
		id=id.replace("-", "");
		int rs=0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,username,password);

			stmt=con.prepareStatement(sql);
			
			stmt.setString(1, firstdate);
			stmt.setString(2, lastdate);
			
			
			stmt.setString(3, c.getTeacher_id());
			stmt.setString(4, id);
			stmt.setString(5, c.getFilename());
			stmt.setString(6, c.getFilepath());
			
			System.out.println(stmt);
			rs=stmt.executeUpdate();
			
			
			if(rs!=0){
				return "SUCCESS";
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "try again";
		
	}

	private java.util.Date Date() {
		// TODO Auto-generated method stub
		return null;
	}

	private Date firstdate() {
		// TODO Auto-generated method stub
		return null;
	}

}
