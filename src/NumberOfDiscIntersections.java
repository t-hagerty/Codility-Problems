/**
 * 
 */

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
 * 
 * given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * 
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * 
 * @author Tyler Hagerty
 * @version Oct 14, 2015
 */
public class NumberOfDiscIntersections 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] testArray = new int[] {1, 5, 2, 1, 4, 0};
		//Should return 11:
		System.out.println("Number intersections: " + solution(testArray));

	}
	
	/**
	 * Initially we calculate all start and end points of discs. After go by 
	 * all line and check count of discs inside current point. If in current
	 *  point started some discs and intersection count increased by: already 
	 *  active discs multiplied by count of started in current point 
	 *  (result += t * dps[i]) and count of intersections of started
	 *  (result += dps[i] * (dps[i] - 1) / 2) eg. if started 5 discs in one 
	 *  of point it will increased by(1+2+3+4+5 intersections, or 
	 *  5*(5-1) / 2[sum formula]).
	 * 
	 * @param A The input array of integers representing discs with centers at 
	 * (0, i) where i is the index in the array, and A[i] is the radius of said disc.
	 * @return The number of pairs of intersecting discs.
	 */
	public static int solution(int[] A)
	{
		int numIntersections = 0;
		int length = A.length;
		int[] numDiscsStart = new int[length]; //Keep track of # discs that start on this point
		int[] numDiscsEnd = new int[length]; //Keep track of # discs that end on this point
		
		for(int i = 0; i < length; i++)
		{
			numDiscsStart[Math.max(0,  i - A[i])]++;
			numDiscsEnd[Math.min(length -1,  i + A[i])]++;
		}
		
		int numActive = 0;
		for(int i = 0; i < length; i++)
		{
			if(numDiscsStart[i] > 0)
			{
				numIntersections += numActive * numDiscsStart[i];
				numIntersections += numDiscsStart[i] * (numDiscsStart[i] - 1) / 2;
				numActive += numDiscsStart[i];
			}
			numActive -= numDiscsEnd[i];
		}
		
		return numIntersections;
	}
}
