package Com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.SApprovepojo;

public class SApproveDao {
	
	public ArrayList<SApprovepojo> list() 
	{
		ArrayList<SApprovepojo> a=new ArrayList<SApprovepojo>();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select student_id,book_name,book_id,tranjection_id,status,apply_date  from student_lib  where status = 'approved' "; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				String student_id=rs.getString("student_id");
				String book_name=rs.getString("book_name");
				String book_id=rs.getString("book_id");
				String tranjection_id=rs.getString("tranjection_id");
				String status=rs.getString("status");
				String apply_date=rs.getString("apply_date");
				
			
				
				SApprovepojo bean =new SApprovepojo();
				
				bean.setStudent_id(student_id);
				bean.setBook_name(book_name);
				bean.setBook_id(book_id);
				bean.setTranjection_id(tranjection_id);
				bean.setStatus(status);
				bean.setApply_date(apply_date);
				
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
