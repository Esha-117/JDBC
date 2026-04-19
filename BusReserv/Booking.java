package BusReserv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.SQLException;
public class Booking 
{
    String passengerName;
    int busNo;
    Date date;
    
    Booking()
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the passenger Name:");
    	passengerName=sc.nextLine();
    	System.out.println("Enter the Bus No:");
    	busNo=sc.nextInt();
    	System.out.println("Enter the date:dd-mm-yyyy");
    	String dateInput=sc.next();
    	SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
    	try
    	{
    		date=dateFormat.parse(dateInput);
    	}
    	catch(ParseException e)
    	{
    		e.printStackTrace();
    	}
    }
    public boolean isAvailable() throws SQLException
    
    {
    	BusDAO busdao=new BusDAO();
    	BookingDAO bookingdao=new BookingDAO();
    	int capacity=busdao.getCapacity(busNo);
    	
    	
    	int booked=bookingdao.getBookedCount(busNo,date);
    	
    	return booked<capacity;
    }
    
}
