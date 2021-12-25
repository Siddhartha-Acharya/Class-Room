package Com.Dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import Com.Model.Submissionimagepojo;
import Com.Model.TImagepojo;

public class SubmissionimageDao {
	
	public Submissionimagepojo getSubmit(String id)
	{
		Submissionimagepojo bean=new Submissionimagepojo();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select details,filepath from student_submission where student_id=?"; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			if(rs.next())
			{

				
				String details=rs.getString("details");
				String filepath=rs.getString("filepath");
				
			
				InputStream inputStream = new FileInputStream(filepath);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				byte[] imageBytes = outputStream.toByteArray();
				 
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				inputStream.close();
				outputStream.close();

				
				bean.setDetails(details);
				bean.setFilepath(filepath);
				bean.setBase64Image(base64Image);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return bean;
	}


}
