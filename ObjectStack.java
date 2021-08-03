//ObjectStack will borrow some methods from LinkedList class

public class ObjectStack extends LinkedList implements stack
{
	//Number of elements in the stack
	private int size;
	
	//Constructor 
	public ObjectStack()
	{
		//Calls constructor from superclass
		super();
	}
	//push: use insertFront to implement push
	public void push(Object myData)
	{
		insertFront(myData);
		++size;
	}
	//pop: use removeFront to implement pop
	//before removing, check for empty stack
	public Object pop() throws EmptyStackException
	{
		if (!isEmpty())
		{
			--size;
			Object data = removeFront();
			return data;
		}
		else
			throw new EmptyStackException("Pop method - stack is empty");
		
	}
	//top: use getHead() to implement top
	//check for empty stack
	public Object top() throws EmptyStackException
	{
		
		if (!isEmpty())
		{
			Object data = getHead().getData();
			return data;
		}
		else
			throw new EmptyStackException("Top method - stack is empty");
	}
	
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public int size()
	{
		return size;
	}
}