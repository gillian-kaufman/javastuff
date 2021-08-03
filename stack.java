//interface provides a list of methods without its body

public interface stack
{
	//push: add new element to the top of the stack
	public void push(Object myData);
	
	//pop: remove top element of stack
	//check if stack is empty before pop
	//exception is any type of run time error
	//return any type of Object
	public Object pop() throws EmptyStackException;
	
	//top: returns top element of stack without removing it
	//before top, you need to check if stack is empty
	public Object top() throws EmptyStackException;
	
	//size: returns number of elements in stack
	public int size();
	
	//isEmpty: whether or not stack is empty
	public boolean isEmpty();
}