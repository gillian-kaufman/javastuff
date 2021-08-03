public class quiz5
{
	public static void main(String[] args)
	{
		String a = "abstract window     toolkit";
		String b = capitalizeWords(a);	//Abstract Window    Toolkit
		
		String c = "i have   a   dream";
		String d = capitalizeWords(c);	//I Have    A    Dream
	}
	
	//given a string you will return a new string with the first letter of each word capitalized
	//use for loop as well as common string methods
	public static String capitalizeWords(String s)
	{
		char capLetter, buf;
		int i, size = s.length();
		
		//Creates character array to change specific letters to uppercase
		char[] letters = s.toCharArray();
		
		for (i = 0; i < size; i++)
		{
			if (i == 0)
			{
				buf = letters[i];
				capLetter = Character.toUpperCase(buf);
				letters[i] = capLetter;
				++i;
			}
			if (letters[i - 1] == ' ')
		 	{
				buf = letters[i];
				capLetter = Character.toUpperCase(buf);
				letters[i] = capLetter;
			}
		}
		String convert = new String(letters);
		System.out.println(convert);
		return convert;
	}
}