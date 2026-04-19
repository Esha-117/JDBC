import java.sql.*;

public class JDBCDemo {


	public static void main(String[] args) throws Exception 
	{
		//readRecords();
		//insertRecords();
		//insertUsingPst();
		//delete();
		//update(); 
		//sp2();
		//commitdemo();
		batchdemo();
	}
	
	public static void readRecords() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    String query="select * from employee";
		
		
/*connection is an interface which cannot be instantiated(create a object) coz it only has def not implementation 
 * DriverManager is a class getConnection is a method we have to pass url username and pwd
 * Statement is a object*/
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
 /*poniter will point at column name so we need to move the pointer to first rec 
  * 1,2,3 is column number*/
        while(rs.next())
        {
        	System.out.println("Id is "+rs.getInt(1));
        	System.out.println("Name is "+rs.getString(2));
        	System.out.println("Salary is "+rs.getInt(3));
        }
        con.close();
	}
	
	public static void insertRecords() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    String query="insert into employee values (4,'Mikasa',100000)";
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        
        System.out.println("No of rows affected:"+rows);
        
        con.close();
	}
	public static void insertUsingPst() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    int id=5;
	    String name="Levi";
	    int salary=100000;
	    String query="insert into employee values (?,?,?)";
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,id);
        pst.setString(2, name);
        pst.setInt(3, salary);
        int rows=pst.executeUpdate();
        
        
        System.out.println("No of rows affected:"+rows);
        
        con.close();
	}
	public static void delete() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    int id=2;
	    
	    String query="delete from employee where emp_id=" + id;
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        
        System.out.println("No of rows affected:"+rows);
        
        con.close();
	}
	public static void update() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    String query="update employee set salary = 15000 where emp_id=1";
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
        Statement st=con.createStatement();
        int rows=st.executeUpdate(query);
        
        System.out.println("No of rows affected:"+rows);
        
        con.close();
	}
	public static void sp() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    Connection con = DriverManager.getConnection(url,userName,pwd);
	    CallableStatement cst=con.prepareCall("{call getEmp()}");
	    ResultSet rs=cst.executeQuery();
	    
	    while(rs.next())
	    {
	    	System.out.println("Id is "+rs.getInt(1));
        	System.out.println("Name is "+rs.getString(2));
        	System.out.println("Salary is "+rs.getInt(3));
	    }
	    
	    con.close();
	}
	//calling stored procedure by in param
	public static void sp1() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    int id=3;
	    
	    
	    Connection con = DriverManager.getConnection(url,userName,pwd);
	    CallableStatement cst=con.prepareCall("{call getEmpById(?)}");
	    cst.setInt(1, id);  
	    ResultSet rs=cst.executeQuery();
	    
	    while(rs.next())
	    {
	    	System.out.println("Id is "+rs.getInt(1));
        	System.out.println("Name is "+rs.getString(2));
        	System.out.println("Salary is "+rs.getInt(3));
	    }
	    
	    con.close();
	}
	//calling stored procedure by both in and out param
	public static void sp2() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    int id=3;
	    
	    
	    Connection con = DriverManager.getConnection(url,userName,pwd);
	    CallableStatement cst=con.prepareCall("{call getNameById(?,?)}");
	    cst.setInt(1, id);  
	    cst.registerOutParameter(2,Types.VARCHAR);
	    
	    cst.executeUpdate();
	    System.out.println(cst.getString(2));
	    
	    
	    con.close();
	}
	//commit vs autocommit
	public static void commitdemo() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    String query1="update employee set salary = 550000 where emp_id=1";
	    String query2="update employee set salary = 500000 where emp_id=2";
	    
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		con.setAutoCommit(false);
        Statement st=con.createStatement();
        int rows1=st.executeUpdate(query1);
        
        System.out.println("No of rows affected:"+rows1);
        
        int rows2=st.executeUpdate(query2);
        
        System.out.println("No of rows affected:"+rows2);
        
        if(rows1>0 && rows2>0)
        {
        	con.commit();
        }
        
        
        con.close();
	}
	public static void batchdemo() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
	    String userName="root";
	    String pwd="Esha@2003";
	    
	    String query1="update employee set salary = 40000 where emp_id=1";
	    String query2="update employee set salary = 40000 where emp_id=2";
	    String query3="update employee set salary = 40000 where emp_id=3";
	    String query4="update employee set salary = 40000 where emp_id=4";
	    
		
		
		Connection con = DriverManager.getConnection(url,userName,pwd);
		con.setAutoCommit(false);
        Statement st=con.createStatement();
        st.addBatch(query1);
        st.addBatch(query2);
        st.addBatch(query3);
        st.addBatch(query4);
        
        int[] res=st.executeBatch();
        for(int i:res)
        {
        	if(i>0)
        	    continue;
        	else
        		con.rollback();
        }
        
        con.commit();
        con.close();
	}
	
	
	

	    

}
