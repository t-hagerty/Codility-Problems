/**
 * 
 */

/**
 * You are given two non-empty zero-indexed arrays A and B consisting of N 
 * integers. These arrays represent N planks. More precisely, A[K] is the 
 * start and B[K] the end of the K−th plank.
 * 
 * Next, you are given a non-empty zero-indexed array C consisting of M 
 * integers. This array represents M nails. More precisely, C[I] is the 
 * position where you can hammer in the I−th nail.
 * 
 * We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] 
 * such that A[K] ≤ C[I] ≤ B[K].
 * 
 * The goal is to find the minimum number of nails that must be used until 
 * all the planks are nailed. In other words, you should find a value J such 
 * that all planks will be nailed after using only the first J nails. More 
 * precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should 
 * exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
 * 
 * @author Tyler Hagerty
 * @version Nov 1, 2015
 */
public class NailingPlanks 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given arrays A, B such that:
		 * A[0] = 1    B[0] = 4
		 * A[1] = 4    B[1] = 5
		 * A[2] = 5    B[2] = 9
		 * A[3] = 8    B[3] = 10
		 * four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
		 * 
		 * Given array C such that:
		 * C[0] = 4
		 * C[1] = 6
		 * C[2] = 7
		 * C[3] = 10
		 * C[4] = 2
		 * if we use the following nails:
		 * 0, then planks [1, 4] and [4, 5] will both be nailed.
		 * 0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
		 * 0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
		 * 0, 1, 2, 3, then all the planks will be nailed.
		 * Thus, four is the minimum number of nails that, used sequentially, 
		 * allow all the planks to be nailed.
		 */
		
		int[] testA = new int[] {1, 4, 5, 8};
		int[] testB = new int[] {4, 5, 9, 10};
		int[] testC = new int[] {4, 6, 7, 10, 2};
		
		System.out.println(solution(testA, testB, testC));

	}

	/**
	 * given two non-empty zero-indexed arrays A and B consisting of N 
	 * integers and a non-empty zero-indexed array C consisting of M 
	 * integers, returns the minimum number of nails that, used sequentially, 
	 * allow all the planks to be nailed.
	 * 
	 * Uses binary search, time complexity: O((N + M)*log(N))
	 * where M = #nails, N = size A/B
	 * 
	 * @param A The starting position of the ith plank
	 * @param B The ending position of the ith plank
	 * @param C The position where each nail can go
	 * @return The minimum number of nails that need to be used for all planks
	 * to be nailed in, sequentially
	 */
	public static int solution(int[] A, int[] B, int[] C)
	{
		int left = 1;
		int right = C.length;
		
		//Begin binary searching for the solution:
		while(left <= right)
		{
			int mid = (left + right) / 2;
					
			if(isValid(A, B, C, mid))
			{
				//current proposed #nails passes, test for smaller amounts (don't need to test larger because we're looking for MIN)
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
	 * Checks if the number of nails being tested by the binary search in the
	 * solution method will nail down all the planks defined by A and B (nails
	 * are chosen sequentially from C). Uses prefix sum of the number of nails
	 * total encountered at each position in order to aid in this check (using
	 * start position A[i] and end position B[i] of each board, make sure a new
	 * nail has been added to the prefix sum within those bounds).
	 * 
	 * @param A The starting position of the ith plank
	 * @param B The ending position of the ith plank
	 * @param C The position where each nail can go
	 * @param minNumNails The number of nails proposed by the binary search 
	 * to be tested that this amount can nail all planks.
	 * @return true if the number of nails fulfills all requirements, false otherwise
	 */
	public static boolean isValid(int[] A, int[] B, int[] C, int minNumNails)
	{
		int[] prefixSum = new int[(2 * C.length) + 1];
		
		for(int i = 0; i < minNumNails; i++)
		{
			prefixSum[C[i]]++;
		}
		
		for(int i = 1; i < (2 * C.length) + 1; i++)
		{
			prefixSum[i] += prefixSum[i-1];
		}
		
		for(int i = 0; i < A.length; i++)
		{
			//If number of nails total is same at start and end of a plank, no nail goes into this plank, not valid
			if(prefixSum[B[i]] == prefixSum[A[i] - 1])
			{
				return false;
			}
		}
		
		return true;
	}
}
