/* Author: Gillian Kaufman 
 * Date: September 27, 2020
 * Description: Test four different algorithms for finding the maximum contiguous subsequence sum.
 * Input: Keyboard, file
 * Output: Screen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class MaxSumTest
{
	// Subsequence start and end variables 
	static private int seqStart = 0;
	static private int seqEnd = -1;

	/* Author: Mark A. Weiss
	 * Purpose: Cubic maximum contiguous subsequence sum algorithm. seqStart and seqEnd
	 * represent the actual best sequence.
	 * Input: an integer array
	 * Output: an integer
	 */
	public static int maxSubSum1 (int[] a)
	{
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
			for (int j = i; j < a.length; j++)
			{
				int thisSum = 0;

				for (int k = i; k <= j; k++)
					thisSum += a[k];

				if (thisSum > maxSum)
				{
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}
		return maxSum;
	}

	/* Author: Mark A. Weiss
	 * Purpose: Quadratic maximum contiguous subsequence sum algorithm. seqStart and seqEnd
	 * represent the actual best sequence.
	 * Input: an integer array
	 * Output: an integer
	 */
	public static int maxSubSum2 (int[] a)
	{
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
		{
			int thisSum = 0;
			for (int j = i; j < a.length; j++)
			{
				thisSum += a[j];

				if (thisSum > maxSum)
				{
					maxSum = thisSum;
					seqStart = i;
					seqEnd = j;
				}
			}
		}
		return maxSum;
	}

	/* Author: Mark A. Weiss
	 * Purpose: Linear-time maximum contiguous subsequence sum algorithm. seqStart and seqEnd
	 * represent the actual best sequence.
	 * Input: an integer array
	 * Output: an integer
	 */
	public static int maxSubSum4 (int[] a)
	{
		int maxSum = 0;
		int thisSum = 0;

		for (int i = 0, j = 0; j < a.length; j++)
		{
			thisSum += a[j];

			if (thisSum > maxSum)
			{
				maxSum = thisSum;
				seqStart = i;
				seqEnd = j;
			}
			else if (thisSum < 0)
			{
				i = j + 1;
				thisSum = 0;
			}
		}
		return maxSum;
	}

	/* Author: Mark A. Weiss
	 * Purpose: Recursive maximum contiguous subsequence sum algorithm. Finds maximum sum in
	 * subarray spanning a[left..right]. Does not attempt to maintain actual best sequence.
	 * Input: an integer array, an integer (left), an integer (right)
	 * Output: an integer
	 */
	private static int maxSumRec (int[] a, int left, int right)
	{
		int maxLeftBorderSum = 0, maxRightBorderSum = 0;
		int leftBorderSum = 0, rightBorderSum = 0;
		int center = (left + right) / 2;

		if (left == right)  // Base case
			return a[left] > 0 ? a[left] : 0;

		int maxLeftSum = maxSumRec(a, left, center);
		int maxRightSum = maxSumRec(a, center + 1, right);

		for (int i = center; i >= left; i--)
		{
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		for (int i = center + 1; i <= right; i++)
		{
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}
	
	/* Author: Mark A. Weiss
	 * Purpose: Method to return the maximum of three integers.
	 * Input: three integers
	 * Output: an integer
	 */
	private static int max3 (int a, int b, int c)
	{
		return a > b ? a > c ? a : c : b > c ? b : c;
	}
	
	/* Author: Mark A. Weiss
	 * Purpose:  Driver for divide-and-conquer maximum contiguous subsequence sum algorithm.
	 * Input: an integer array
	 * Output: an integer
	 */
	public static int maxSubSum3 (int[] a)
	{
		return a.length > 0 ? maxSumRec(a, 0, a.length - 1) : 0;
	}
	
	/* Author: Mark A. Weiss, Gillian Kaufman
	 * Purpose: Method for retrieving the time it takes to find the max contiguous subsequence sum 
	 * Input: an integer array, an integer
	 * Output: N/A
	 */
	public static void getTimingInfo (int[] a, int alg)
	{
		long startTime = System.currentTimeMillis();
		long totalTime = 0;
		int i;
		for (i = 0; totalTime < 4000; i++)
		{
			switch (alg)
			{
			case 1:
				maxSubSum1(a);
				break;
			case 2:
				maxSubSum2(a);
				break;
			case 3:
				maxSubSum3(a);
				break;
			case 4:
				maxSubSum4(a);
				break;
			}
			totalTime = System.currentTimeMillis() - startTime;
		}
		System.out.print(String.format("\t%12.6f", (totalTime * 1000 / i) / (double) 1000000));
	}
	
	/* Author: Mark A. Weiss, Gillian Kaufman
	 * Purpose: Test driver for finding the max sum subsequence of a given list of integers
	 * given in file format.
	 * @throws FileNotFoundException
	 * Input: N/A
	 * Output: N/A
	 */
	public static void main (String[] args) throws FileNotFoundException
	{
		//Variable and while loop for repeating the program with several files
		boolean continueProgram = true;
		while (continueProgram)
		{
			Scanner scan = new Scanner(System.in);
			
			//Prompt for file name
			System.out.println("Please enter file name (including extension): ");
			String filename = scan.nextLine();
			File file = new File(filename);
			
			System.out.println("How many integers are in the file? ");
			int length = scan.nextInt();
			scan.nextLine();			//To catch the remaining end line character
			
			//Fill out array with integers from file
			Scanner scanner = new Scanner(file);
			int[] a = new int[length];
			int i = 0;
			
			while (scanner.hasNextInt())
			{
				a[i++] = scanner.nextInt();
			}
			
			//Run the array through the subsequence algorithms
			int maxSum, n = length;

			maxSum = maxSubSum1(a);
			System.out.println("Max sum is " + maxSum + "; it goes" + " from " + seqStart + " to " + seqEnd);
			maxSum = maxSubSum2(a);
			System.out.println("Max sum is " + maxSum + "; it goes" + " from " + seqStart + " to " + seqEnd);
			maxSum = maxSubSum3(a);
			System.out.println("Max sum is " + maxSum);
			maxSum = maxSubSum4(a);
			System.out.println("Max sum is " + maxSum + "; it goes" + " from " + seqStart + " to " + seqEnd);

			// Get some timing info
			System.out.print(String.format("N = %7d", n));

			for (int alg = 1; alg <= 4; alg++)
			{
				if (alg == 1 && n > 50000)
				{
					System.out.print("\t      NA    ");
					continue;
				}
				getTimingInfo(a, alg);
			}
			System.out.println();
			
			//Prompt for running again
			System.out.println("Would you like to continue? (y/n): ");
			String input = scan.nextLine();
			if (input.contentEquals("n"))
			{
				continueProgram = false;
			}
		}
	}
}