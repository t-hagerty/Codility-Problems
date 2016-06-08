import java.util.Stack;

/**
 * 
 */

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * The leader of this array is the value that occurs in more than half of 
 * the elements of A.
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences 
 * A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders 
 * of the same value.
 * For example, given array A such that:
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose 
 * value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose 
 * value is 4.
 * The goal is to count the number of equi leaders.
 * 
 * @author Tyler Hagerty
 * @version Oct 19, 2015
 */
public class EquiLeader 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * given array A such that:
		 * A[0] = 4
		 * A[1] = 3
		 * A[2] = 4
		 * A[3] = 4
		 * A[4] = 4
		 * A[5] = 2
		 * we can find two equi leaders:
		 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
		 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
		 */
		int[] testArray = new int[] {4, 3, 4, 4, 4, 2};
		System.out.println(solution(testArray));

	}

	/**
	 * given a non-empty zero-indexed array A consisting of N integers, 
	 * returns the number of equi leaders.
	 * 
	 * @param A The array of integers to look for pairs of equileaders.
	 * @return The number of pairs of equileaders
	 */
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
			return 0;
		}
		int counter = 0;
		
		for(int i = 0; i < length; i++)
		{
			if(A[i] == candidate)
			{
				counter++;
			}
		}
		//Counted how many times the candidate occurs, now test for equileaders IFF it's a leader (counter > n/2)
		if(counter > (length / 2))
		{
			//counter now signifies the total number of times the leader is in A
			//candidate now signifies the leader
			
			int leaderCounter = 0;
			int equiLeaderCounter = 0;
			
			for(int i = 0; i < length; i++)
			{
				if(A[i] == candidate)
				{
					leaderCounter++;
				}
				if(leaderCounter > (i + 1) / 2)
				{
					if((counter - leaderCounter) > (length - (i + 1)) / 2)
					{
						equiLeaderCounter++;
					}
				}
			}
			
			return equiLeaderCounter;
		}
		
		return 0;
	}
}
