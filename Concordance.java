/* Author: Gillian Kaufman 
 * Date: October 26, 2020
 * Description: Create an alphabetical list of words from a file and print out the number of occurrences for each word and on what lines each word occurs.
 * Input: Keyboard, file
 * Output: Screen
 */
import java.io.*;
import java.util.*;
import java.util.Map.Entry; 
  
public class Concordance 
{ 
    public static void main(String[] args) throws IOException 
    {
    	// Set up file to be read
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter file name including extension: ");
    	String filename = scan.nextLine();
        File file = new File(filename);
        
        // Set up reader for file
        FileInputStream fileStream = new FileInputStream(file); 
        InputStreamReader input = new InputStreamReader(fileStream); 
        BufferedReader reader = new BufferedReader(input); 
        
        // Set up variables to be used
        String line;
        int lineCount = 1;
        TreeMap<String, Identifier> concordance = new TreeMap<>();
        
        // Read the file line by line until a null is returned 
        while ((line = reader.readLine()) != null) 
        {
        	// Make the line all lower case just to make it easier for the conditionals to function
        	line = line.toLowerCase();
        	
            // Separate each word in the line into a string array (\\s+ is the space delimiter in java)
            String[] wordList = line.split("\\s+");
            
            // Remove any punctuation
            for (int i = 0; i < wordList.length; i++)
            {
            	wordList[i] = wordList[i].replaceAll("[^\\w]", "");
            }
            
            // Loop to add each word to the TreeMap
            for (int i = 0; i < wordList.length; ++i)
            {
            	// Create an identifier object
            	Identifier id = new Identifier(wordList[i], lineCount);
            	
            	// Check if word is already in the TreeMap or not
            	if (concordance.containsKey(wordList[i]))
            	{
            		// If word is found, update the identifier object's parts
            		id = concordance.get(wordList[i]);
            		id.setOccurrences();
            		id.setLineNumbers(lineCount);
            	}
            	else 
            	{
            		// If not, create identifier object and add to TreeMap
            		id = new Identifier(wordList[i], lineCount);
            		concordance.put(id.getWord(), id);
            	}
            }
            // Increment line counter variable for next run through
            ++lineCount; 
        }
        // Print out each identifier
        for (Entry<String, Identifier> entry: concordance.entrySet())
        {
        	System.out.println(entry.getValue().toString());
        }
        // Close scanners and readers
        scan.close();
        reader.close();
    }
}