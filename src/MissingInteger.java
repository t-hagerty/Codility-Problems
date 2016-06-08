/**
 * 
 */

/**
 * given a non-empty zero-indexed array A of N integers, 
 * returns the minimal positive integer (greater than 0) 
 * that does not occur in A.
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range 
 * [-2,147,483,648..2,147,483,647].
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class MissingInteger {

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * given:
  		 * A[0] = 1
  		 * A[1] = 3
  		 * A[2] = 6
  		 * A[3] = 4
  		 * A[4] = 1
  		 * A[5] = 2
		 * the function should return 5.
		 */
		int[] testArray = new int[] {1, 3, 6, 4, 1, 2};
		System.out.println("The minimum positive missing integer is: " +
				solution(testArray));
		
		//Should return 2:
		testArray = new int[] {1};
		System.out.println("The minimum positive missing integer is: " +
				solution(testArray));
		
		//Should return 1:
		testArray = new int[] {2};
		System.out.println("The minimum positive missing integer is: " +
				solution(testArray));
	}

	/**
	 * given a non-empty zero-indexed array A of N integers, 
	 * returns the minimal positive integer (greater than 0) 
	 * that does not occur in A.
	 * 
	 * @param A The array of N integers
	 * @return The minimum positive missing element in the array of N integers.
	 * If an integer 1 <= x <= N is not missing, the next missing pos int is N + 1
	 */
	public static int solution(int[] A)
	{
		int N = A.length;
		boolean[] isElements = new boolean[N+1];
		
		for(int i = 0; i < N; i++)
		{
			isElements[A[i]-1] = true;
		}
		
		for(int i = 0; i <= N; i++)
		{
			if(!isElements[i])
			{
				return i+1;
			}
		}
		
		return N + 1;
	}
}
