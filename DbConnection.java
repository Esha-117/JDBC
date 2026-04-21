package StudentRec;
import java.sql.*;

public class DbConnection
{
	private static final String url="jdbc:mysql://localhost:3306/studentrec";
	private static final String username="root";
	private static final String pwd="Esha@2003";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,username,pwd);
	}
}
