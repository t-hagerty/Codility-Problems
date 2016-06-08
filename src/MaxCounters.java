/**
 * 
 */
import java.util.Arrays;
/**
 * You are given N counters, initially set to 0, and you 
 * have two possible operations on them:
 *
 * increase(X) - counter X is increased by 1,
 * max counter - all counters are set to the maximum value 
 * of any counter.
 * A non-empty zero-indexed array A of M integers is given. 
 * This array represents consecutive operations:
 *
 * if A[K] = X, such that 1 <= X <= N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class MaxCounters 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given integer N = 5 and array A such that:
		 * 
    	 * A[0] = 3
    	 * A[1] = 4
    	 * A[2] = 4
    	 * A[3] = 6
    	 * A[4] = 1
    	 * A[5] = 4
    	 * A[6] = 4
		 * the values of the counters after each consecutive operation will be:
		 *
    	 * (0, 0, 1, 0, 0)
    	 * (0, 0, 1, 1, 0)
    	 * (0, 0, 1, 2, 0)
    	 * (2, 2, 2, 2, 2)
    	 * (3, 2, 2, 2, 2)
    	 * (3, 2, 2, 3, 2)
    	 * (3, 2, 2, 4, 2)
		 */
		int[] testArray = new int[] {3, 4, 4, 6, 1, 4, 4};
		System.out.println("Result is: " +
		 Arrays.toString(solution(5, testArray)));
		
	}

	/**
	 * Applies the operations to an output array.
	 * 
	 * @param N The size of the counter/output array
	 * @param A the array of operations to apply to the output
	 * @return the counter array after operations have been applied to it
	 */
	public static int[] solution(int N, int[] A)
	{
		int[] counters = new int[N];
		int max = 0;
		int i = 0;
		
		while(true)
		{
			try
			{
				if(A[i] > N)
				{
					for(int j = 0; j < N; j++)
					{
						counters[j] = max;
					}
				}
				else
				{
					counters[A[i]-1]++;
					
					if(counters[A[i]-1] > max)
					{
						max = counters[A[i]-1];
					}
				}
			}
			catch (Exception e)
			{
				return counters; //when end of A reached, return the solution
			}
			i++;
		}
	}
}
