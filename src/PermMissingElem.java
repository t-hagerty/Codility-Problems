/**
 * 
 */

/**
 * A zero-indexed array A consisting of N different 
 * integers is given. The array contains integers in the 
 * range [1..(N + 1)], which means that exactly one element 
 * is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function that, given a zero-indexed array A, 
 * returns the value of the missing element.
 * 
 * @author Tyler Hagerty
 * @version 10/8/2015
 */
public class PermMissingElem 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] testArray = new int[] {2, 3, 1, 5};
		/**
		 * A[0] = 2
  		 * A[1] = 3
  		 * A[2] = 1
  	     * A[3] = 5
         * the function should return 4, as it is the missing element.
		 */
		System.out.println("The missing element is: " +
		 solution(testArray));
		
		testArray = new int[] {1};
		System.out.println("The missing element is: " +
				 solution(testArray));
		//Should return 2

	}
	
	/**
	 * Finds the missing integer in a given array
	 * containing integers between 1 and N + 1 integers, 
	 * where one integer between 1 and N is missing
	 * 
	 * @param A The array containing integers between 1 and
	 * N + 1 integers, where one integer between 1 and N is missing
	 * @return The integer missing in the array
	 */
	public static int solution(int[] A)
	{
		int N = A.length;
		int total = ((N + 1) * (N+2))/2;
				
		for(int i = 0; i < N; i++)
		{
			total -= A[i];
		}
		
		return total;
	}

}
