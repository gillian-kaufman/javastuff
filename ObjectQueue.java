//Quiz 4 part 1

public class ObjectQueue extends LinkedList implements Queue
{
	private int size;
	
	public ObjectQueue()
	{
		super();
	}
	
	//enqueue: insert element at the end of the queue
	public void enqueue(Object item)
	{
		insertBack(item);
		++size;
	}
		
		//dequeue: remove and return element at the front of the queue
	public Object dequeue() throws EmptyQueueException
	{
		if (!isEmpty())
		{
			--size;
			Object data = removeFront();
			return data;
		}
		else
			throw new EmptyQueueException("Queue is empty");
	}
	
	//front: return element at the front of the queue without removing it
	public Object front() throws EmptyQueueException
	{
		if(!isEmpty())
		{
			Object data = getHead().getData();
			return data;
		}
		else
			throw new EmptyQueueException("Queue is empty");
		
	}
		
	//size: how many elements in the queue
	public int size()
	{
		return size;
	}
		
	//isEmpty: returns whether or not queue is empty
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}
}