/**
 * 
 */

/**
 * A zero-indexed array A consisting of N integers is given. It contains 
 * daily prices of a stock share for a period of N consecutive days. If a 
 * single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, 
 * then the profit of such transaction is equal to A[Q] − A[P], provided that 
 * A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 * 
 * @author Tyler Hagerty
 * @version Oct 20, 2015
 */
public class MaxProfit 
{

	/**
	 * To test the solution function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * consider the following array A consisting of six elements such that:
		 * A[0] = 23171
		 * A[1] = 21011
		 * A[2] = 21123
		 * A[3] = 21366
		 * A[4] = 21013
		 * A[5] = 21367
		 * If a share was bought on day 0 and sold on day 2, a loss of 2048 
		 * would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share 
		 * was bought on day 4 and sold on day 5, a profit of 354 would occur 
		 * because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit 
		 * was 356. It would occur if a share was bought on day 1 and sold on day 5.
		 */
		int[] testArray = new int[] {23171, 21011, 21123, 21366, 21013, 21367};
		System.out.println("Max profit: " + solution(testArray));

		//Should return 0:
		testArray = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("Max profit: " + solution(testArray));
	}

	/**
	 * Loops through the array of daily prices to determine the maximum profit
	 * that can be made from buying on day P and selling on day Q, where
	 * 0 <= P < Q <= A.length - 1. If no profit is possible, returns 0.
	 * 
	 * Keeps track of the lowest price, the profit that can be made from 
	 * buying at the lowest price and selling at the current day each loop, and
	 * keeps track of the maximum profit found so far as it loops through.
	 * 
	 * Uses a variation of Kadane's algorithm for finding maximum subarray sum in linear time
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A)
	{
		int currentProfit = 0;
		int minPrice = A[0];
		int maxProfit = 0;
		
		for(int i = 1; i < A.length; i++)
		{
			//Find profit, if any, from price currently looked at minus current minimum price encountered.
			currentProfit = Math.max(0, A[i] - minPrice);
			//See if current price the new minimum
			minPrice = Math.min(minPrice, A[i]);
			maxProfit = Math.max(maxProfit,  currentProfit);
		}
		
		return maxProfit;
	}
}
