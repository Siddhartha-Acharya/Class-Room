package Com.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.Model.Loginpojo;
import Com.Model.idTypeBean;

public class LoginDao {
	
	public idTypeBean studentlogin(Loginpojo pojo) throws Exception
	{
		idTypeBean pojo1=new idTypeBean();
		boolean status=false;
		String sql="select * from login where username=? and password=?";
		java.sql.Connection con=null;
		java.sql.PreparedStatement stmt=null;
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
	  	ResultSet rs=null;
		  String t=null;
		  String f=null;
		  String id=null;
		try
		  {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,username,password);
				stmt = con.prepareStatement(sql);
				stmt.setString(1, pojo.getUsername());
				stmt.setString(2, pojo.getPassword());				
				rs=stmt.executeQuery();
				status=rs.next();
				
			if(status==true)
			{
				t=rs.getString("user_type");
			    id=rs.getString("user_id");
			    
			    pojo1.setType(t);
			    pojo1.setId(id);
				return pojo1;
			}	
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }
		  
		return pojo1;
		

}
}
