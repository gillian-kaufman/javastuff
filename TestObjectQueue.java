//Quiz 4 part 1

public class TestObjectQueue
{
	public static void main(String[] args)
	{
		ObjectQueue myq = new ObjectQueue();
		
		Valuedata data1 = new Valuedata("a", 40);
		myq.enqueue(data1);
		
		Valuedata data2 = new Valuedata("b", 80);
		myq.enqueue(data2);
		
		Valuedata data3 = new Valuedata("c", 100);
		myq.enqueue(data3);
		
		//Printing the front and the queue size
		System.out.println((Valuedata)myq.front());
		System.out.println(myq.size());
		
		//Printing the front and queue size after removing front
		System.out.println(myq.dequeue());
		System.out.println(myq.size());
	}
}