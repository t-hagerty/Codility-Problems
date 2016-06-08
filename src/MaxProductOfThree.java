/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers
 * is given. The product of triplet (P, Q, R) equates to 
 * A[P] * A[Q] * A[R] (0 <= P < Q < R < N).
 * 
 * Assume that:
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [-1,000..1,000].
 * 
 * @author Tyler Hagerty
 * @version 10/10/2015
 *
 */
public class MaxProductOfThree 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * array A such that:
		 * A[0] = -3
		 * A[1] = 1
		 * A[2] = 2
		 * A[3] = -2
		 * A[4] = 5
		 * A[5] = 6
		 * contains the following example triplets:
		 * (0, 1, 2), product is -3 * 1 * 2 = -6
		 * (1, 2, 4), product is 1 * 2 * 5 = 10
		 * (2, 4, 5), product is 2 * 5 * 6 = 60
		 * 
		 * NOTE: triplets don't have to be next to each other
		 * 
		 * (60 is the maximum product of maximum triplet (2, 4, 5), should return 60
		 */
		int[] testArray = new int[] {-3, 1, 2, -2, 5, 6};
		System.out.println("Maximum product of triplets: " +
		solution(testArray));

		testArray = new int[] {-3, -2, -1, -7};
		//Should return -6:
		System.out.println("Maximum product of triplets: " +
		solution(testArray));
		
		testArray = new int[] {1, -3, -2, -1, -7};
		//Should return 2:
		System.out.println("Maximum product of triplets: " +
		solution(testArray));
	}

	/**
	 * Finds the three maximum elements in the input array
	 * in order to find the maximum product of any triplet
	 * in the array, and returns that product.
	 * 
	 * @param A The input array of integers
	 * @return The maximum product of any triplet in the array A
	 */
	public static int solution(int[] A)
	{
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int length = A.length;
		
		for(int i = 0; i < length; i++)
		{
			if(A[i] > max1)
			{
				max3 = max2;
				max2 = max1;
				max1 = A[i];
			}
			else if(A[i] > max2)
			{
				max3 = max2;
				max2 = A[i];
			}
			else if(A[i] > max3)
			{
				max3 = A[i];
			}
		}
		
		return max1 * max2 * max3;
	}
}
