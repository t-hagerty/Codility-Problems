import java.lang.Math;

/**
 * PROBLEM:
 * A non-empty zero-indexed array A consisting of N integers
 * is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two
 * non-empty parts: 
 * A[0], A[1], ..., A[P - 1] and A[P], A[P + 1], ..., A[N - 1].
 *
 * The difference between the two parts is the value of: 
 * |(A[0] + A[1] + ... + A[P - 1]) - (A[P] + A[P + 1] + ... + A[N - 1])|
 *
 * In other words, it is the absolute difference between the 
 * sum of the first part and the sum of the second part.
 * 
 * This code finds the minimal difference.
 * 
 * @author Tyler Hagerty
 * @version 10/8/15
 */
public class TapeEquilibrium 
{

	/**
	 * Main method to run test inputs on the function solution.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//CODILITY TEST EXAMPLE:
		int[] testArray = new int[] {3, 1, 2, 4, 3};
		//We can split this array in four places:
			//P = 1, difference = |3 - 10| = 7 
			//P = 2, difference = |4 - 9| = 5 
			//P = 3, difference = |6 - 7| = 1 
			//P = 4, difference = |10 - 3| = 7 
		//The solution function should return 1
		System.out.println("The result is: " + 
				solution(testArray, testArray.length));
		
		testArray = new int[] {-1, 0, 7, 8, 5, -2};
			/**
			 * P = 1 = 2, diff = |-1 - 18| = 19
			 * P = 3,     diff = |6 - 11|  = 5
			 * P = 4,     diff = |14 - 3|  = 11
			 * P = 5,     diff = |19 + 2|  = 21
			 */
		//The function should return 5 
		System.out.println("The result is: " + 
				solution(testArray, testArray.length));
	}
	
	/**
	 * Calculates the sum of all integers in the input array of integers.
	 * 
	 * @param A The array of integers to calculate the
	 * sum of its contents.
	 * @return the sum of all integers in the array A
	 */
	static int arraySum(int[] A)
	{
		int sum = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			sum += A[i];
		}
		
		return sum;
	}

	/**
	 * 
	 * 
	 * @param A The array to find the minimal difference of
	 * one half and another when split at any position.
	 * @param N The size of the array A
	 * @return the minimal difference that can be achieved
	 * when splitting the array A into two halves in any
	 * position and subtracting the second half from the
	 * first.
	 */
	static int solution(int[] A, int N)
	{
		int minDiff = Integer.MAX_VALUE;
		int currentDiff;
		int leftSum = 0;
		int rightSum = arraySum(A);
		
		for(int i = 0; i < A.length; i++)
		{
			leftSum += A[i];
			rightSum -= A[i];
			
			currentDiff = Math.abs(leftSum - rightSum);
			if(currentDiff < minDiff)
				minDiff = currentDiff;
		}
		
		return minDiff;
	}
}
