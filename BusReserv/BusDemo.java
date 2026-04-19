package BusReserv;
import java.sql.SQLException;
import java.util.*;

public class BusDemo {

	public static void main(String[] args) 
	{
		
		BusDAO busdao=new BusDAO();
		try {
		busdao.displayBusInfo();
		
        Scanner sc =new Scanner(System.in);
		int userOpt=1;
		
		while(userOpt==1)
		{
			System.out.println("Enter 1 to Book and 2 to Exit");
			userOpt=sc.nextInt();
			if(userOpt==1)
			{
				Booking booking=new Booking();
				if(booking.isAvailable())
				{
                    BookingDAO bookingdao=new BookingDAO();
                    bookingdao.addBooking(booking);
					System.out.println("Your Booking is Confirmed");
				}
				else
				{
					System.out.println("Sorry..Bus is Full..Try another Bus or Date..");
				}
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
