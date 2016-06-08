/**
 * 
 */

/**
 * given a zero-indexed array A consisting of N integers, 
 * returns the number of distinct values in array A.
 * 
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range 
 * [-1,000,000..1,000,000].
 * 
 * @author Tyler Hagerty
 * @version Oct 14, 2015
 */
public class Distinct 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * given array A consisting of six elements such that:
		 * A[0] = 2    A[1] = 1    A[2] = 1 A[3] = 2    A[4] = 3    A[5] = 1
		 * the function should return 3, because there are 3 distinct values 
		 * appearing in array A, namely 1, 2 and 3.
		 */
		int[] testArray = new int[] {2, 1, 1, 2, 3, 1};
		System.out.println("Number distinct elements: " +
		solution(testArray));

		//Should be 0:
		testArray = new int[] {};
		System.out.println("Number distinct elements: " +
		solution(testArray));
		
		//Should be 1:
				testArray = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
				System.out.println("Number distinct elements: " +
				solution(testArray));
	}

	/**
	 * Determines the number of distinct elements in a given array by sorting
	 * using an implementation of mergesort (worst case O(n*log(n)) to sort
	 * the array, then comparing each element to the one before it, if not the
	 * same, increase number of distinct elements
	 * 
	 * @param A The input array of ints
	 * @return The number (int) of distinct elements in the input array
	 */
	public static int solution(int[] A)
	{
		int numDistinct = 0;
		int length = A.length;
		if(length >= 1)
		{
			numDistinct++;
		}
		A = mergeSort(A, length);
		
		for(int i = 1; i < length; i++)
		{
			if(A[i-1] != A[i])
			{
				numDistinct++;
			}
		}
		
		return numDistinct;
	}
	
	/**
     * Implementation of mergeSort based on pseudocode from class notes. Sorts the array A by making
     * two new arrays half the size of A (B and C) and recursively calling mergeSort on them until the
     * base case, where the size of A is 1 (or less) in which case A is simply returned. 
     * Calls merge on B and C when all recursive mergeSorts on B and C are complete.
     * @version 4/4/2015
     * 
     * @param A the array to be sorted
     * @param n the size of array A
     * 
     * @return the sorted array
     */
    public static int[] mergeSort(int[] A, int n)
    {
        
        if(n > 1)
        {
            int middle = n/2;
            
            int[] B = new int[middle];
            int[] C = new int[n - middle];
            
            for(int i = 0; i < middle; i++)
            {
                B[i] = A[i];
            }
            for(int i = middle; i < n; i++)
            {
                C[i - (middle)] = A[i];
            }
            
            B = mergeSort(B, middle);
            C = mergeSort(C, n - middle);
            
            A = merge(B, C, A, middle, n - middle);
        }
        
        return A;
    }
    
    /**
     * Merges two arrays into one array while sorting them.
     * @version 4/4/2015
     * 
     * @param B the 1st half of the full array to be sorted and merged.
     * @param C the 2nd half of the array to be sorted and merged.
     * @param A the unsorted array to be sorted by merging B and C
     * @param p the size of B
     * @param q the size of C
     * 
     * @return The sorted, merged array of B and C
     */
    public static int[] merge(int[] B, int[] C, int[] A, int p, int q)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < p && j < q)
        {
            if(B[i] <= C[j])
            {
                A[k] = B[i];
                i++;
            }
            else
            {
                A[k] = C[j];
                j++;
            }
            
            k++;
        }
        
        if(i == p)
        {
            for(int c = j; c < q; c++)
            {
                A[k] = C[c];
                k++;
            }
        }
        else //j == q
        {
            for(int b = i; b < p; b++)
            {
                A[k] = B[b];
                k++;
            }
        }
        
        return A;
    }
}
