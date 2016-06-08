/**
 * 
 */

/**
 * A small frog wants to get to the other side of a river. The frog is 
 * initially located at one bank of the river (position −1) and wants to get 
 * to the other bank (position N). The frog can jump over any distance 
 * F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many 
 * leaves on the river, and the frog can jump between the leaves, but only 
 * in the direction of the bank at position N.
 * 
 * The leaves on the river are represented in a zero-indexed array A 
 * consisting of N integers. Consecutive elements of array A represent 
 * consecutive positions from 0 to N − 1 on the river. Array A contains 
 * only 0s and/or 1s:
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * 
 * The goal is to count the minimum number of jumps in which the frog can 
 * get to the other side of the river (from position −1 to position N). The 
 * frog can jump between positions −1 and N (the banks of the river) and 
 * every position containing a leaf.
 * 
 * @author Tyler Hagerty
 * @version Oct 24, 2015
 */
public class FibFrog 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, consider array A such that:
		 * A[0] = 0
		 * A[1] = 0
		 * A[2] = 0
		 * A[3] = 1
		 * A[4] = 1
		 * A[5] = 0
		 * A[6] = 1
		 * A[7] = 0
		 * A[8] = 0
		 * A[9] = 0
		 * A[10] = 0
		 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
		 */
		int[] testArray = new int[] {0,0,0,1,1,0,1,0,0,0,0};
		System.out.println(solution(testArray));

	}
	
	/**
	 * given a zero-indexed array A consisting of N integers, returns the 
	 * minimum number of jumps by which the frog can get to the other side 
	 * of the river. If the frog cannot reach the other side of the river, 
	 * the function should return −1.
	 * 
	 * @param A The array of 1's and 0's that represents if a leaf is on the river at position i. 1 = leaf, 0 = no leaf
	 * @return The minimum number of jumps it takes to reach the other side as defined by the rules of the problem
	 */
	public static int solution(int[] A)
	{
		int length = A.length;
		
		int[] fibonacci = new int[26];
		//only need up to f(25) for fib #'s based on the problem constraints
		int[] reached = new int[length];
		//Keeps track of min number of jumps to reach a spot.
		
		fibonacci[1] = 1;
		//Generate the rest of the fibonacci numbers:
		for(int i = 2; i < 26; i++)
		{
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
			
			//If fib# is the distance from 0 to N (start to finish) only one jump needed
			if(fibonacci[i] == length + 1)
			{
				return 1;
			}
			//If fib# smaller than distance from start to finish and there's a leaf
			//at the distance of the fib# jumping from start , we can reach that space in 1 jump:
			if(fibonacci[i] - 1 < length && A[fibonacci[i] - 1] == 1)
			{
				reached[fibonacci[i] - 1] = 1;
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		//Loop through each position on the river and, if there's a leaf there,
		//look at possible distances to jump and update information accordingly
		for(int i = 0; i < length; i++)
		{
			if(reached[i] == 0)
			{
				continue; //Can't jump to this spot, no leaf (since when can frogs jump onto leaves floating on water and the leaves support their weight anyways?)
			}
			
			//minimum number of jumps to reach A[i] will be calculated on previous loops of this for loop,
			//so when we loop through all possible fib. distances, we can know how many
			//jumps it takes to reach those potential distances.
			//Keep doing this/updating until reach the river bank/destination or run out of positions that work.
			int minJumpsToHere = reached[i];
			
			//Loop through all possible fib. jump distances at position A[i]
			//don't need to look at j = 0 because it's a jump of 0 length
			//don't need to look at j = 1 because fibonacci[1] = 1 = fibonacci[2]
			//26 is the prev. defined length of fibonacci
			for(int j = 2; j < 26; j++)
			{
				int nextPos = i + fibonacci[j];
				//If jump distance takes us to N, the destination/goal
				if(nextPos == length)
				{
					//If number of jumps to get here was less than prev. number of jumps to get here that was found (if any)
					if(minJumpsToHere + 1 < min)
						min = minJumpsToHere + 1;
					break;
				}
				//If jump distance goes past N/destination
				if(nextPos > length)
				{
					break; //jump distance won't work because it's longer than the rest of the distance needed to travel
					//Also, higher j values will only result in longer distances, so break
				}
				//If no leaf at jump distance end:
				if(A[nextPos] == 0)
				{
					continue; //jump distance won't work because there's no leaf
				}
				
				//If nextPos hasn't been reached before or the prev. amount 
				//of jumps to reach it was greater, update min # jumps to this pos
				if(reached[nextPos] == 0 || reached[nextPos] > minJumpsToHere + 1)
				{
					reached[nextPos] = minJumpsToHere + 1;
				}
				
			}
		}
		
		if(min == Integer.MAX_VALUE)
		{
			return -1; //couldn't reach the bank at N/destination
		}
		
		return min;
	}

}
