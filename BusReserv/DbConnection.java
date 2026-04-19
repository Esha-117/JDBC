package BusReserv;
import java.sql.*;

import java.sql.DriverManager;

public class DbConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/busReserv";
	private static final String userName="root";
	private static final String pwd="Esha@2003";

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,userName,pwd);
	}

}
