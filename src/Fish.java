/**
 * 
 */
import java.util.Stack;

/**
 * You are given two non-empty zero-indexed arrays A and B consisting of N 
 * integers. Arrays A and B represent N voracious fish in a river, ordered 
 * downstream along the flow of the river.
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q,
 *  then fish P is initially upstream of fish Q. Initially, each fish has a 
 *  unique position.
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes 
 * of the fish. All its elements are unique. Array B contains the directions 
 * of the fish. It contains only 0s and/or 1s, where:
 * 0 represents a fish flowing upstream,
 * 1 represents a fish flowing downstream.
 * If two fish move in opposite directions and there are no other (living) 
 * fish between them, they will eventually meet each other. Then only one 
 * fish can stay alive − the larger fish eats the smaller one. More precisely, 
 * we say that two fish P and Q meet each other when P < Q, B[P] = 1 and 
 * B[Q] = 0, and there are no living fish between them. After they meet:
 * If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * We assume that all the fish are flowing at the same speed. That is, fish 
 * moving in the same direction never meet. The goal is to calculate the 
 * number of fish that will stay alive.
 * 
 * @author Tyler Hagerty
 * @version Oct 19, 2015
 */
public class Fish 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, consider arrays A and B such that:
		 *  A[0] = 4    B[0] = 0
		 *  A[1] = 3    B[1] = 1
		 *  A[2] = 2    B[2] = 0
		 *  A[3] = 1    B[3] = 0
		 *  A[4] = 5    B[4] = 0
		 *  Initially all the fish are alive and all except fish number 1 
		 *  are moving upstream. Fish number 1 meets fish number 2 and eats 
		 *  it, then it meets fish number 3 and eats it too. Finally, it 
		 *  meets fish number 4 and is eaten by it. The remaining two fish, 
		 *  number 0 and 4, never meet and therefore stay alive.
		 *  
		 *  Should return 2:
		 */

		int[] testArrayA = new int[] {4, 3, 2, 1, 5};
		int[] testArrayB = new int[] {0, 1, 0, 0, 0};
		System.out.println(solution(testArrayA, testArrayB));
	}

	/**
	 *  given two non-empty zero-indexed arrays A and B consisting of N 
	 *  integers, returns the number of fish that will stay alive according
	 *  to the rules & problem description above.
	 * 
	 * @param A The array of integers representing the fish at the ith position's size
	 * @param B The array of integers representing the fish's direction; 0 for upstream, 1 for downstream
	 * Upwards = moving towards the zero index, downwards = the opposite direction
	 * @return The number of surviving fish that swim on past all other fish moving in the opposite direction without being eaten, an integer
	 */
	public static int solution(int[] A, int[] B)
	{
		int length = A.length;
		int survivingFish = length; //Assume all fish initially survive
		Stack<Integer> activeUpstream = new Stack<Integer>();
		//Stores starting position of upstream fish currently being looked at that haven't been eaten
		
		for(int i = length - 1; i >= 0; i--)
		{
			if(B[i] == 0)
			{
				activeUpstream.push(i);
				//If going upstream, add position to the stack to start looking at.
			}
			else
			{
				//If going downstream, compare size to all upstream fish that it will encounter (already on the stack)
				while(!activeUpstream.isEmpty())
				{
					if(A[i] > A[activeUpstream.peek()])
					{
						//upSTREAM EATEN:
						//downstream fish bigger than the first upstream it encounters, remove fish from stack and dec surviving count
						activeUpstream.pop();
						survivingFish--;
					}
					else
					{
						//downSTREAM EATEN:
						//upstream fish bigger than downstream, stop comparing downstream fish to upstream fishes in front of it, dec surviving count
						survivingFish--;
						break;
					}
				}
			}
		}
		
		return survivingFish;
	}
}
