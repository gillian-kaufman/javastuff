
import java.security.SecureRandom;
import java.util.*;

public class ProjectThreeDriver
{
	private static Random rand = new SecureRandom(); // Create object of Random class for generating random integers

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Simple insertion sort.
	 * @param test an array of integers.
	 */
	public static void insertionSort (int[] test)
	{
		int j;

		for (int p = 1; p < test.length; p++)
		{
			int tmp = test[p];
			for (j = p; j > 0 && tmp < test[j - 1]; j--)
				test[j] = test[j - 1];
			test[j] = tmp;
		}
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Mergesort algorithm.
	 * @param test an array of integers.
	 */
	public static void mergeSort (int[] test)
	{
		int[] tmpArray = new int[test.length];

		mergeSort(test, tmpArray, 0, test.length - 1);
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Internal method that makes recursive calls.
	 * @param test an array of integers.
	 * @param tmpArray an array to place the merged result.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static void mergeSort (int[] test, int[] tmpArray, int left, int right)
	{
		if (left < right)
		{
			int center = (left + right) / 2;
			mergeSort(test, tmpArray, left, center);
			mergeSort(test, tmpArray, center + 1, right);
			merge(test, tmpArray, left, center + 1, right);
		}
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Internal method that merges two sorted halves of a subarray.
	 * @param test an array of integers.
	 * @param tmpArray an array to place the merged result.
	 * @param leftPos the left-most index of the subarray.
	 * @param rightPos the index of the start of the second half.
	 * @param rightEnd the right-most index of the subarray.
	 */
	private static void merge (int[] test, int[] tmpArray, int leftPos, int rightPos, int rightEnd)
	{
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (test[leftPos] <= test[rightPos])
				tmpArray[tmpPos++] = test[leftPos++];
			else
				tmpArray[tmpPos++] = test[rightPos++];

		while (leftPos <= leftEnd)    // Copy rest of first half
			tmpArray[tmpPos++] = test[leftPos++];

		while (rightPos <= rightEnd)  // Copy rest of right half
			tmpArray[tmpPos++] = test[rightPos++];

		// Copy tmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--)
			test[rightEnd] = tmpArray[rightEnd];
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Quicksort algorithm.
	 * @param test an array of integers.
	 */
	public static void quicksort (int[] test)
	{
		quicksort(test, 0, test.length - 1);
	}

	private static final int CUTOFF = 3;

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Method to swap to elements in an array.
	 * @param an array of integers.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static void swapReferences (int[] a, int index1, int index2)
	{
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Return median of left, center, and right. 
	 * Order these and hide the pivot.
	 */
	private static int median3 (int[] a, int left, int right)
	{
		int center = (left + right) / 2;
		if (a[center] < a[left])
			swapReferences(a, left, center);
		if (a[right] < a[left])
			swapReferences(a, left, right);
		if (a[right] < a[center])
			swapReferences(a, center, right);

		// Place pivot at position right - 1
		swapReferences(a, center, right - 1);
		return a[right - 1];
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Internal quicksort method that makes recursive calls. Uses median-of-three partitioning and a cutoff of 10.
	 * @param test an array of integers.
	 * @param left the left-most index of the subarray.
	 * @param right the right-most index of the subarray.
	 */
	private static void quicksort (int[] test, int left, int right)
	{
		if (left + CUTOFF <= right)
		{
			int pivot = median3(test, left, right);

			// Begin partitioning
			int i = left, j = right - 1;
			for (;;)
			{
				while (test[++i] < pivot)
				{}
				while (test[--j] > pivot)
				{}
				if (i < j)
					swapReferences(test, i, j);
				else
					break;
			}

			swapReferences(test, i, right - 1);   // Restore pivot

			quicksort(test, left, i - 1);    // Sort small elements
			quicksort(test, i + 1, right);   // Sort large elements
		}
		else  // Do an insertion sort on the subarray
			insertionSort(test, left, right);
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Internal insertion sort routine for subarrays that is used by quicksort.
	 * @param test an array of integers. 
	 * @param left the left-most index of the subarray. 
	 * @param right the right-most index of the subarray.
	 */
	private static void insertionSort (int[] test, int left, int right)
	{
		for (int p = left + 1; p <= right; p++)
		{
			int tmp = test[p];
			int j;

			for (j = p; j > left && tmp < test[j - 1]; j--)
				test[j] = test[j - 1];
			test[j] = tmp;
		}
	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Method for retrieving the time it takes to sort an array with three different sorting algorithms
	 * @param two integers
	 */
	public static void getTimingInfo (int n, int alg)
	{
		// Initialize array of length n that will contain random ints
		int[] test = new int[n];

		long startTime = System.currentTimeMillis(); // Get current time to measure runtime
		long totalTime = 0;

		int i; // Initialized outside of for loop so it can be used to calculate runtime
		for (i = 0; totalTime < 4000; i++)
		{
			for (int j = 0; j < test.length; j++)
				// Iterate through array and set each value to a random integer of range (-50,
				// 50)
				test[j] = rand.nextInt(100) - 50;

			switch (alg)  // Run each algorithm for current input size
			{
			case 1:
				mergeSort(test);
				break;
			case 2:
				quicksort(test);
				break;
			case 3:
				insertionSort(test);
				break;
			}

			// Calculate runtime
			totalTime = System.currentTimeMillis() - startTime;
		}

		// Formatted so statistics will print in columns
		System.out.print(String.format("Algorithm " + alg + " Runtime: %-3.6f", (totalTime * 1000 / i) / (double) 1000000));

	}

	/* Author: Mark A. Weiss 
	 * Edits: Gillian Kaufman 
	 * Driver method for running the sorting algorithms on four arrays of random integers
	 */
	public static void main (String[] args)
	{
		// Array of sizes of N
		int[] inputSizes = { 10000, 20000, 40000, 80000 };

		// Iterate through inputSizes and run getTimingInfo for each
		for (int i = 0; i < inputSizes.length; i++)
		{
			System.out.print(String.format("N = %7d", inputSizes[i]) + "\t");

			for (int alg = 1; alg <= 3; alg++)
			{
				getTimingInfo(inputSizes[i], alg);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}
}
