/**
 * 
 */
import java.util.Stack;

/**
 * A zero-indexed array A consisting of N integers is given. The dominator 
 * of array A is the value that occurs in more than half of the elements of A.
 * given a zero-indexed array A consisting of N integers, returns index of 
 * any element of array A in which the dominator of A occurs. The function 
 * should return −1 if array A does not have a dominator.
 * 
 * @author Tyler Hagerty
 * @version Oct 19, 2015
 */
public class Dominator 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * consider array A such that
		 * A[0] = 3    A[1] = 4    A[2] =  3
		 * A[3] = 2    A[4] = 3    A[5] = -1
		 * A[6] = 3    A[7] = 3
		 * The dominator of A is 3 because it occurs in 5 out of 8 elements 
		 * of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is 
		 * more than a half of 8.
		 */
		int[] testArray = new int[] {3, 4, 3, 2, 3, -1, 3, 3};
		System.out.println(solution(testArray));
		testArray = new int[] {1, 1, 1, 1, 1, 1};
		System.out.println(solution(testArray));
		testArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(solution(testArray));
		testArray = new int[] {1, 1, 1, 0, 0, 0};
		System.out.println(solution(testArray));
		testArray = new int[] {1, 0, 1, 0, 1};
		System.out.println(solution(testArray));

	}

	public static int solution(int[] A)
	{
		int length = A.length;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i <length; i++)
		{
			if(stack.isEmpty())
			{
				stack.push(A[i]);
			}
			else if(stack.peek() != A[i])
			{
				stack.pop();
			}
			else
			{
				stack.push(A[i]);
			}
		}
		int candidate;
		if(!stack.isEmpty())
		{
			candidate = stack.peek();
		}
		else
		{
			return -1;
		}
		int counter = 0;
		
		for(int i = 0; i < length; i++)
		{
			if(A[i] == candidate)
			{
				counter++;
			}
		}
		
		if(counter > (length / 2))
		{
			return candidate;
		}
		else
		{
			return -1;
		}
	}
}
