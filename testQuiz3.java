public class testQuiz3
{
	public static void main (String[] args)
	{
		Valuedata data1 = new Valuedata("a", 10);
		Valuedata data2 = new Valuedata("b", 30);
		Valuedata data3 = new Valuedata("c", 80);
		
		LinkedList mylist = new LinkedList();
		
		mylist.insertBack(data1);
		mylist.insertBack(data2);
		mylist.insertBack(data3);
		
		System.out.println(mylist.removeBack());
		System.out.println(mylist.removeBack());
		System.out.println(mylist.removeBack());
	}
}