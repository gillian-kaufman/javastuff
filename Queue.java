//Queue is first in first out data structure
//Interface will provide list of methods without the body
public interface Queue
{
	//enqueue: insert element at the end of the queue
	public void enqueue(Object item);
	
	//dequeue: remove and return element at the front of the queue
	public Object dequeue() throws EmptyQueueException;
	
	//front: return element at the front of the queue without removing it
	public Object front() throws EmptyQueueException;
	
	//size: how many elements in the queue
	public int size();
	
	//isEmpty: returns whether or not queue is empty
	public boolean isEmpty();
}