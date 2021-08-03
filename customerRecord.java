public class customerRecord
{
	private int customerNum;
	private String firstName;
	private String lastName;
	private double balance;
	
	//Constructor Methods
	public customerRecord(int n, String fname, String lname, double bal)
	{
		customerNum = n;
		firstName = fname;
		lastName = lname;
		balance = bal;
	}
	
	//Name		: setCustomerNum
	//Behavior	: set the customer number
	//Parameters: an integer
	//Return	: nothing
	public void setCustomerNum(int num)
	{
		customerNum = num;
	}
	
	//Name		: getCustomerNum
	//Behavior	: get customer number from input
	//Parameters: nothing
	//Return	: an integer
	public int getCustomerNum()
	{
		return customerNum;
	}
	
	//Name		: setFirstName
	//Behavior	: set the customer first name
	//Parameters: a string
	//Return	: nothing
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	//Name		: getFirstName
	//Behavior	: get the customer first name
	//Parameters: nothing
	//Return	: a string
	public String getFirstName()
	{
		return firstName;
	}
	
	//Name		: setLastName
	//Behavior	: set the customer last name
	//Parameters: a string
	//Return	: nothing
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	//Name		: getLastName
	//Behavior	: get the customer last name
	//Parameters: nothing
	//Return	: a string
	public String getLastName()
	{
		return lastName;
	}
	
	//Name		: setBalance
	//Behavior	: set customer balance
	//Parameters: double
	//Return	: nothing
	public void setBalance(double bal)
	{
		balance = bal;
	}
	
	//Name		: getBalance
	//Behavior	: get customer balance
	//Parameters: nothing
	//Return	: a double
	public double getBalance()
	{
		return balance;
	}
	
	//Name		: toString
	//Behavior	: print out the customerRecord object
	//Parameters: nothing
	//Return	: a string
	public String toString()
	{
		String record;
		record = customerNum + " " + firstName + " " + lastName + " $" + balance;
		return record;
	}
}