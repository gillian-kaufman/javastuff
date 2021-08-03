import java.io.*;
import java.util.Scanner;

public class customerList
{
	//Private variables
	private Node head;
	
	//customerList Constructor Method
	public customerList()
	{
		head = null;
	}
	
	//Name		: getCustomerList
	//Behavior	: read file and create list
	//Parameters: name of file (string)
	//Return	: nothing
	public void getCustomerList(String filename) throws IOException
	{
		Scanner scan = new Scanner(new File(filename));
		
		//Iterate through the file rows and place contents into respective variables
		while (scan.hasNext())
		{
			int n = scan.nextInt();
			String firstName = scan.next();
			String lastName = scan.next();
			double bal = scan.nextDouble();
			
			customerRecord cr = new customerRecord(n, firstName, lastName, bal);
			enterCustomerRecord(cr);
		}
		scan.close();
	}
	
	//Name		: getCustomerRecord
	//Behavior	: get new customer record
	//Parameters: an integer
	//Return	: customerRecord
	public customerRecord getCustomerRecord(int customerNum)
    {
		Node current = head;
		while(current != null)
		{
			if (current.getData().getCustomerNum() == customerNum)
			{
				return current.getData();
			}
        	current = current.getNext();
        }
      	return null;
    }
	
	//Name		: enterCustomerRecord
	//Behavior	: add new record to list
	//Parameters: customerRecord
	//Return	: nothing
	public void enterCustomerRecord(customerRecord record)
	{
		//Build Node
		Node v = new Node(record);
		
		if (head == null)
			head = v;
		else
		{
			v.setNext(head);
			head = v;
		}
	}
	
	//Name		: deleteCustomerRecord
	//Behavior	: delete a customer record from the list
	//Parameters: an integer
	//Return	: nothing
	public void deleteCustomerRecord(int customerNum)
	{
		Node current = head;
		Node previous = null;
		
		//Search for target Node
		while ((current != null) && (current.getData().getCustomerNum() != customerNum))
		{
			previous = current;
			current = current.getNext();
		}
		//If target Node was not found
		if (current == null)
		{
			System.out.println("Record could not be found.\n");
			return;
		}
		//If target Node is the first Node in the list
		if (previous == null)
		{
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
			temp = null;
			System.out.println("Record successfully deleted.\n");
		}
		else
		{
			previous.setNext(current.getNext());
			current.setNext(null);
			current = null;
			System.out.println("Record successfully deleted.\n");
		}
	}
		
	//Name		: saveCustomerList
	//Behavior	: saves updated records to new file
	//Parameters: name of file
	//Return	: nothing
	public void saveCustomerList(String filename) throws IOException
	{
		PrintWriter out = new PrintWriter(filename);
		Node current = head;
		
		while (current != null)
		{
			out.println(current.getData().toString());
			current = current.getNext();
		}
		out.close();
	}
}