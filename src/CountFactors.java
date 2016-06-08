/**
 * 
 */

/**
 * A positive integer D is a factor of a positive integer N if there exists 
 * an integer M such that N = D * M.
 * For example, 6 is a factor of 24, because M = 4 satisfies the above 
 * condition (24 = 6 * 4).
 * 
 * @author Tyler Hagerty
 * @version Oct 21, 2015
 */
public class CountFactors 
{

	/**
	 * To test the solution function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given N = 24, the function should return 8, because
		 * 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no 
		 * other factors of 24.
		 */
		System.out.println(solution(24));
		
		System.out.println(solution(1));
		System.out.println(solution(17));
	}

	/**
	 * Determines the number of divisors a given integer has
	 * 
	 * @param N The given number to count the divisors of
	 * @return The number of divisors of N
	 */
	public static int solution(int N)
	{
		int divisorCount = 0;

		for(int i = 1; i <= Math.sqrt(N); i++)
		{
			if(N % i == 0)
			{
				if(N / i == i)
				{
					divisorCount++;
				}
				else
				{
					divisorCount += 2;
				}
			}
		}
		
		return divisorCount;
	}
}
