/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * The sum of double slice (X, Y, Z) is the total of 
 * A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * 
 * @author Tyler Hagerty
 * @version Oct 19, 2015
 */
public class MaxDoubleSliceSum 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, array A such that:
		 * A[0] = 3
		 * A[1] = 2
		 * A[2] = 6
		 * A[3] = -1
		 * A[4] = 4
		 * A[5] = 5
		 * A[6] = -1
		 * A[7] = 2
		 * contains the following example double slices:
		 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
		 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
		 * double slice (3, 4, 5), sum is 0.
		 * 
		 * Should return 17:
		 */
		int[] testArray = new int[] {3, 2, 6, -1, 4, 5, -1, 2};
		System.out.println(solution(testArray, testArray.length));

	}

	/**
	 * 
	 * @param A
	 * @param N
	 * @return
	 */
	public static int solution(int[]A, int N)
	{
		int leftIndex = 0;
		int rightIndex = N - 1;
		int midIndex = 0;
		
		int[] forwardSums = new int[N];
		forwardSums[0] = A[0];
		//Set first element of forwardSums to first element of A because it's the starting point, sum is only itself, makes calculations easier
		
		int[] backwardSums = new int[N];
		backwardSums[N-1] = A[N-1];
		//Set last element of backwardSums to last element of A[i] because it's the starting point, the sum is just itself, makes calculations easier.
		
		//Calculate total sum of A[i] going in the direction of left to right/0 to N-1
		for(int i = 1; i < N ; i++)
		{
			forwardSums[i] = A[i] + forwardSums[i - 1];
		}
		
		//Calculate total sum of A[i] going in the direction of right to left/N-1 to 0
		for(int i = N - 2; i >= 0 ; i--)
		{
			backwardSums[i] = A[i] + backwardSums[i + 1];
		}
		
		/**
		 * Find the minimum value in the forward total sums.
		 * Ideally, this is where we want the left part of the split to be because it
		 * has the worst impact of maximizing the sum of the slice.
		 * Not always the case, so we will check for this later.
		 */
		for(int i = 1; i < N; i++)
		{
			if(forwardSums[i] < forwardSums[leftIndex])
			{
				leftIndex = i;
			}
		}
		
		//Similarly to the prev. for loop, find the minimum value of the backwardSums array
		for(int i = N - 2; i >= 0; i--)
		{
			if(backwardSums[i] < backwardSums[rightIndex])
			{
				rightIndex = i;
			}
		}
		
		//Test to see if the left/right indices are invalid, place them properly according to if left = right or left > right:
		//(Otherwise, determine mid index and calculate sum)
		if(leftIndex == rightIndex)
		{
			if(forwardSums[leftIndex] > backwardSums[leftIndex])
			{
				leftIndex = 0;
				for(int i = 1; i < rightIndex; i++)
				{
					if(forwardSums[i] < forwardSums[leftIndex])
					{
						leftIndex = i;
					}
				}
			}
			else if(forwardSums[leftIndex] < backwardSums[leftIndex])
			{
				rightIndex = N - 1;
				for(int i = N - 2; i > leftIndex; i--)
				{
					if(backwardSums[i] < backwardSums[rightIndex])
					{
						rightIndex = i;
					}
				}
			}
			else
			{
				midIndex = leftIndex;
				leftIndex = 0;
				rightIndex = N-1;
				for(int i = 1; i < midIndex; i++)
				{
					if(forwardSums[i] < forwardSums[leftIndex])
					{
						leftIndex = i;
					}
				}
				for(int i = N - 2; i > midIndex; i--)
				{
					if(backwardSums[i] < backwardSums[rightIndex])
					{
						rightIndex = i;
					}
				}
			}
		}
		else if(leftIndex > rightIndex)
		{
			//TODO: Figure out how to make this work
		}
	
		for(int i = leftIndex + 1; i < rightIndex; i++)
		{
			if(A[i] < A[midIndex])
			{
				midIndex = i;
			}
		}
		
		int sum = 0;
		
		for(int i = leftIndex + 1; i < rightIndex; i++)
		{
			if(i != midIndex)
			{
				sum += A[i];
			}
		}
		
		System.out.print(leftIndex + ", " + midIndex + ", " + rightIndex + ": ");
		
		return sum;
	}
}
