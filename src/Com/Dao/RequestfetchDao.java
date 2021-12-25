package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.Requestfetchpojo;

public class RequestfetchDao {
	
	public ArrayList<Requestfetchpojo> list ()
	{
		ArrayList<Requestfetchpojo> a=new ArrayList<Requestfetchpojo>();
		
		ResultSet rs=null;
		String sql="select s.student_id,s.name,s.department,s.year,s.registration_no ,sl.book_name ,sl.book_id ,sl.tranjection_id ,sl.status from student_lib sl inner join studentdetails s"; 
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
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String student_id=rs.getString("student_id");
				String name=rs.getString("name");
				String department=rs.getString("department");
				String year=rs.getString("year");
				String registration_no=rs.getString("registration_no");
				
				
				String book_name=rs.getString("book_name");
				String book_id=rs.getString("book_id");
				String tranjection_id=rs.getString("tranjection_id");
				String status=rs.getString("status");
				
				
			
				
				Requestfetchpojo bean =new Requestfetchpojo();
				
				
				bean.setStudent_id(student_id);
				bean.setName(name);
				bean.setDepartment(department);
				bean.setYear(year);
				bean.setRegistration_no(registration_no);
				
				bean.setBook_name(book_name);
				bean.setBook_id(book_id);
				bean.setTranjection_id(tranjection_id);
				bean.setStatus(status);
				
				
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
