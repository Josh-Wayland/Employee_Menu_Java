/**COSC 310-002 Assignment 3
 * EmpMenu.java
 * 
 * This class creates a menu and 
 * gives different options to choose
 * from
 * 
 * @author Josh Wayland
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class EmpMenu 
{
	String employeeID;
	String firstName;
	String lastName;
	double salary;
	Scanner inFile = null;
	Scanner input = new Scanner(System.in);
	SLList<Employee> list = new SLList<Employee>();
	// open file
		public EmpMenu()
		{
			try
	        {
	        	inFile = new Scanner( new File ( "employee.txt"));
	        }
	        catch( FileNotFoundException e )
	        {
	            System.out.println( "Error: File not found" );
	            System.exit(1);
	        }
	        
	        // read file
	        while( inFile.hasNext() )
	        {
	            String record = inFile.nextLine();  // read up to new line
	            String[] tokens = record.split( ",[ ]*" );
	            
	            employeeID = tokens[0];
	            firstName = tokens[1];
	            lastName = tokens[2];
	            salary = Double.parseDouble(tokens[3]);
	            Employee employee = new Employee(employeeID, 
	            		firstName, lastName,
	            		salary);
	            list.add(employee);
	        }
	        inFile.close();
		}
		
		public void display()
		{
			int option = displayMenu();
			while( option != 0 )
	          {
				// process menu selection
				switch( option )
				{
				case 1:
					for(int i = 0; i < list.size(); i++)
					{
						System.out.println(list.get(i));
					}
					break;
				case 2:
					System.out.println("Employee ID: ");
					employeeID = input.next();
					System.out.println("First name: ");
					firstName = input.next();
					System.out.println("Last name: ");
					lastName = input.next();
					System.out.println("Salary: $");
					salary = input.nextDouble();
					Employee emp = new Employee(employeeID, firstName
							, lastName, salary);
					list.add(emp);
					break;
				case 3:
					System.out.println("Enter employee ID: ");
					employeeID = input.next();
					Employee e = new Employee(employeeID, firstName
							, lastName, salary);
					if(list.indexOf(e) != -1)
					{
						System.out.println(list.get
								(list.indexOf(e)));
					}
					else
						System.out.println("Employee not found");
					break;
				case 0:
					System.exit(1);
				default:
					System.out.println("Invalid selection");
				}
				option = displayMenu();
			}
			System.out.println("Done");
		}
		private int displayMenu()
		{
			System.out.println( );
			System.out.println("Employee Menu");
			System.out.println("-------------");
			System.out.println("  1. Display employees");
			System.out.println("  2. Add employee");
			System.out.println("  3. Find employee");
			System.out.println("  0. Exit");
			System.out.print("Enter number: ");
			Scanner input = new Scanner(System.in);
			return input.nextInt();
		}
}
