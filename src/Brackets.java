/**
 * 
 */
import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested 
 * if any of the following conditions is true:
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * 
 * @author Tyler Hagerty
 * @version Oct 19, 2015
 */
public class Brackets 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * For example, the string "{[()()]}" is properly nested but 
		 * "([)()]" is not.
		 */

		System.out.println(solution("{[()()]}"));
		System.out.println(solution("([)()]"));
		System.out.println(solution("]]]"));
		System.out.println(solution(""));
	}

	/**
	 * Given a string S consisting of N characters, returns 1 if S is 
	 * properly nested according to the rules previously defined, 
	 * and 0 otherwise.
	 * 
	 * @param S The string of characters to test for proper nesting.
	 * Assume string S consists only of the following characters: 
	 * "(", "{", "[", "]", "}" and/or ")".
	 * @return 1 if S is properly nested according to the rules, or 0 if not.
	 */
	public static int solution(String S)
	{
		int length = S.length();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < length; i++)
		{
			if(S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(')
			{
				stack.push(S.charAt(i));
			}
			else if(!stack.isEmpty())
			{
				switch(S.charAt(i))
				{
					case '}':
						if(stack.peek() == '{')
						{
							stack.pop();
							break;
						}
						else
							return 0;
					case ']':
						if(stack.peek() == '[')
						{
							stack.pop();
							break;
						}
						else
							return 0;
					case ')':
						if(stack.peek() == '(')
						{
							stack.pop();
							break;
						}
						else
							return 0;
					default: 
							return 0;
				}
			}
			else
			{
				return 0;
			}
		}
		
		if(stack.isEmpty())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
