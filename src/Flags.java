import java.util.ArrayList;

/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A peak is an array element which is larger than its neighbours. More 
 * precisely, it is an index P such that 
 * 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
 * 
 * For example, the following array A:
 * A[0] = 1, A[1] = 5, A[2] = 3, A[3] = 4, A[4] = 3, A[5] = 4, A[6] = 1
 * A[7] = 2, A[8] = 3, A[9] = 4, A[10] = 6, A[11] = 2
 * has exactly four peaks: elements 1, 3, 5 and 10.
 * 
 * You are going on a trip to a range of mountains whose relative heights are 
 * represented by array A, as shown in a figure below. You have to choose how 
 * many flags you should take with you. The goal is to set the maximum number 
 * of flags on the peaks, according to certain rules.
 * Flags can only be set on peaks. What's more, if you take K flags, then the 
 * distance between any two flags should be greater than or equal to K. The 
 * distance between indices P and Q is the absolute value |P − Q|.
 * For example, given the mountain range represented by array A, above, with 
 * N = 12, if you take:
 * 
 * two flags, you can set them on peaks 1 and 5;
 * three flags, you can set them on peaks 1, 5 and 10;
 * four flags, you can set only three flags, on peaks 1, 5 and 10.
 * 
 * You can therefore set a maximum of three flags in this case.
 * Write a function that, given a non-empty zero-indexed array A of N 
 * integers, returns the maximum number of flags that can be set on the peaks 
 * of the array.
 * 
 * @author Tyler Hagerty
 * @version Oct 22, 2015
 */
public class Flags 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, the following array A:
		 * A[0] = 1
		 * A[1] = 5
		 * A[2] = 3
		 * A[3] = 4
		 * A[4] = 3
		 * A[5] = 4
		 * A[6] = 1
		 * A[7] = 2
		 * A[8] = 3
		 * A[9] = 4
		 * A[10] = 6
		 * A[11] = 2
		 * has exactly four peaks: elements 1, 3, 5 and 10.
		 * 
		 * given the mountain range represented by array A, above, with N = 12, 
		 * if you take:
		 * two flags, you can set them on peaks 1 and 5;
		 * three flags, you can set them on peaks 1, 5 and 10;
		 * four flags, you can set only three flags, on peaks 1, 5 and 10.
		 * You can therefore set a maximum of three flags in this case.
		 */
		int[] testArray = new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
		System.out.println(solution(testArray));

	}

	/**
	 * Finds the peaks of A, and the maximum number of flags that can be 
	 * planted on those peaks. Returns the maximum number of flags.
	 * 
	 * @param A The array of integers representing "heights" and peaks
	 * @return The number of flags that can be planted according to the rules.
	 */
	public static int solution(int[] A)
	{
		int length = A.length;
		int peakCount = 0;
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
		if(peakCount < 2)
		{
			return peakCount;
		}
		
		int maxFlags = 1;
		
		for(int minDistance = (int)(Math.sqrt(length)); minDistance > 0; 
															minDistance--)
		{
			int flagsUsed = 1; //Use one flag for the first peak
			int flagsHave = minDistance - 1; //One flag used on first peak
			
			int pos = peakIndices.get(peakCount - 1);
			int peaksLookedAt = 1;
			
			while(flagsHave > 0)
			{
				peaksLookedAt++;
				
				if(pos - minDistance <  peakIndices.get(0))
				{
					break; //Reached past first peak, do not continue
				}
				
				//If next peak is closer than the minimum distance from current pos:
				if(peakCount - peaksLookedAt >= 0 &&
						peakIndices.get(peakCount - peaksLookedAt) > pos - minDistance)
				{
					continue;
				}
				
				flagsUsed++;
				flagsHave--;
				pos = peakIndices.get(peakCount - peaksLookedAt);
				
				maxFlags = Math.max(maxFlags, flagsUsed);
			}
		}
		
		return maxFlags;
	}
}
