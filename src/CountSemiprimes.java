import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 
 * 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * 
 * A semiprime is a natural number that is the product of two (not necessarily 
 * distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * 
 * You are given two non-empty zero-indexed arrays P and Q, each consisting of 
 * M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * 
 * Query K requires you to find the number of semiprimes within the range 
 * (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * 
 * @author Tyler Hagerty
 * @version Oct 23, 2015
 */
public class CountSemiprimes 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 *  consider an integer N = 26 and arrays P, Q such that:
		 *  P[0] = 1    Q[0] = 26
		 *  P[1] = 4    Q[1] = 10
		 *  P[2] = 16   Q[2] = 20
		 *  The number of semiprimes within each of these ranges is as follows:
		 *  (1, 26) is 10,
		 *  (4, 10) is 4,
		 *  (16, 20) is 0.
		 */

		int[] testArrayP = new int[] {1, 4, 16};
		int[] testArrayQ = new int[] {26, 10, 20};
		
		System.out.println(Arrays.toString(solution(26, testArrayP, testArrayQ)));
	}

	public static int[] solution(int N, int[] P, int[] Q)
	{
		
		
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
		
		int[] semiprimes = new int[N - 1];
		//Calculate all semiprimes, so that all indices in the array store 
		//the sum of all semiprimes up to that point (for ease of calculation):
		for(int i = 2; i < N - 1; i++) //We know 2 and 3 not semiprime, start off at 4/i = 2
		{
			semiprimes[i] = semiprimes[i-1];
			if(isComposite[i])
			{
				for(int prime: primes)
				{
					//If a prime exactly divides i, and the quotient is another prime:
					if((i + 2) % prime == 0 && !isComposite[((i + 2) / prime) - 2])
					{
						semiprimes[i]++;
						break;
					}
				}
			}
		}
		
		int queryLength = P.length;
		int[] results = new int[queryLength];
		
		for(int i = 0; i < queryLength; i++)
		{
			if(P[i] < 2)
			{
				results[i] = (semiprimes[Q[i]-2]);
			}
			else
			{
				results[i] = (semiprimes[Q[i]-2] - semiprimes[P[i]-3]);
			}	//P has minus three because we want to subtract the value at the index before the lower bound
		}
		
		return results;
	}
}
