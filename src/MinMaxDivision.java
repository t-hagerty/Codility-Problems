/**
 * 
 */

/**
 * You are given integers K, M and a non-empty zero-indexed array A 
 * consisting of N integers. Every element of the array is not greater than M.
 * 
 * You should divide this array into K blocks of consecutive elements. The size 
 * of the block is any integer between 0 and N. Every element of the array 
 * should belong to some block.
 * 
 * The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The 
 * sum of empty block equals 0.
 * 
 * The large sum is the maximal sum of any block.
 * 
 * @author Tyler Hagerty
 * @version Oct 27, 2015
 */
public class MinMaxDivision 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * given integers K = 3, M = 5 and array A such that:
		 * A[0] = 2
		 * A[1] = 1
		 * A[2] = 5
		 * A[3] = 1
		 * A[4] = 2
		 * A[5] = 2
		 * A[6] = 2
		 * The array can be divided, for example, into the following blocks:
		 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
		 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
		 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
		 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
		 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
		 */

		int[] testArray = new int[] {2, 1, 5, 1, 2, 2, 2};
		System.out.println(solution(3, 5, testArray));
	}

	/**
	 * given integers K, M and a non-empty zero-indexed array A consisting 
	 * of N integers, returns the minimal large sum.
	 * 
	 * @param K The number of blocks to divide the array into according to the
	 * rules stated above
	 * @param M The maximum value an element in A can be (will be ignored)
	 * @param A The array of integers
	 * @return The minimum large sum of A when divided into k blocks
	 */
	public static int solution(int K, int M, int[] A)
	{
		int length = A.length;
		
		//set up for binary searching for the solution:
		int left = Integer.MIN_VALUE;
		//Find maximum element in A, the minimum large sum is a block of just this element
		for(int i = 0; i < length; i++)
		{
			if(A[i] > left)
			{
				left = A[i];
			}
		}
		
		int right = 0;
		//Find the sum of all elements of A, the maximum large sum is a block of all elements
		for(int i = 0; i < length; i++)
		{
			right += A[i];
		}
		//FOR BINARY SEARCH: The left bound is now max(A) and the right sum 
		//is sum(A) for reasons stated above.
		
		//CHECK FOR SIMPLE CASES:
		if(K == 1)
			return right; //the sum of all elements, only block that can be made
		
		if(K == length - 1)
		{
			return left; //the max element. Number of blocks = number of 
			//elements, so we can have one block for each element, the large 
			//sum will be the max element
		}
		
		//Begin binary searching for the solution:
		while(left <= right)
		{
			int mid = (left + right) / 2;
			
			if(isValid(K, mid, A))
			{
				//current proposed large sum passes, test for smaller ones (don't need to test larger because we're looking for MIN)
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	/**
	 * Checks if a value from the binary searching of the minimum large sum
	 * is actually obtainable.
	 * 
	 * @param K The number of blocks A must be broken up into.
	 * @param proposedLrgSum The number binary search has given to be tested if it's a valid, obtainable large sum
	 * @param A The array of integers being broken into blocks
	 * @return True if the number is obtainable as a large sum under given conditions, false otherwise.
	 */
	public static boolean isValid(int K, int proposedLrgSum, int[] A)
	{
		int blockSum = 0;
		int blockCount = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			//if current block being tested is greater than the large sum
			//proposed by the binary search when the next element is added to it,
			//move onto the next block starting with the current element
			//(no block can be larger thn proposedLrgSum for it to be valid)
			if(blockSum + A[i] > proposedLrgSum)
			{
				blockSum = A[i];
				blockCount++;
			}
			else
			{
				blockSum += A[i];
			}
			//if we had to divide A into more blocks than k to make sure no block
			//had a sum larger than proposedLrgSum, then it isn't valid
			if(blockCount >= K)
			{
				return false;
			}
		}
		
		return true;
	}
}
