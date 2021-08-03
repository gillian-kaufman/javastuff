/* Author: Gillian Kaufman 
 * Date: September 27, 2020
 * Description: Create random numbers and input them into a file.
 * Input: N/A
 * Output: File
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IntegerFiles
{
	public static void main (String[] args)
	{
		boolean continueProgram = true;
		String input;
		Scanner scan = new Scanner(System.in);
		while (continueProgram == true)
		{
			System.out.println("Enter file name (including extension): ");
			String filename = scan.nextLine();
			// The target file
			File out = new File(filename);
			FileWriter fw = null;
			// scan.nextLine();
			System.out.println("Enter number of integers to be written: ");
			int n = scan.nextInt();
			// Try block: Most stream operations may throw IO exception
			try
			{
				// Create file writer object
				fw = new FileWriter(out);
				// Wrap the writer with buffered streams
				BufferedWriter writer = new BufferedWriter(fw);
				int line;
				Random random = new Random();
				while (n > 0)
				{
					// Randomize an integer and write it to the output file
					line = random.nextInt(200) - 100;
					writer.write(line + "\r\n");
					n--;
				}
				// Close the stream
				writer.close();
				System.out.println("File has been created.");
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.exit(0);
			}
			System.out.println("Create another file? (y/n): ");
			input = scan.next();
			if (input.contentEquals("y"))
			{
				continueProgram = true;
			}
			else
			{
				continueProgram = false;
			}
			scan.nextLine();
		}
		scan.close();
	}
}
