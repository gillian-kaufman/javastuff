package csci421assignment5;
import java.io.*;

public class assignment5
{
	public static void main (String[] args)
	{
		//Get strings from command line
		String x = args[1], y = args[2];
		
		//Find lengths of both strings
		int m = x.length(), n = y.length();
		
		//Create LCS matrix for finding the LCS
		int[][] LCS = new int[m + 1][n + 1];
		
		//Populate LCS matrix 
		for (int i = 0; i <= m; ++i)
		{
			for (int j = 0; j <= n; ++j)
			{
				if (i == 0 || j == 0)
				{
					LCS[i][j] = 0;
				}
				else if (x.charAt(i - 1) == y.charAt(j - 1))
				{
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				}
				else
				{
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}
		//Create LCS string 
		int index = LCS[m][n];
		char[] lcsString = new char[index + 1];
		
		//Move through the LCS matrix from bottom right to upper left recording the correct 
		//LCS string and placing each character into lcsString array backwards
		int i = m, j = n;
		while (i > 0 && j > 0)
		{
			if (x.charAt(i - 1) == y.charAt(j - 1))
			{
				//Move diagonally up and to the left
				lcsString[index - 1] = x.charAt(i - 1);
				--i;
				--j;
				--index;	
			}
			else if (LCS[i - 1][j] >= LCS[i][j - 1])
			{
				//Move up
				--i;
			}
			else
			{
				//Move left
				--j;
			}
		}
		// Print the LCS
		for(int k = 0; k <= (lcsString.length - 1); ++k)
		{
			System.out.print(lcsString[k]);
		}
	}
}

