/**
 * 
 */

/**
 * A small frog wants to get to the other side of the 
 * road. The frog is currently located at position X and 
 * wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
 *
 * Count the minimal number of jumps that the small frog 
 * must perform to reach its target.
 * 
 * @author Tyler Hagerty
 * @version 10/8/15
 */
public class FrogJmp 
{

	/**
	 * Main method to test the solution function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Minimum number of jumps: " +
				solution(10, 85, 30));
		/**
		 * the function should return 3, because the frog will be positioned as follows:
			after the first jump, at position 10 + 30 = 40
			after the second jump, at position 10 + 30 + 30 = 70
			after the third jump, at position 10 + 30 + 30 + 30 = 100
		 */
		System.out.println("Minimum number of jumps: " + 
				solution(10, 10, 30));
		//Should return 0
		System.out.println("Minimum number of jumps: " + 
				solution(1, 1000000, 1));
		//Should return 999999

	}
	
	/**
	 * Counts the minimal number of jumps that the small frog 
	 * must perform to reach its target.
	 * 
	 * @param X Starting distance of the frog
	 * @param Y Position that the frog wants to reach or go past
	 * @param D Size of the jump the frog always makes
	 * @return
	 */
	public static int solution(int X, int Y, int D)
	{
		int numJumps;
		
		//Get only the distance needed to travel:
		Y = Y - X;
		
		numJumps = Y / D;
		
		//Check if there's a remainder distance less than
		//the distance of one jump, need to make another:
		if(Y % D > 0)
		{
			numJumps++;
		}
		
		return numJumps;
	}

}
