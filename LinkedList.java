public class LinkedList
{
	private LinkedListNode head;
	
	//LinkedList Constructor
	public LinkedList()
	{
		head = null;
	}
	//Name		: getHead
	//Behavior	: get head of list
	//Parameters: nothing
	//Return	: a LinkedListNode
	public LinkedListNode getHead()
	{
		return head;
	}
	//Name		: setHead
	//Behavior	: set head of list
	//Parameters: a LinkedListNode
	//Return	: nothing
	public void setHead(LinkedListNode a)
	{
		head = a;
	}
	//Name		: insertFront
	//Behavior	: add node in front of list
	//Parameters: an Object
	//Return	: nothing
	public void insertFront(Object a)
	{
		//Create Node for list
		LinkedListNode v = new LinkedListNode(a);
		
		if (head == null)
			head = v;		//Inserts new node into list if list is empty
		else
		{					
			v.setNext(head);	//Sets next to the head of the list and replaces head with new node
			head = v;
		}
	}
	//Name		: removeFront
	//Behavior	: Remove first node from list
	//Parameters: nothing
	//Return	: an Object
	public Object removeFront()
	{
		//Check if list is empty
		if (head == null)
		{
			System.out.println("Error: List is empty.");
			return null;
		}
		else
		{
			Object mydata = head.getData();
			head = head.getNext();	//Change head to next node
			return mydata;		//Return data contents of node
		}
		
	}
	//Name		: insertBack
	//Behavior	: add node to back of list
	//Parameters: an Object
	//Return	: nothing	
	public void insertBack(Object myData) {
		LinkedListNode v = new LinkedListNode(myData);

		if (head == null) 
		{
			head = v;
		} 
		else 
		{
			LinkedListNode current = head;
			//Iterate to the end of the list
			while (current.getNext() != null) 
			{
				current = current.getNext();
			}
			//Set the end node's next to the address of node to be added
			current.setNext(v);
		}
	}
	//Name		: removeBack
	//Behavior	: Remove last node from list
	//Parameters: nothing
	//Return	: an Object
	public Object removeBack() 
	{
		//Check if list is empty
		if (head == null) 
		{
			System.out.println("Error: List is empty.");
			return null;
		}
		else if (head.getNext() == null)		//only one node in list
		{
			LinkedListNode current = head;
			head = null;
			return current.getData();
		}
		else
		{
			LinkedListNode current = head;
			//Iterate to the end of the list (stops at second to last node)
			while (current.getNext().getNext() != null) 
			{
				current = current.getNext();
			}
			LinkedListNode node = current.getNext();		//Last node of list
	        current.setNext(null);
	        return node.getData();
		}

	}

}