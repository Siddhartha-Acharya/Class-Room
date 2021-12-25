package Com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Com.Model.Submissionpojo;

public class SubmissionfileuploadDao {
	
	public String update(Submissionpojo pojo)
	{
		String sql="UPDATE student_submission SET details=?,filepath=? WHERE student_id=?";
		String dburl="jdbc:mysql://localhost:3306/test";
	  	String dbname="root";
	  	String dbpass="root";
		Connection con=null;
	  	PreparedStatement stmt=null;
	  	int rs=0;
	  	 try
		  {
	  		  Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(dburl,dbname,dbpass);
				stmt=con.prepareStatement(sql);
				stmt.setString(1, pojo.getDetails());
				stmt.setString(2, pojo.getFilepath());
				stmt.setString(3, pojo.getStudent_id());
				
				System.out.println(stmt);
			    rs=stmt.executeUpdate();
			    
			    if (rs!=0)
			    {
		             return "SUCCESS";
			    }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
	  	 
		return "Something went wrong plzz try again";
	}


}
