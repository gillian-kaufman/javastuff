public class Node
{
	//Private variables
	private customerRecord data;
	private Node next;
	
	//Node Constructor Methods
	public Node(customerRecord s, Node n)
	{
		data = s;
		next = n;
	}
	
	public Node(customerRecord s)
	{
		data = s;
		next = null;
	}
	
	//Name		: getData
	//Behavior	: get data from linked list
	//Parameters: nothing
	//Return	: a customerRecord
	public customerRecord getData()
	{
		return data;
	}
	
	//Name		: getNext
	//Behavior	: get reference to next part of linked list
	//Parameters: nothing
	//Return	: a Node
	public Node getNext()
	{
		return next;
	}
	
	//Name		: setData
	//Behavior	: set data in linked list
	//Parameters: a customerRecord
	//Return	: nothing
	public void setData(customerRecord s)
	{
		data = s;
	}
	
	//Name		: setNext
	//Behavior	: set reference to next part of linked list
	//Parameters: a Node
	//Return	: nothing
	public void setNext(Node n)
	{
		next = n;
	}
}