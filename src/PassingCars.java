/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers 
 * is given. The consecutive elements of array A represent 
 * consecutive cars on a road.

 * Array A contains only 0s and/or 1s:

 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair 
 * of cars (P, Q), where 0 ≤ P < Q < N, is passing when P 
 * is traveling to the east and Q is traveling to the west.
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class PassingCars 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] testArray = new int[] {0, 1, 0, 1, 1};
		//Should be 5:
		System.out.println("Number of pairs: " + solution(testArray));
		
		testArray = new int[] {1, 0};
		//Should be 0:
		System.out.println("Number of pairs: " + solution(testArray));


	}

	/**
	 * Counts the number of pairs of cars that have passed each other
	 * (traveling different directions w/ starting positions heading towards each other, not already after)
	 * Counts the number of cars traveling west so far encountered in the array,
	 * and if one traveling east is encountered, all cars traveling west already encountered
	 * are cars that the eastbound car will pass (increase pair total).
	 * 
	 * @param A The array of integers representing car position and direction on the road.
	 * 1 = westbound, 0 = eastbound.
	 * @return The number of pairs of cars that pass each other (an integer).
	 */
	public static int solution(int[] A)
	{
		int numWest = 0;
		int numPairs = 0;
		
		for(int i = (A.length - 1); i >= 0; i--)
		{
			if(A[i] == 1)
			{
				numWest++;
			}
			else
			{
				numPairs += numWest;
			}
			
		}
		
		return numPairs;
	}
}
