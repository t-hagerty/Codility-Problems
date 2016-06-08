import java.util.Arrays;

/**
 * 
 */

/**
 * You have to climb up a ladder. The ladder has exactly N rungs, numbered 
 * from 1 to N. With each step, you can ascend by one or two rungs. More 
 * precisely:
 * with your first step you can stand on rung 1 or 2,
 * if you are on rung K, you can move to rungs K + 1 or K + 2,
 * finally you have to stand on rung N.
 * 
 * Your task is to count the number of different ways of climbing to the top 
 * of the ladder.
 * 
 * The number of different ways can be very large, so it is sufficient to 
 * return the result modulo 2P, for a given integer P.
 * 
 * Write a function that, given two non-empty zero-indexed arrays A and B of 
 * L integers, returns an array consisting of L integers specifying the 
 * consecutive answers; position I should contain the number of different 
 * ways of climbing the ladder with A[I] rungs modulo 2B[I].
 * 
 * @author Tyler Hagerty
 * @version Oct 23, 2015
 */
public class Ladder 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given L = 5 and:
		 * A[0] = 4   B[0] = 3
		 * A[1] = 4   B[1] = 2
		 * A[2] = 5   B[2] = 4
		 * A[3] = 5   B[3] = 3
		 * A[4] = 1   B[4] = 1
		 * the function should return the sequence [5, 1, 8, 0, 1]
		 */
		int[] testArrayA = new int[] {4, 4, 5, 5, 1};
		int[] testArrayB = new int[] {3, 2, 4, 3, 1};
		
		System.out.println(Arrays.toString(solution(testArrayA, testArrayB)));

	}
	
	/**
	 * Determines the number of possible ways to climb a ladder with A[i] rungs
	 * according to the rules described above, modulo B[i].
	 * 
	 * @param A The number of rungs for each problem
	 * @param B The numbers for A[I] rungs modulo 2^B[I]
	 * @return An array of integers containing the number of possible ways to climb each ladder modulo 2^B[i]
	 */
	public static int[] solution(int[] A, int[] B)
	{
		int lengthA = A.length;
		int maxA = 0;
		int maxB = 0;
		//Find the largest possible number of rungs to be encountered (maxA):
		//And largest element in B for use in mod operations (because of big numbers)
		for(int i = 0; i < lengthA; i++)
		{
			if(A[i] > maxA)
				maxA = A[i];
			if(B[i] < maxB)
				maxB = B[i];
		}
		
		int[] results = new int[lengthA];
		
		int modLimit = (1 << maxB) - 1; //In case of fibonacci numbers that are too large
		
		//Compute all fibonacci numbers between 0 and maxA:
		int[] fibonacci = new int[maxA + 2];
		fibonacci[1] = 1;
		
		for(int i = 2; i < maxA + 2; i++)
		{
			fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) & modLimit;
		}
		
		for(int i = 0; i < lengthA; i++)
		{
			results[i] = fibonacci[A[i] + 1] & ((1 << B[i]) -1);
			//fibonacci[A[i] + 1] because for a given N rungs, the number of 
			//different ways of climbing is the (N+1)th element in the 
			//Fibonacci numbers.
			
			//Bitwise AND operator (&) for doing modulo computation in an optimized manner
			//((1 << B[i]) -1) for very large fibonacci numbers
		}
		
		return results;
	}

}
