package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.Scheckpojo;

public class ScheckDao {
	

	public ArrayList<Scheckpojo> list (String id)
	{
		ArrayList<Scheckpojo> a=new ArrayList<Scheckpojo>();
		
		ResultSet rs=null;
		String sql="select student_id,book_name,book_id,tranjection_id,status,apply_date, message  from student_lib where status='declined' and student_id=?"; 
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		java.sql.Connection con=null;
		java.sql.PreparedStatement stmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String student_id=rs.getString("student_id");
				String book_name=rs.getString("book_name");
				String book_id=rs.getString("book_id");
				String tranjection_id=rs.getString("tranjection_id");
				String status=rs.getString("status");
				String apply_date=rs.getString("apply_date");
				String message=rs.getString("message");
				
				
			
				
				Scheckpojo bean =new Scheckpojo();
				
				
				bean.setStudent_id(student_id);
				bean.setBook_name(book_name);
				bean.setBook_id(book_id);
				bean.setTranjection_id(tranjection_id);
				bean.setStatus(status);
				bean.setApply_date(apply_date);
				bean.setMessage(message);
				
				a.add(bean);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return a;

}
}
