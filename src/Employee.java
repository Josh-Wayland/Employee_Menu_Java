/**COSC 310-002 Assignment 3
 * Employee.java
 * 
 * This class creates an employee object
 * 
 * 
 * @author Josh Wayland
 *
 */
public class Employee implements Comparable 
{
	String employeeID;
	String firstName;
	String lastName;
	double salary;
	public Employee(String employeeID, String firstName, String lastName, double salary) 
	{
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	@Override
	public String toString()
	{
		return " Employee ID= " + employeeID + ", first name= " + firstName + ", last name= " +
	               lastName + ", salary= $" +salary;
	}
	public int compareTo(Object arg0)
    {
        return employeeID.compareTo( ((Employee) arg0).employeeID );
    }
}
