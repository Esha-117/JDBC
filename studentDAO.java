package StudentRec;

import java.sql.*;
import java.util.*;

public class studentDAO 
{
	Scanner sc = new Scanner(System.in);
	public void addStudent(Student student) throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="Insert into student values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,student.getId());
		pst.setString(2,student.getName());
		pst.setInt(3,student.getAge());
		int a=pst.executeUpdate();
		System.out.println("No of rows affected:"+a);
		pst.close();
		con.close();
	}
	
	public void displayinfo() throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="select * from student";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("Id is: "+rs.getInt(1));
			System.out.println("Name is: "+rs.getString(2));
			System.out.println("Age is: "+rs.getInt(3));
			System.out.println("------------------------------------------");
			
			
		}
		con.close();
		
	}
	
	public void searchById(int id) throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="select * from student where id="+id;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		System.out.println("Id is: "+rs.getInt(1));
		System.out.println("Name is: "+rs.getString(2));
		System.out.println("Age is: "+rs.getInt(3));
		con.close();
		
	}
	
	public boolean isAvailable(int id) throws Exception
	{
		Connection con=DbConnection.getConnection();
		String query="select * from student where id="+id;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		return rs.next();
	}
	
	public void updateName(int id,String name) throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="update student set name=? where id=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, name);
		pst.setInt(2,id);
		int a=pst.executeUpdate();
		System.out.println("the row which affected:"+a);
		con.close();

	}
	public void updateAge(int id,int age) throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="update student set age=? where id=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, age);
		pst.setInt(2,id);
		int a=pst.executeUpdate();
		System.out.println("the row which affected:"+a);
		con.close();

	}
	public void delete(int id) throws SQLException
	{
		Connection con=DbConnection.getConnection();
		String query="delete from student where id=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,id);
		int a=pst.executeUpdate();
		System.out.println("No of rows affected:"+a);
		
	}
}

