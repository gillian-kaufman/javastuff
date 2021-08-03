public class TestList
{
	public static void main(String[] args)
	{
		Valuedata v1 = new Valuedata("a", 5);
		Valuedata v2 = new Valuedata("b", 10);
		Valuedata v3 = new Valuedata("c", 19);
		
		LinkedList myList = new LinkedList();
		
		myList.insertFront(v1);
		myList.insertFront(v2);
		myList.insertFront(v3);
		
		//since removeFront returns Object type, we need to cast Object type into Valuedata type
		Valuedata v4 = (Valuedata)myList.removeFront();
		System.out.println(v4);
		
	}
}