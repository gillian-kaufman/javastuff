import java.util.Random;

public class shiftcipherdecryptor
{
	public static void main(String[] args)
	{
		// Ciphertext
        String ciphertext = "fjav";
        
        // Random object for random number generator
        Random rand = new Random();
        
        // Extra variables
        char alphabet;
        int repeat = 0;
       
        // Loop to repeat entire process
        while (repeat < 1000)
        {	
        	String plaintext = "";
        	
        	//Space to print out key
            System.out.print("key: ");
            
        	// Loop to shift each letter by key amount
        	for(int i = 0; i < ciphertext.length(); i++) 
        	{
        		// Shift one character at a time
        		alphabet = ciphertext.charAt(i);
            	// Generate random number
        		int shift = rand.nextInt(26);
            	// If alphabet lies between a and z 
            	if(alphabet >= 'a' && alphabet <= 'z') 
            	{
            		// Shift alphabet
            		alphabet = (char) (alphabet - shift);
            		// If shift alphabet greater than 'z'
            		if(alphabet < 'a') 
            		{
            			// Reshift to starting position 
            			alphabet = (char) (alphabet - 'a'+'z'+1);
            		}
            		plaintext = plaintext + alphabet;
            	}
            	// If alphabet lies between 'A'and 'Z'
            	else if(alphabet >= 'A' && alphabet <= 'Z') 
            	{
            		// Shift alphabet
            		alphabet = (char) (alphabet - shift);    
                
            		// If shift alphabet greater than 'Z'
            		if(alphabet < 'A') 
            		{
            			// Reshift to starting position 
            			alphabet = (char) (alphabet - 'A'+'Z'+1);
             		}
             		plaintext = plaintext + alphabet;
            	}
            	else 
            	{
            		plaintext = plaintext + alphabet;   
            	}
            	//Print out shift key (with spaces for readability)
            	System.out.print(shift + " ");
        	}
        	// Output decrypted plaintext
        	System.out.println("\nplaintext: " + plaintext);
        	// Increment repeater
        	repeat++;
        }
	}
}