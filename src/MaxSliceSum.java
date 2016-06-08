/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A 
 * pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of 
 * array A. The sum of a slice (P, Q) is the total of 
 * A[P] + A[P+1] + ... + A[Q].
 * 
 * @author Tyler Hagerty
 * @version Oct 21, 2015
 */
public class MaxSliceSum 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given array A such that:
		 * A[0] = 3  A[1] = 2  A[2] = -6 A[3] = 4  A[4] = 0
		 * the function should return 5 because:
		 * (3, 4) is a slice of A that has sum 4,
		 * (2, 2) is a slice of A that has sum −6,
		 * (0, 1) is a slice of A that has sum 5,
		 * no other slice of A has sum greater than (0, 1).
		 */
		int[] testArray = new int[] {3, 2, -6, 4, 0};
		System.out.println("Maximum sum of subarray: " + solution(testArray));

		//Should return 0:
		testArray = new int[] {0};
		System.out.println("Maximum sum of subarray: " + solution(testArray));
		
		//Should return -1
		testArray = new int[] {-100, -10, -1};
		System.out.println("Maximum sum of subarray: " + solution(testArray));
		
		//Should return 7
		testArray = new int[] {-100, -10, -5, 7};
		System.out.println("Maximum sum of subarray: " + solution(testArray));
	}

	/**
	 * Kadane's algorithm for finding maximum subarray sum in an array in linear time.
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A)
	{
		int currentMax = A[0];
		int totalMax = A[0];
		
		for(int i = 1; i < A.length; i++)
		{
			currentMax = Math.max(A[i], currentMax + A[i]);
			totalMax = Math.max(totalMax,  currentMax);
		}
		
		return totalMax;
	}
}
