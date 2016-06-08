/**
 * 
 */

/**
 * A small frog wants to get to the other side of a river. 
 * The frog is currently located at position 0, and wants 
 * to get to position X. Leaves fall from a tree onto the 
 * surface of the river.

 * You are given a non-empty zero-indexed array A consisting 
 * of N integers representing the falling leaves. A[K] 
 * represents the position where one leaf falls at time K, 
 * measured in seconds.

 * The goal is to find the earliest time when the frog can 
 * jump to the other side of the river. The frog can cross 
 * only when leaves appear at every position across the 
 * river from 1 to X. You may assume that the speed of the 
 * current in the river is negligibly small, i.e. the leaves 
 * do not change their positions once they fall in the river.
 * 
 * @author Tyler Hagerty
 * @version 10/8/15
 */
public class FrogRiverOne 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] testArray = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
		/**
		 *  given integer X = 5 and array A such that:

  		 	A[0] = 1
  			A[1] = 3
  			A[2] = 1
  			A[3] = 4
  			A[4] = 2
  			A[5] = 3
  			A[6] = 5
  			A[7] = 4
			In second 6, a leaf falls into position 5. This 
			is the earliest time when leaves appear in every 
			position across the river.
		 */
		System.out.println("The time the frog can go across is: " + 
		 solution(5, testArray));
		
		//Should return -1:
		System.out.println("The time the frog can go across is: " + 
				 solution(6, testArray));
		
		//Should return 4:
				System.out.println("The time the frog can go across is: " + 
						 solution(4, testArray));
	}

	/**
	 * The function that checks what time the frog can jump
	 * all the way across, or -1 if impossible
	 * 
	 * @param x The number of steps the frog needs to make
	 * @param A The sequence of when leaves will fall in each position
	 * @return The time the frog can go all the way across.
	 */
	public static int solution(int x, int[] A)
	{
		boolean[] hasFallen = new boolean[x];
		
		for(int i = 0; i < A.length; i++)
		{
			if(!hasFallen[A[i] - 1])
			{
				hasFallen[A[i] - 1] = true;
				x--; //one less step/leaf that needs to fall
			}
			if(x == 0)
			{
				return i;
			}
			
		}
		
		return -1;
	}
}
