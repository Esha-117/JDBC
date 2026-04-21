package StudentRec;

import java.sql.*;
import java.util.*;


public class StudMain {

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		boolean loop=true;
		try{
		while(loop)
		{
			System.out.println("Choose the one option from below:");
			System.out.println("-----------------------------------");
			System.out.println("Enter 1 to add a student");
			System.out.println("Enter 2 to view all students");
			System.out.println("Enter 3 to search a student by id");
			System.out.println("Enter 4 to update a student");
			System.out.println("Enter 5 to delete a student");
			System.out.println("Enter 6 to exit");
			System.out.println("-----------------------------------");
			
			int userOpt=sc.nextInt();
			//Student student = new Student();
			studentDAO studentdao = new studentDAO();
			
			switch(userOpt)
			{
			case 1:
			{
				System.out.println("Enter id: ");
				int id=sc.nextInt();
				System.out.println("Enter name: ");
				String name=sc.next();
				System.out.println("Enter age: ");
				int age=sc.nextInt();
				studentdao.addStudent(new Student(id,name,age));
				break;
			}
			case 2:
			{
				studentdao.displayinfo();
				break;
			}
			case 3:
			{
				System.out.println("Enter id: ");
				int id=sc.nextInt();
				studentdao.searchById(id);
				break;
			}
			case 4:
			{
				System.out.println("Give the id of the student you need to update");
				int id=sc.nextInt();
				if(studentdao.isAvailable(id))
				{
					System.out.println("Please enter the field you need to update : Name/Age/Both");
					String field=sc.next();
					if(field.equalsIgnoreCase("Name"))
					{
						System.out.println("Enter the name you want to update:");
						String name=sc.next();
						studentdao.updateName(id,name);
					}
					else if(field.equalsIgnoreCase("Age"))
					{
						System.out.println("Enter the age you want to update:");
						int age=sc.nextInt();
						studentdao.updateAge(id,age);
					}
					else if(field.equalsIgnoreCase("Both"))
					{
						System.out.println("Enter the name you want to update:");
						String name=sc.next();
						studentdao.updateName(id,name);
						System.out.println("Enter the age you want to update:");
						int age=sc.nextInt();
						studentdao.updateAge(id,age);
					}
					
				}
				else
				{
					System.out.println("Sorry..The given id is not present..");
				}
				
				break;
				
			}
			case 5:
			{
				System.out.println("Enter the id you want to delete: ");
				int id=sc.nextInt();
				studentdao.delete(id);
				break;
			}
			case 6:
			{
				System.out.println("\t Thank You!");
				sc.close();
				loop=false;
				break;
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
