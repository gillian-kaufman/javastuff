public class findmaxdemo
{
	public static Comparable findMax(Comparable[] arr)
	{
		int maxIndex = 0;
		for (int i = 1; i < arr.length; ++i)
		{
			if (arr[i].compareTo(arr[maxIndex]) > 0)
				maxIndex = i;
		}
		return arr[maxIndex];
	}
	public static void main (String[] args)
	{
		Shape[] shapes = {new Circle("c1", 2.0), new Square("s2", 4.5), new Rectangle("r3", 3.0, 4.0)};
		System.out.println(findMax(shapes));
		
		String[] strings = {"Joe", "Bob", "Bill", "zeke"};
		System.out.println(findMax(strings));
	}
}
