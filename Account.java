// Class declaration
public class Account
{	// Instance variable declaration
	private double balance;
	
	// Constructor declaration
	// initializes the value of instance variable
	public Account (double initialBalance)
	{
		balance = initialBalance;
	}
	//Second constructor
	public Account () 
	{
		balance = 0;
	}
	
	// Instance method declaration
	// void is the return type for the method
	public void deposit (double amount)
	{
		balance += amount;
	}
	public void withdraw (double amount)
	{
		balance -= amount;
	}
	public double checkBalance ()
	{
		return balance;
	}
	
	// toString is used to convert contents 
	// of object into String format
	public String toString ()
	{
		return "balance: " + balance;
		//String concatenation
	}
} // End class
	


