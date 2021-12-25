package Com.Dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import Com.Model.Tassignmentuploadmodel;

public class TassignmentUploadDao {
	
	public Tassignmentuploadmodel getdetails(String id)
	{
		Tassignmentuploadmodel bean=new Tassignmentuploadmodel();
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from teacherassignment where teacher_id=?"; 
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stmt=con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			if(rs.next())
			{

				String filename=rs.getString("filename");
				String filepath=rs.getString("filepath");
	
				System.out.println(filename);
				System.out.println(filepath);
			
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

				bean.setFilename(filename);
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
