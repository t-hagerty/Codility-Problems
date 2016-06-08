/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N 
 * integers is given.

	A permutation is a sequence containing each element from 
	1 to N once, and only once.
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class PermCheck 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, array A such that:
    		A[0] = 4
    		A[1] = 1
    		A[2] = 3
    		A[3] = 2
			is a permutation, but array A such that:

    		A[0] = 4
    		A[1] = 1
    		A[2] = 3
			is not a permutation, because value 2 is missing.
		 */
		int[] testArray = new int[] {4, 1, 3, 2};
		//Should return 1:
		System.out.println("Result: " + solution(testArray));
		
		testArray = new int[] {4, 1, 3};
		//Should return 0:
		System.out.println("Result: " + solution(testArray));
		
		testArray = new int[] {2};
		//Should return 0:
		System.out.println("Result: " + solution(testArray));
		
		testArray = new int[] {1};
		//Should return 1:
		System.out.println("Result: " + solution(testArray));

	}

	/**
	 * Checks if the given array is a permutation
	 * 
	 * @param A The array to be tested to see if it's a permutation
	 * @return Returns 1 if the array is a permutation, 0 if not
	 */
	public static int solution(int[] A)
	{
		int N = A.length;
		boolean[] isElements = new boolean[N];
		
		for(int i = 0; i < N; i++)
		{
			try
			{
				if(!isElements[A[i]-1])
				{
					isElements[A[i] - 1] = true;
				}
				else
				{
					return 0;
				}
			}
			catch(Exception e)
			{
				return 0; //element not between 1 and N found triggers arrayoutofbounds exception
			}
			
		}
		
		return 1;
	}
}
