public class testSavingsAccount
{
	public static void main(String[] args)
	{
		savingsAccount sa = new savingsAccount(1000, 0.1);
		sa.setInterestRate(4.25);
		
		sa.deposit(500.0);
		sa.withdraw(400.0);
		
		System.out.println("account info before closing");
		System.out.println(sa);
		sa.printStatement();
		
		sa.close();
		System.out.println("account info after closing");
		sa.printStatement();
		System.out.println(sa);
	}
}