public class testObjectStack
{
	public static void main(String[] args)
	{
		ObjectStack stk = new ObjectStack();
		
		String[] list = {"Winter", "Spring", "Summer", "Fall"};
		
		for (int i = 0; i < 4; ++i)
		{
			stk.push(list[i]);
		}
		
		while (!stk.isEmpty())
		{
			System.out.println(stk.top());
			String s = (String)stk.pop();
			System.out.println("Size of stack: " + stk.size());
		}
		
		System.out.println("Size of stack after while loop: " + stk.size());
	}
}