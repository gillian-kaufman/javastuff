import java.io.*;
import java.util.Scanner; 

public class testCustomerList
{
	public static void main(String[] args) throws IOException
	{	
		//Create list of customer records
		customerList list = new customerList();
		
		//Declare variables
		boolean sameCustomerNum = true, continueProgram = true;
		double balInput;
		int numInput = 0, x = 2;
		
		String firstInput, lastInput, fileName, menuSelection = "";
		Scanner input = new Scanner(System.in);
		
		//Ask for existing list 
		System.out.println("Enter list file name to import (including extension): ");
		fileName = input.nextLine();
		
		list.getCustomerList(fileName);
		
		//Edit list loop
		while(continueProgram == true)
        { 
			if (x % 2 == 0)		//Keeps menu from outputting twice
			{
				//Interface for customer list editing
				System.out.println("e: Enter new customer record\nf: Find existing customer record\nd: Delete existing customer record\ns: Save customer list and exit program\nPlease select option: ");
        	
			}
			menuSelection = input.nextLine();
			
        	switch (menuSelection)
        	{
        		//For entering a new record
        		case "e":
        			//Ask for record input
        			System.out.println("Enter customer ID number: ");
        			numInput = input.nextInt();
        			if (list.getCustomerRecord(numInput) != null)
        			{
        				while (sameCustomerNum == true)
        				{
        					System.out.println("Sorry, that number is already in use. Please enter another number: ");
        					numInput = input.nextInt();
        					if (list.getCustomerRecord(numInput) == null)
        						sameCustomerNum = false;
        				}
        			}
        			System.out.println("Enter first name: ");
        			firstInput=input.next();
        			System.out.println("Enter last name: ");
        			lastInput=input.next();
        			System.out.println("Enter intial balance: ");
        			balInput=input.nextDouble();
			 	
        			//Create new customer record
        			customerRecord newRecord = new customerRecord(numInput, firstInput, lastInput, balInput);

        			//Add record to list of records
        			list.enterCustomerRecord(newRecord);
        			System.out.println("Record successfully created.");
        			break;
        		
        		//For deleting an existing record
        		case "d":
        			//Ask for record input
        			System.out.println("Enter customer ID number to delete:  ");
        			numInput=input.nextInt();
        		
        			//Remove record from list
        			list.deleteCustomerRecord(numInput);
        			break;
        	
        		//For finding an existing record
        		case "f":
        			//Ask for record input
        			System.out.println("Enter customer ID number to find: ");
        			numInput=input.nextInt();
        		
        			//Get customer record
        			System.out.println(list.getCustomerRecord(numInput));
        			System.out.print("\n");
        			break;
        		
        		//For saving the current list
        		case "s":
        			//Get file name 
        			System.out.println("Enter name of file to save list to: ");
        			fileName = input.nextLine();
        		
        			//Save list to file
        			list.saveCustomerList(fileName);
        			System.out.println("List successfully saved.\n");
        			input.close();
        			continueProgram = false;
        			break;
        	} //End switch
        	x++;
        } //End while
	} //End main
} //End class


