import java.util.ArrayList;

/**
 * 
 */

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 
 * 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * 
 * A prime D is called a prime divisor of a positive integer P if there exists 
 * a positive integer K such that D * K = P. For example, 2 and 5 are prime 
 * divisors of 20.
 * 
 * You are given two positive integers N and M. The goal is to check whether 
 * the sets of prime divisors of integers N and M are exactly the same.
 * 
 * Write a function that, given two non-empty zero-indexed arrays A and B of 
 * Z integers, returns the number of positions K for which the prime divisors 
 * of A[K] and B[K] are exactly the same.
 * 
 * @author Tyler Hagerty
 * @version Oct 23, 2015
 */
public class CommonPrimeDivisors 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * given:
		 * N = 15 and M = 75, the prime divisors are the same: {3, 5};
		 * N = 10 and M = 30, the prime divisors aren't the same: {2, 5}
		 * is not equal to {2, 3, 5};
		 * N = 9 and M = 5, the prime divisors aren't the same: {3} is not 
		 * equal to {5}.
		 * 
		 * the function should return 1, because only one pair (15, 75) has 
		 * the same set of prime divisors.
		 */
		int[] testArrayA = new int[] {15, 10, 9};
		int[] testArrayB = new int[] {75, 30, 5};
		System.out.println(solution(testArrayA, testArrayB));
		

	}

	public static int solution(int[] A, int[] B)
	{
		int matches = 0;
		//Find max number we need primes/composites for:
		int N = 0;
		for(int i = 0; i < A.length; i++)
		{
			int currentMax = Math.max(A[i], B[i]);
			N = Math.max(N,  currentMax);
		}
		
		//Find all primes using the sieve of Eratosthenes:
		//isComposite starts out assuming all prime (false)
		boolean[] isComposite = new boolean[N - 1];
		//Note because of the size of the array and because we're not considering
		//1 and 0, every index refers to the integer = index + 2, for example isComposite[0] refers to 2
		ArrayList<Integer> primes = new ArrayList<Integer>(); //For storing only primes
				
				
		for(int i = 0; i <= (int)Math.sqrt(N) - 2; i++)
		{
			if(!isComposite[0])
			{
				int multiplier = 2;
				while((i + 2) * multiplier <= N)
				{
					isComposite[((i + 2) * multiplier) - 2] = true;
					//Subtracted 2 in order to align the integer to its correct spot in the array previously described
					multiplier++;
				}
			}
		}
		//Build a list of just primes for later testing efficiency
		for(int i = 0; i < N-1; i++)
		{
			if(!isComposite[i])
			{
				primes.add(i+2);
			}
		}
		
		for(int i = 0; i < A.length; i++)
		{
			for(int prime: primes)
			{
				if(A[i] % prime == 0 && B[i] % prime == 0)
				{
					A[i] = A[i] / prime;
					B[i] = B[i] / prime;
					
					while(A[i] % prime == 0)
					{
						A[i] = A[i] / prime;
					}
					while(B[i] % prime == 0)
					{
						B[i] = B[i] / prime;
					}
				}
			}
			if(A[i] == B[i])
			{
				matches++;
			}
		}
		
		return matches;
	}
}
