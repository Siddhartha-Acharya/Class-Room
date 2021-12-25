package Com.Dao;

import java.sql.DriverManager;
import java.util.UUID;

import Com.Model.Loginpojo;

public class StudentRegDao {
	
	public String registration(Loginpojo c){
		String sql="insert into studentdetails (username,password,name,department,year,registration_no,semail,student_id) values(?,?,?,?,?,?,?,?)";
		String sql1="insert into login(username,password,user_id,user_type) values(?,?,?,?)";
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="root";
		java.sql.Connection con=null;
		java.sql.PreparedStatement stmt=null;
		java.sql.PreparedStatement stmt1=null;
		String id=UUID.randomUUID().toString();
		id=id.replace("-", "");
		int rs=0;
		int rs1=0;
		String s="Teacher";
		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url,username,password);

			stmt=con.prepareStatement(sql);
			stmt.setString(1, c.getUsername());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getName());
			stmt.setString(4, c.getDepartment());
			stmt.setString(5, c.getYear());
			stmt.setString(6, c.getRegistration_no());
			stmt.setString(7, c.getSemail());
			stmt.setString(8, id);
			System.out.println(stmt);
			rs=stmt.executeUpdate();
			
			stmt1=con.prepareStatement(sql1);
			stmt1.setString(1, c.getUsername());
			stmt1.setString(2, c.getPassword());
			stmt1.setString(3, id);
			stmt1.setString(4,s);
		    System.out.println(stmt1);
			rs1=stmt1.executeUpdate();
			
			if(rs!=0 && rs1!=0){
				return "SUCCESS";
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "something went worng please try again";
		
	}


}
