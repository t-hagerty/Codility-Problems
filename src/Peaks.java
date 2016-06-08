import java.util.ArrayList;

/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A peak is an array element which is larger than its neighbors. More 
 * precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] 
 * and A[P] > A[P + 1].
 * For example, the following array A:
    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
 * has exactly three peaks: 3, 5, 10.
 * We want to divide this array into blocks containing the same number of 
 * elements. More precisely, we want to choose a number K that will yield 
 * the following blocks:
 * A[0], A[1], ..., A[K − 1],A[K], A[K + 1], ..., A[2K − 1],...A[N − K], A[N − K + 1], ..., A[N − 1].
 * What's more, every block should contain at least one peak. Notice that 
 * extreme elements of the blocks (for example A[K − 1] or A[K]) can also be 
 * peaks, but only if they have both neighbors (including one in an adjacent 
 * blocks).
 * The goal is to find the maximum number of blocks into which the array A 
 * can be divided.
 * Array A can be divided into blocks as follows:
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. 
 * Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], 
 * because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * However, array A cannot be divided into four blocks, 
 * (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks 
 * do not contain a peak. Notice in particular that the (4, 3, 4) block contains 
 * two peaks: A[3] and A[5].
 * The maximum number of blocks that array A can be divided into is three.
 * given a non-empty zero-indexed array A consisting of N integers, returns the 
 * maximum number of blocks into which A can be divided.
 * If A cannot be divided into some number of blocks, the function should return 0.
 * 
 * @author Tyler Hagerty
 * @version Oct 21, 2015
 */
public class Peaks 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 *  the following array A:
		 *  A[0] = 1, A[1] = 2, A[2] = 3, A[3] = 4, A[4] = 3, A[5] = 4,
		 *  A[6] = 1, A[7] = 2, A[8] = 3, A[9] = 4, A[10] = 6, A[11] = 2
		 *  has exactly three peaks: 3, 5, 10.
		 *  
		 *  one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains 
		 *  three peaks.
		 *  two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has 
		 *  a peak.
		 *  three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has 
		 *  a peak. Notice in particular that the first block (1, 2, 3, 4) has a 
		 *  peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the 
		 *  adjacent block.
		 */
		int[] testArray = new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		System.out.println(solution(testArray));
	}

	/**
	 * Finds the maximum amount of equally-sized blocks, each containing
	 * at least one peak, that an array can be broken up into.
	 * 
	 * @param A The array of integers being checked.
	 * @return The maximum amount of blocks A can be broken up into.
	 */
	public static int solution(int[] A)
	{
		int length = A.length;
		int peakCount = 0;
		int maxNumBlocks = 0;
		ArrayList<Integer> peakIndices = new ArrayList<Integer>();
		
		//Find the index of every peak in the array and store them:
		for(int i = 1; i < length; i++)
		{
			if(A[i-1] < A[i] && A[i + 1] < A[i])
			{
				peakCount++;
				peakIndices.add(i);
			}
		}
		
		int currentBlock = 0; //Represents the current block that needs to be checked for containing a peak
		//0 represents the 1st block, 1 the 2nd, etc...
		
		/*
		 * Find all valid block divisions by finding numbers that equally 
		 * divide the size of A, then check if each division has a peak.
		 */
		//Note that no number of blocks greater than the number of peaks can possibly be valid.
		for(int i = 1; i <= peakCount; i++)
		{
			if(length % i == 0)
			{
				/*
				 * Check every peak index in the array list and see if at 
				 * least one is in each block. Note that the peaks were added
				 * to the array list in order, so the peak(s) that are in the
				 * first block (if any) will be checked first.
				 * Once we find a peak in the first block, we increment
				 * currentBlock to start looking at the next block, etc.
				 */
				for(Integer peakIndex: peakIndices)
				{
					if((length / i) * (currentBlock + 1) > peakIndex 
							&& (length / i) * (currentBlock) < peakIndex)
					{
						currentBlock++;
					}
				}
				/*
				 * currentBlock is incremented every time one of the blocks
				 * is found to be valid, and i represents the number of divisions
				 * we're checking, so if all blocks are valid, currentBlock == i
				 */
				if(currentBlock  == i)
				{
					maxNumBlocks = i;
				}
				currentBlock = 0;
			}
		}
		
		return maxNumBlocks;
	}
}
