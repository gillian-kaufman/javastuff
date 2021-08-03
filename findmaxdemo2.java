import java.util.Comparator;

public class findmaxdemo2
{
	/* Generic Static Method */
	public static <T> T findMax(T[] arr, Comparator<? super T> cmp)
	{
		int maxIndex = 0;
		for (int i = 1; i < arr.length; ++i)
		{
			if (cmp.compare(arr[i], arr[maxIndex]) > 0)
				maxIndex = i;
		}
		return arr[maxIndex];
	}
	public static void main (String[] args)
	{
		String[] strings = {"Joe", "Bob", "Bill", "zeke"};
		System.out.println(findMax(strings, new CaseInsensitiveCompare()));
		System.out.println(findMax(strings, new LenCompare()));
		
	/* Anonymous Class Alternative */
	/*	System.out.println(findMax(strings, new Comparator<String>()
		{
			public int compare(String lhs, String rhs)
			{
				return lhs.compareTo(rhs);
			}
		}));
	*/
		
	}
}
/* CaseInsensitiveCompare IS-A Comparator<String> */
class CaseInsensitiveCompare implements Comparator<String>
{
	public int compare(String lhs, String rhs)
	{
		return lhs.compareToIgnoreCase(rhs);
	}
}
/* Another Compare Method */
class LenCompare implements Comparator<String>
{
	public int compare(String lhs, String rhs)
	{
		if (lhs.length() > rhs.length())
			return 1;
		else if (lhs.length() < rhs.length())
			return -1;
		else
			return 0;
	}
}