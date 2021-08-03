public class Account
{
	private double balance;
	
	public Account(double initialBal)
	{
		balance = initialBal;
	}
	public Account()
	{
		balance = 0.0;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double amount)
	{
		balance = amount;
	}
	public void deposit(double amount)
	{
		balance += amount;
	}
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	public void close()
	{
		balance = 0.0;
	}
	public void printStatement()
	{
		System.out.println(balance);
	}
}