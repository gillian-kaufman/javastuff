import java.util.*;

/* Author: Gillian Kaufman 
 * Date: October 26, 2020
 * Description: Create an object to manage the identifier, number of occurrences, and list of line numbers.
 * Input: N/A
 * Output: N/A
 */
public class Identifier
{
	private String word;
	private int occurrences;
	private TreeSet<Integer> lineNumbers = new TreeSet<Integer>();
	
	/* Author: Gillian Kaufman
	 * Purpose: Constructor method for creating the Identifier object
	 * Input: a string, an integer
	 * Output: N/A
	 */
	public Identifier (String w, int i)
	{
		word = w;
		occurrences = 1;
		lineNumbers.add(i);
	}
	
	/* Author: Gillian Kaufman
	 * Purpose: Method for retrieving the word 
	 * Input: N/A
	 * Output: a string
	 */
	public String getWord ()
	{
		return word;
	}

	/* Author: Gillian Kaufman
	 * Purpose: Method for retrieving the numer of occurrences 
	 * Input: N/A
	 * Output: an integer
	 */
	public int getOccurrences ()
	{
		return occurrences;
	}

	/* Author: Gillian Kaufman
	 * Purpose: Method for retrieving the list of line numbers in string form
	 * Input: N/A
	 * Output: a string
	 */
	public String getLineNumbers ()
	{
		String lineNums = lineNumbers.toString();
		return lineNums.substring(1, lineNums.length() - 1);
	}

	/* Author: Gillian Kaufman
	 * Purpose: Method for setting the word 
	 * Input: a string
	 * Output: N/A
	 */
	public void setWord (String word)
	{
		this.word = word;
	}

	/* Author: Gillian Kaufman
	 * Purpose: Method for setting the number of occurrences 
	 * Input: an integer
	 * Output: N/A
	 */
	public void setOccurrences ()
	{
		this.occurrences++;
	}

	/* Author: Gillian Kaufman
	 * Purpose: Method for setting the list of line numbers 
	 * Input: a string
	 * Output: N/A
	 */
	public void setLineNumbers (int i)
	{
		this.lineNumbers.add(i);
	}
	/* Author: Gillian Kaufman
	 * Purpose: Method for printing out the Identifier object 
	 * Input: N/A
	 * Output: a string
	 */
	public String toString()
	{
		return this.word + " occurs " + this.occurrences + " times on line " + this.getLineNumbers();
	}
}
