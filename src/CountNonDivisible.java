import java.util.Arrays;

/**
 * 
 */

/**
 * You are given a non-empty zero-indexed array A consisting of N integers.
 * 
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of 
 * elements of the array that are not the divisors of A[i]. We say that these 
 * elements are non-divisors.
 * 
 * @author Tyler Hagerty
 * @version Oct 23, 2015
 */
public class CountNonDivisible 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * consider integer N = 5 and array A such that:
		 * A[0] = 3
		 * A[1] = 1
		 * A[2] = 2
		 * A[3] = 3
		 * A[4] = 6
		 * For the following elements:
		 * A[0] = 3, the non-divisors are: 2, 6,
		 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
		 * A[2] = 2, the non-divisors are: 3, 3, 6,
		 * A[3] = 3, the non-divisors are: 2, 6,
		 * A[6] = 6, there aren't any non-divisors.
		 */
		int[] testArray = new int[] {3, 1, 2, 3, 6};
		System.out.println(Arrays.toString(solution(testArray)));
	}

	/**
	 * given a non-empty zero-indexed array A consisting of N integers, 
	 * returns a sequence of integers representing the amount of non-divisors.
	 * 
	 * @param A The array of integers to check for non divisors
	 * @return An array of integers representing the number of non divisors 
	 * of A[i] in A for each i
	 */
	public static int[] solution(int[] A)
	{
		int length = A.length;
		int[] results = new int[length];
		Arrays.fill(results,  length - 1); 
		//start off assuming every element is not a divisor except itself
		
		for(int i = 0; i < length; i++)
		{
			for(int j = i + 1; j < length; j++)
			{
				if(A[i] % A[j] == 0)
				{
					results[i]--;
				}
				if(A[j] % A[i] == 0)
				{
					results[j]--;
				}

			}
		}
		
		return results;
	}
}
