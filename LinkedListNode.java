public class LinkedListNode
{
	//Data type is Object which can be any type of java data (generic type)
	private Object data;
	private LinkedListNode next;
	
	//LinkedListNode Constructor
	public LinkedListNode(Object d)
	{
		data = d;
		next = null;
	}
	
	//Name		: getNext
	//Behavior	: get next LinkedListNode address
	//Parameters: nothing
	//Return	: a LinkedListNode
	public LinkedListNode getNext()
	{
		return next;
	}
	
	//Name		: setNext
	//Behavior	: set next LinkedListNode address
	//Parameters: LinkedListNode
	//Return	: nothing
	public void setNext(LinkedListNode a)
	{
		next = a;
	}
	
	//Name		: getData
	//Behavior	: get data object
	//Parameters: nothing
	//Return	: an Object
	public Object getData()	
	{
		return data;
	}
	
	//Name		: setData
	//Behavior	: set data object
	//Parameters: Object
	//Return	: nothing
	public void setData(Object d)
	{
		data = d;
	}
	
	//Name		: toString
	//Behavior	: print out the data object
	//Parameters: nothing
	//Return	: a string
	public String toString()
	{
		String node;
		node = data + " ";
		return node;
	}
}