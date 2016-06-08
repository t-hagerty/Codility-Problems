/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers 
 * is given. A pair of integers (P, Q), such that 0 <= P < Q < N, 
 * is called a slice of array A (notice that the slice contains 
 * at least two elements). The average of a slice (P, Q) is the 
 * sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of 
 * the slice. To be precise, the average equals 
 * (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * 
 * @author Tyler Hagerty
 * @version 10/9/2015
 */
public class MinAvgTwoSlice 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * array A such that:
    		A[0] = 4
    		A[1] = 2
    		A[2] = 2
    		A[3] = 5
    		A[4] = 1
    		A[5] = 5
    		A[6] = 8
		 * contains the following example slices:
 		 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 		 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
		 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
		 * Should return 1, starting index of the first slice
		 */
		int[] testArray = new int[] {4, 2, 2, 5, 1, 5, 8};
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
		
		testArray = new int[] {1};
		//Should be 0:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));

		testArray = new int[] {1, 1};
		//Should be 0:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
		
		testArray = new int[] {1, 2, 1};
		//Should be 0:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
		
		testArray = new int[] {1, 2, 1, 2};
		//Should be 0:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
		
		testArray = new int[] {3, 4, 1, 2};
		//Should be 2:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
		
		testArray = new int[] {1, 1, 4, 10};
		//Should be 0:
		System.out.println("Staring index of min avg group: " +
		solution(testArray));
	}

	/**
	 * Finds the starting index of the minimum average of all the groups
	 * of integers contained in the input array
	 * 
	 * @param A The array of integers to search for a minimum average in
	 * @return The starting index (from the left) of the location in A of the group of integers with the minimum average.
	 */
	public static int solution(int[] A)
	{
		int avgIndex = 0;
		int N = A.length;
		
		if(N <= 2)
		{
			return 0;
		}
		
		double minAvg = (A[0] + A[1]) / 2.0; //Start off with the first average slice
		
		for(int i = 2; i < N; i++)
		{
			/**
			 * Only the groups of two and three matter for minimum averages
			 * for math-y reasons, because any larger group is made up of groups
			 * of two and/or three integers, one of which will be smaller.
			 */
			double twoSplit = (A[i - 1] + A[i]) / 2.0;
			double threeSplit = (A[i - 2] + A[i - 1] + A[i]) / 3.0;
			
			if(twoSplit < minAvg)
			{
				minAvg = twoSplit;
				avgIndex = i-1;
			}
			else if(threeSplit < minAvg)
			{
				minAvg = threeSplit;
				avgIndex = i-2;
			}
			
		}
		
		return avgIndex;
	}
}
