/*	Gillian Kaufman		Spring 2020
 * 	USC Upstate			Dr. Wei Zhong
 * 	Program to emulate an interaction 
 * 	between a user and an ATM machine	*/

import java.util.Scanner;

public class ATMProgram
{
	public static void main(String[] args) 
	{
		// Declare variables
		boolean continueATM = true;
		float amount;
		int menuSelection, acctSelection, runAgain;
		Account acct1 = new Account(100.0);				// First constructor
		Account acct2 = new Account();					// Second/default constructor
		Scanner  keyboard = new Scanner(System.in);		// Scanner for user input
		
		// ATM Program loop
		while (continueATM)
		{
		// ATM menu and prompt for selection input
		System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transfer Funds");
		System.out.println("Please enter selection number: ");
		menuSelection = keyboard.nextInt();
		
		// ATM commands
			switch (menuSelection)
			{
				case 1:	// Code for checking balance of either account
					// Prompt user to choose account
					System.out.println("1. acct1\n2. acct2");
					System.out.println("Please select an account: ");	
					acctSelection = keyboard.nextInt();
					if (acctSelection == 1)
						System.out.println(acct1);
					if (acctSelection == 2)
						System.out.println(acct2);
					break;
				case 2:	// Code for depositing to either account
					// Prompt user to choose account
					System.out.println("1. acct1\n2. acct2");
					System.out.println("Please select an account: ");
					acctSelection = keyboard.nextInt();
					// Prompt for amount to deposit
					System.out.println("Amount to deposit: ");
					amount = keyboard.nextFloat();
				
					if (acctSelection == 1)
						acct1.deposit(amount);
					if (acctSelection == 2)
						acct2.deposit(amount);
					System.out.println("Amount has been successfully deposited.");
					break;
				case 3:	// Code for withdrawing from either account
					//Prompt user to choose account
					System.out.println("1. acct1\n2. acct2");
					System.out.println("Please select an account: ");	
					acctSelection = keyboard.nextInt();
					// Prompt for amount to withdraw
					System.out.println("Amount to withdraw: ");
					amount = keyboard.nextFloat();
				
					if (acctSelection == 1)
						acct1.withdraw(amount);
					if (acctSelection == 2)
						acct2.withdraw(amount);
				
					System.out.println("Amount has been successfully withdrawn.");
					break;
				case 4: // Code for transferring funds from one account to another
					//Prompt user to choose account to move money from
					System.out.println("1. acct1\n2. acct2");
					System.out.println("Please select account you wish to transfer funds from: ");	
					acctSelection = keyboard.nextInt();
					
					// Prompt for amount to move
					System.out.println("Amount to withdraw: ");		
					amount = keyboard.nextFloat();
					if (acctSelection == 1)
						acct1.withdraw(amount);
					if (acctSelection == 2)
						acct2.withdraw(amount);
					
					//Prompt user to choose account to place money into
					System.out.println("1. acct1\n2. acct2");
					System.out.println("Please select account you wish to transfer funds to: ");	
					acctSelection = keyboard.nextInt();
					if (acctSelection == 1)
						acct1.deposit(amount);
					if (acctSelection == 2)
						acct2.deposit(amount);
					System.out.println("Funds have been successfully transferred.");
					break;
				default:
					System.out.println("Error: that is not an option.");
					break;
			} // End switch
			
			//Prompt for repeating or ending ATM Program
			System.out.println("Would you like to select another option? Enter 1 for yes and 0 for no: ");
			runAgain = keyboard.nextInt();
			if (runAgain == 0)
				continueATM = false;
			else
				continueATM = true;
		} //End while
	} // End main
} //End class