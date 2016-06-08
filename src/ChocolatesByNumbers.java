/**
 * 
 */

/**
 * Two positive integers N and M are given. Integer N represents the number 
 * of chocolates arranged in a circle, numbered from 0 to N − 1.
 * 
 * You start to eat the chocolates. After eating a chocolate you leave only 
 * a wrapper.
 * 
 * You begin with eating chocolate number 0. Then you omit the next M − 1 
 * chocolates or wrappers on the circle, and eat the following one.
 * 
 * More precisely, if you ate chocolate number X, then you will next eat the 
 * chocolate with number (X + M) modulo N (remainder of division).
 * 
 * You stop eating when you encounter an empty wrapper.
 * 
 * For example, given integers N = 10 and M = 4. You will eat the following 
 * chocolates: 0, 4, 8, 2, 6.
 * 
 * The goal is to count the number of chocolates that you will eat, following 
 * the above rules.
 * 
 * @author Tyler Hagerty
 * @version Oct 23, 2015
 */
public class ChocolatesByNumbers 
{

	/**
	 * Tests the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, given integers N = 10 and M = 4. 
		 * You will eat the following chocolates: 0, 4, 8, 2, 6.
		 */
		System.out.println(solution(10,4));
	}
	
	/**
	 * Counts the number of chocolates you will be able to eat following the
	 * above rules.
	 * 
	 * @param N The number of chocolates
	 * @param M The amount of spaces you must move over to your next potential chocolate to eat
	 * @return The number of chocolates you can eat, an int
	 */
	public static int solution(int N, int M)
	{
		int chocolatesEaten = 0;
		int pos = 0;
		boolean[] isWrapper = new boolean[N];
		boolean encounteredWrapper = false;
		
		while(!encounteredWrapper)
		{
			if(!isWrapper[pos])
			{
				isWrapper[pos] = true;
				chocolatesEaten++;
				
				pos = (pos + M) % N;
			}
			else
			{
				encounteredWrapper = true;
			}
		}
		
		return chocolatesEaten;
	}

}
