import java.util.*;
public class missingnum
{

	public static void main (String[] args)
	{
		int a[] = {1, 2, 3, 5};
		int i, missingnum = 0;
		for (i = 0; i < a.length; ++i)
		{
			if (a[i+1] - a[i] != 1)
			{
				missingnum = a[i] + 1;
				break;
			}
		}
		System.out.println(missingnum);
	}

}
