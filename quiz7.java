public class quiz7
{
	public static void main (String[] args)
	{
		String[][] a = diagonalSquareFlag(10);
		printMatrix(a);

		String[][] b = xSquareFlag(10);
		printMatrix(b);

		//Create matrix
		int[][] c = { { 1, 2, 0, 0 },
					  { 4, 5, 0, 0 }, 
					  { 7, 8, 0, 0 } };
		
		int[][] d = { { 1, 2, 3, 0, 0, 0 },
				  	  { 4, 5, 6, 0, 0, 0 }, 
				  	  { 7, 8, 9, 0, 0, 0 } };
		
		int[][] e = { { 1, 2, 3, 7, 0, 0, 0, 0 },
			  	  	  { 4, 5, 6, 2, 0, 0, 0, 0 }, 
			  	  	  { 7, 8, 9, 4, 0, 0, 0, 0 } };

		mirror(c);
		printMatrix2(c);

		mirror(d);
		printMatrix2(d);
		
		mirror(e);
		printMatrix2(e);
	}

	//Write class method to generate diagonal square flag (2D array of strings)
	//* * * * * * * 
	//* *         * 
	//*   *       * 
	//*     *     * 
	//*       *   * 
	//*         * * 
	//* * * * * * * 
	//Each element should store either an * and a space or two spaces
	public static String[][] diagonalSquareFlag (int n)
	{
		int i, j;
		String a = "* ";
		String b = "  ";
		String[][] newMatrix = new String[n][n];

		//Top border
		for (i = 0; i < 1; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				newMatrix[i][j] = a;
			}
		}
		//Diagonal pattern
		for (i = 1; i < n; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				if (j == 0 || j == i || j == n - 1)
				{
					newMatrix[i][j] = a;
				}
				else
				{
					newMatrix[i][j] = b;
				}
			}
		}
		//Bottom border
		for (i = n - 1; i < n; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				newMatrix[i][j] = a;
			}
		}

		return newMatrix;
	}

	//Write a class method xSquareFlag to generate square flag with two diagonals
	//(7 x 7 example)
	//* * * * * * * 
	//* *       * * 
	//*   *   *   * 
	//*     *     * 
	//*   *   *   * 
	//* *       * * 
	//* * * * * * *
	//Each element should store either an * and a space or two spaces
	public static String[][] xSquareFlag (int n)
	{
		int i, j;
		String a = "* ";
		String b = "  ";
		String[][] newMatrix = new String[n][n];
		//Top border
		for (i = 0; i < 1; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				newMatrix[i][j] = a;
			}
		}
		//X pattern
		for (i = 1; i < n; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				if (j == 0 || j == i || j == (n - i) - 1 || j == n - 1)
				{
					newMatrix[i][j] = a;
				}
				else
				{
					newMatrix[i][j] = b;
				}
			}
		}
		//Bottom border
		for (i = n - 1; i < n; ++i)
		{
			for (j = 0; j < n; ++j)
			{
				newMatrix[i][j] = a;
			}
		}

		return newMatrix;
	}

	//Given 2D array of m rows and n cols, you will copy the left side of the array
	//to the right side assuming the cols is even
	//1 2 0 0
	//5 6 0 0
	//7 8 0 0
	//After mirror
	//1 2 1 2
	//5 6 5 6
	//7 8 7 8
	//This will be general solution
	public static void mirror (int[][] a)
	{
		//Declare variables
		int i, j, k;
		//Get dimensions of input matrix
		int rows = a.length;
		int cols = a[0].length;

		//Check if cols is even
		if (cols % 2 != 0)
		{
			System.out.println("Error: number of columns must be even");
			System.exit(0);
		}
		
		//Mirror elements
		k = cols / 2;
		for (i = 0; i < rows; ++i)
		{
			for (j = 0; j < cols; ++j)
			{
				if (j < k)
				{
					a[i][j + k] = a[i][j];
				}
			}
		}
	}
	/*Matrix printing methods*/
	public static void printMatrix (String[][] a)
	{
		//Declare variables
		int i, j;
		//Get dimensions of input matrix
		int rows = a.length;
		int cols = a[0].length;
		//Print out matrix
		for (i = 0; i < rows; ++i)
		{
			for (j = 0; j < cols; ++j)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printMatrix2 (int[][] a)
	{
		//Declare variables
		int i, j;
		//Get dimensions of input matrix
		int rows = a.length;
		int cols = a[0].length;
		//Print out matrix
		for (i = 0; i < rows; ++i)
		{
			for (j = 0; j < cols; ++j)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}