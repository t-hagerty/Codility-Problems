/**
 * 
 */

/**
 * given three integers A, B and K, returns the number of integers 
 * within the range [A..B] that are divisible by K
 * 
 * Assume that:

 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A <= B.
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class CountDiv 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * { i : A <= i <= B, i mod K = 0 }

		 * For example, for A = 6, B = 11 and K = 2, your function should 
		 * return 3, because there are three numbers divisible by 2 within 
		 * the range [6..11], namely 6, 8 and 10.
		 */
		System.out.println("Result: " + solution(6, 11, 2));
		
		//Should be: 0
		System.out.println("Result: " + solution(1, 2, 3));
		
		//Should be: 1
		System.out.println("Result: " + solution(2, 4, 3));
	}

	/**
	 * given three integers A, B and K, returns the number of integers 
	 * within the range [A..B] that are divisible by K
	 * 
	 * @param A The lower bound (int) of the range of integers
	 * @param B The upper bound (int) of the range of integers
	 * @param K The divisor (int)
	 * @return The number of numbers (int) that are divisible by K in the range
	 */
	public static int solution(int A, int B, int K)
	{
		if(B < K)
		{
			return 0;
		}
		if(A % K != 0)
		{
			//Make the starting point of the range the first number divisible by K
			A += A % K;
		}
		if(B % K != 0)
		{
			//Make the ending point of the range the last number divisible by K
			B -= B % K;
		}
		
		return ((B - A) / K) + 1;
		// (B / K) - ((A - K) / K) <<< Amount of times K goes into B minus
		//the amount of times K goes into A - K (A - K because we want to include
		//the time K is taken out for the number A represents.
		//
		//Simplified: (B / K) - (A / K - 1)
		//			  (B / K) + (-A / K) + 1
		//			  ((B - A) / K) + 1
	}
}
