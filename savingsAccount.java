//savingsAccount is a special Account
//Account is superclass and savingsAccount is subclass

public class savingsAccount extends Account
{
	//Declare additional instance variables
	private double interestRate;
	
	public savingsAccount(double initialBal, double rate)
	{
		//balance = initialBal;
		
		//Call constructor from superclass to create balance
		super(initialBal);
		interestRate = rate;
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public void setInterestRate(double rate)
	{
		interestRate = rate;
	}
	public void printStatement()
	{
		super.printStatement();
		System.out.println(interestRate);
	}
	public String toString()
	{
		return getBalance() + " " + interestRate;
	}
}