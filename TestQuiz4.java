//Quiz 4 part 2

public class TestQuiz4 
{
	// reverse string using stack "abcd" to "dcba"
	public static void main(String[] args) 
	{
		String a = "abcd";
		String b = reverseString(a);

		System.out.println(b);
	}

	public static String reverseString(String a) 
	{
		String answer = "";
		ObjectStack data = new ObjectStack();
		int size = a.length();

		char[] convert = a.toCharArray();
		
		for (int i = size - 1; i >= 0; --i) 
		{
			data.push(convert[i]);
			answer += (data.top());
		}
		return answer;
	}
}