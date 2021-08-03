import java.util.*;

public class shiftcipher
{
	public static void main(String[] args)
	{
		// Scanner for message to shift
		Scanner sc = new Scanner(System.in);
        // Prompt for message input
		System.out.println("Input the plaintext message: ");
        String plaintext = sc.nextLine();
        
        // Random object for random number generator
        Random rand = new Random();
        
        String ciphertext = "";
        char alphabet;
        
        //Space to print out key
        System.out.print("key: ");
        
        //Loop to shift each letter by key amount
        for(int i = 0; i < plaintext.length(); i++) 
        {
        	// Shift one character at a time
        	alphabet = plaintext.charAt(i);
            // Generate random number
        	int shift = rand.nextInt(26);
            // If alphabet lies between a and z 
            if(alphabet >= 'a' && alphabet <= 'z') 
            {
            	// Shift alphabet
            	alphabet = (char) (alphabet + shift);
            	// If shift alphabet greater than 'z'
            	if(alphabet > 'z') 
            	{
            		// Reshift to starting position 
            		alphabet = (char) (alphabet+'a'-'z'-1);
            	}
            	ciphertext = ciphertext + alphabet;
            }
            // If alphabet lies between 'A'and 'Z'
            else if(alphabet >= 'A' && alphabet <= 'Z') 
            {
            	// Shift alphabet
            	alphabet = (char) (alphabet + shift);    
                
            	// If shift alphabet greater than 'Z'
            	if(alphabet > 'Z') 
            	{
            		// Reshift to starting position 
            		alphabet = (char) (alphabet+'A'-'Z'-1);
             	}
             	ciphertext = ciphertext + alphabet;
            }
            else 
            {
            	ciphertext = ciphertext + alphabet;   
            }
            //Print out shift key (with spaces for easy read)
            System.out.print(shift + " ");
        }
        System.out.println("\nciphertext: " + ciphertext);
        sc.close();
	}
}