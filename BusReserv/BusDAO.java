package BusReserv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class BusDAO 
{
	public void displayBusInfo() throws SQLException
	{
		String query="select * from bus";
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("Bus No: " + rs.getInt(1));
			if(rs.getInt(2)==0)
				System.out.println("AC: No");
			else
				System.out.println("AC: No");
			System.out.println("Capacity: "+rs.getInt(3));
				
		}
		System.out.println("--------------------------------------------------");
	}

	public int getCapacity(int id) throws SQLException
	{
		String query ="Select * from bus where id="+id;
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
