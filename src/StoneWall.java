/**
 * 
 */
import java.util.Stack;

/**
 * You are going to build a stone wall. The wall should be straight and N 
 * meters long, and its thickness should be constant; however, it should 
 * have different heights in different places. The height of the wall is 
 * specified by a zero-indexed array H of N positive integers. H[I] is the 
 * height of the wall from I to I+1 meters to the right of its left end. 
 * In particular, H[0] is the height of the wall's left end and H[N−1] is 
 * the height of the wall's right end.
 * 
 * The wall should be built of cuboid stone blocks (that is, all sides of 
 * such blocks are rectangular). Your task is to compute the minimum number 
 * of blocks needed to build the wall.
 * 
 * @author Tyler Hagerty
 * @version Oct 16, 2015
 */
public class StoneWall 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] testArray = new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8};
		System.out.println("Minimum number of stones" + 
		solution(testArray));

	}

	/**
	 * Determines the least amount of blocks needed to build a wall to match
	 * the heights specified by array H.
	 * 
	 * @param H The array of heights for the wall. A zero-indexed array H of N positive integers. H[I] is the 
	 * height of the wall from I to I+1 meters to the right of its left end. 
	 * In particular, H[0] is the height of the wall's left end and H[N−1] is 
	 * the height of the wall's right end.
	 * @return The minimum number of stones needed to build the wall according
	 * to the rules, an integer.
	 */
	public static int solution(int[] H)
	{
		int length = H.length;
		int stones = 0;
		
		Stack<Integer> heightMap = new Stack<Integer>();
		//*When a higher height that the top of the stack encountered, push 
		//onto the stack, the new top current height to be considered
		//*Once a next height in H is reached that's lower than the current
		//top height, pops heights off until a lesser than or equal height is
		//on top of the stack
		//*Allows for having a stone stretch across distances to cover
		//multiple equal heights while having stones on top to cover greater
		//heights in between, like the large middle stone in the codility example diagram
		
		
		for(int i = 0; i < length; i++)
		{
			if(heightMap.isEmpty())
			{
				stones++;
				heightMap.push(H[i]);
				//System.out.print(i);
				//System.out.println(heightMap.peek());
			}
			else
			{
				while(!heightMap.isEmpty() && heightMap.peek() > H[i])
				{
					//System.out.print("At " + i + "popped " + heightMap.peek());
					heightMap.pop();
				}
				if(!heightMap.isEmpty() && heightMap.peek() == H[i])
				{
					continue;
				}
				else
				{
					stones++;
					heightMap.push(H[i]);
					//System.out.print(i);
					//System.out.println(heightMap.peek());
				}
			}
			
		}
		
		return stones;
	}
}
