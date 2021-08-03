public class reverse
{
	public static void Rev(String str, int i)
	{

		 if(str.length() == 0) 
		 { 
			 return; 
		 } 
		 rev(str.substring(1)); 
		 System.out.print(str); 

	}
	public static void rev(String str)
	{
		if(str.length() == 0) 
	    { 
	        return; 
	    } 
	    rev(str.substring(1)); 
	    System.out.print(str); 
	}
	/* Driver program to test above function */
	public static void main()
	{
	    String a = "your mum gae";
	    rev(a);
	}
}