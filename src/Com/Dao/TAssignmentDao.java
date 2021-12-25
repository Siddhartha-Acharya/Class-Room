package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Com.Model.CreateAssignmentModel;

public class TAssignmentDao {
	
	public ArrayList<CreateAssignmentModel> list (String id)
	{
		ArrayList<CreateAssignmentModel> a=new ArrayList<CreateAssignmentModel>();
		
		ResultSet rs=null;
		String sql="select * from test.teacherassignment t1 inner join test.teacherdetails t2 on t1.teacher_id =t2.teacher_id"; 
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
			//stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				String assignment_details=rs.getString("filename");
				String first_date_submission=rs.getString("first_date_submission");
				String last_date_submission=rs.getString("last_date_submission");
				String department=rs.getString("faculty");
				String name=rs.getString("name");
				String aid=rs.getString("id");
		
				
				
			
				
				CreateAssignmentModel bean =new CreateAssignmentModel();
				
				
				bean.setFilename(assignment_details);
				bean.setFirst_date_submission(first_date_submission);
				bean.setLast_date_submission(last_date_submission);
				bean.setFaculty(department);
				bean.setName(name);
				bean.setId(aid);
	
				
				
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
