package Com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

import Com.Model.RequestBookpojo;

public class RequestBookDao {
	
	public String check(RequestBookpojo pojo) 
	{
		String sql="INSERT INTO student_lib (student_id, book_id,apply_date,status, tranjection_id, book_name) VALUES(?,?,?,?,?,?)";
		String dburl="jdbc:mysql://localhost:3306/test";
	  	String dbname="root";
	  	String dbpass="root";
		Connection con=null;
	  	PreparedStatement stmt=null;
		int rs;
		String id=UUID.randomUUID().toString();
		id=id.replace("-", "");
		
		String date=java.time.LocalDateTime.now().toString();
		
		try
	  	{
			
		  		Class.forName("com.mysql.jdbc.Driver");
		  		con=DriverManager.getConnection(dburl,dbname,dbpass);
		  		stmt=con.prepareStatement(sql);
		  		stmt.setString(1, pojo.getStudent_id());
		  		stmt.setString(2, pojo.getBook_id());
		  		stmt.setString(3, date);
		  		stmt.setString(4, "Under Process");
		  		stmt.setString(5, id);
		  		stmt.setString(6, pojo.getBook_name());
				System.out.println(stmt);
				rs=stmt.executeUpdate();
				if (rs>0)
			    {
					return "success";
			    }	
	  	}
	  	catch(Exception e)
	  	{
	  		System.out.println(e);
	  	}
		return "failed";
	}


}
