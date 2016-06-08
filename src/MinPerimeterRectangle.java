/**
 * 
 */

/**
 * An integer N is given, representing the area of some rectangle.
 * The area of a rectangle whose sides are of length A and B is A * B, and 
 * the perimeter is 2 * (A + B).
 * The goal is to find the minimal perimeter of any rectangle whose area 
 * equals N. The sides of this rectangle should be only integers.
 * 
 * @author Tyler Hagerty
 * @version Oct 21, 2015
 */
public class MinPerimeterRectangle 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given integer N = 30, rectangles of area 30 are:
		 * (1, 30), with a perimeter of 62,
		 * (2, 15), with a perimeter of 34,
		 * (3, 10), with a perimeter of 26,
		 * (5, 6), with a perimeter of 22.
		 * 
		 * Should return 22:
		 */
		
		System.out.println(solution(30));
	}

	/**
	 * Determines the minimum perimeter of a rectangle with the given area.
	 * 
	 * @param N The area (an integer) of a rectangle with unspecified side lengths
	 * @return The minimum sum of any possible integer side length combinations of rectangles for the given area
	 */
	public static int solution(int N)
	{
		int minPerimeter = Integer.MAX_VALUE;
		
		for(int i = 1; i <= Math.sqrt(N); i++)
		{
			if(N % i == 0)
			{
				int otherDivisor = N / i;
				
				minPerimeter = Math.min((i + otherDivisor) * 2, minPerimeter);
			}
		}
		
		return minPerimeter;
	}
}
