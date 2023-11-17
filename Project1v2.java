import java.security.SecureRandom;
import java.util.Random;

public final class Project1v2
{
    static private int seqStart = 0; // Will be set to start index of the subarray of maximum subsequent sum
    static private int seqEnd = -1; // Will be set to end index of the subarray of maximum subsequent sum
    
    private static Random rand = new SecureRandom( ); // Create object of Random class for generating random integers

    /**
     * Cubic maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
	//------------------------------------------------------------
    public static int maxSubSum1( int [ ] a )
    {
        int maxSum = 0;

        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ )
            {
                int thisSum = 0;

                for( int k = i; k <= j; k++ )
                    thisSum += a[ k ];

                if( thisSum > maxSum )
                {
                    maxSum   = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }

        return maxSum;
    }
    
	//------------------------------------------------------------
    /**
     * Quadratic maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
    public static int maxSubSum2( int [ ] a )
    {
        int maxSum = 0;

        for( int i = 0; i < a.length; i++ )
        {
            int thisSum = 0;
            for( int j = i; j < a.length; j++ )
            {
                thisSum += a[ j ];

                if( thisSum > maxSum )
                {
                    maxSum = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }
        }

        return maxSum;
    }

	//------------------------------------------------------------
    /**
     * Linear-time maximum contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     */
    public static int maxSubSum4( int [ ] a )
    {
        int maxSum = 0;
        int thisSum = 0;

        for( int i = 0, j = 0; j < a.length; j++ )
        {
            thisSum += a[ j ];

            if( thisSum > maxSum )
            {
                maxSum = thisSum;
                seqStart = i;
                seqEnd   = j;
            }
            else if( thisSum < 0 )
            {
                i = j + 1;
                thisSum = 0;
            }
        }

        return maxSum;
    }

	//------------------------------------------------------------
    /**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left..right].
     * Does not attempt to maintain actual best sequence.
     */
    private static int maxSumRec( int [ ] a, int left, int right )
    {
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;

        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;

        int maxLeftSum  = maxSumRec( a, left, center );
        int maxRightSum = maxSumRec( a, center + 1, right );

        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum )
                maxLeftBorderSum = leftBorderSum;
        }

        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }

        return max3( maxLeftSum, maxRightSum,
                     maxLeftBorderSum + maxRightBorderSum );
    }
	//------------------------------------------------------------

    /**
     * Return maximum of three integers.
     */
    private static int max3( int a, int b, int c )
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous
     * subsequence sum algorithm.
     */
    public static int maxSubSum3( int [ ] a )
    {
        return a.length > 0 ? maxSumRec( a, 0, a.length - 1 ) : 0;
    }

	//------------------------------------------------------------

    public static void getTimingInfo( int n, int alg )
    {
    	// Initialize array of length n that will contain random ints
        int [] test = new int[ n ];

        long startTime = System.currentTimeMillis( ); // Get current time to measure runtime
        long totalTime = 0;
        int maxSum = 0; // maxSum will be set equal to what is returned from each method, the maximum subsequent sum
        
        int i; // Initialized outside of for loop so it can be used to calculate runtime
        for( i = 0; totalTime < 4000; i++ )
        {
            for( int j = 0; j < test.length; j++ )
            	// Iterate through array and set each value to a random integer of range (-50, 50)
                test[ j ] = rand.nextInt( 100 ) - 50; 
            
            switch( alg )  // Run each algorithm for current input size
            {
              case 1:
            	  maxSum = maxSubSum1( test );
                break;
              case 2:
            	  maxSum = maxSubSum2( test );
                break;
              case 3:
            	  maxSum = maxSubSum3( test );
                break;
              case 4:
            	  maxSum = maxSubSum4( test );
                break;
            }

            // Calculate runtime
            totalTime = System.currentTimeMillis( ) - startTime;
        }

        // Formatted so statistics will print in columns
        System.out.print( String.format( "Runtime: %-3.6f", ( totalTime * 1000 / i ) / (double) 1000000)
        		+ String.format("\tMax sum: %-3d" , maxSum)
        		+ String.format("\tStart Index: %-3d",seqStart)
        		+ String.format("\tEnd Index: %-3d",seqEnd)+" | ");
        		
    } 
    
    public static void main( String [ ] args )
    {
 
        // Array of sizes of N
        int[] inputSizes = {100, 1000, 10000, 50000, 100000, 500000};
        
        // Iterate through inputSizes and run getTimingInfo for each
        for( int i = 0; i < inputSizes.length; i++)
        {
            System.out.print( String.format( "N = %7d" , inputSizes[i] )+"\t" );
            
            for( int alg = 1; alg <= 4; alg++ )
            {
                if( alg == 1 && inputSizes[i] >= 50000 ) // Prints out "NA" for input sizes greater than or equal to 50,000 for just the first algorithm
                {
                    System.out.print( "\t\t\t\t\tNA\t\t\t\t\t|" );
                    continue; // Proceeds to next iteration in inner for loop
                }
                getTimingInfo( inputSizes[i], alg );
            }
        }
    }
}

