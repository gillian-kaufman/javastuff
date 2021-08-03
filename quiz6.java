//quiz 6
//due next Tuesday

public class quiz6
{
	public static void main(String[] args)
	{
		//for this matrix only right diagonal is non-zero (reads as 352178)
		int [][] square = { {0, 0, 0, 0, 0, 3},
							{0, 0, 0, 0, 5, 0},
							{0, 0, 0, 2, 0, 0},
							{0, 0, 1, 0, 0, 0},
							{0, 7, 0, 0, 0, 0},
							{8, 0, 0, 0, 0, 0}, };
		
		System.out.println("matrix before copy: ");
		printMatrix(square);
		
		copyRightDiagonal(square);
		
		System.out.println("matrix after copy: ");
		printMatrix(square);
	}
	//copy right diagonal of matrix to its left diagonal
	public static void copyRightDiagonal(int [][] a)
	{
		//Declare variables
		int i, j, k;
		//Get dimensions of input matrix
		int rows = a.length;
		int cols = a[0].length;
		//Create new matrix matching these dimensions
		int[][] n = new int[rows][cols];

		/*Find right diagonal values and move them to the left diagonal*/
		//First, copy the left diagonal to a new matrix
		for (i = 0; i < rows; ++i)
		{
			k = 0;
			for (j = cols - 1; j >= 0; --j)
			{
				n[i][k] = a[i][j];
				++k;
			}
		}
		//Second, copy new matrix back to old matrix since this method returns nothing
		for (i = 0; i < rows; ++i)
		{
			for (j = 0; j < cols; ++j)
			{
				a[i][j] = n[i][j];
			}
		}
	}
	//print contents of matrix
	public static void printMatrix(int [][] a)
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
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}