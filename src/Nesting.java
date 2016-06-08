/**
 * 
 */
import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * 
 * given a string S consisting of N characters, returns 1 if string S is 
 * properly nested and 0 otherwise.
 * 
 * @author Tyler Hagerty
 * @version Oct 16, 2015
 */
public class Nesting 
{

	/**
	 * To test the solution function.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//For example, string "(()(())())" is properly nested but string "())" isn't.
		//Should be 1
		System.out.println(solution("(()(())())"));
		System.out.println(stack_solution("(()(())())"));
		
		//Should be 0
		System.out.println(solution("())"));
		System.out.println(stack_solution("())"));

		//Should be 1
		System.out.println(solution(""));
		System.out.println(stack_solution(""));
		
		//Should be 0
		System.out.println(solution("("));
		System.out.println(stack_solution("("));
		
		//Should be 0
		System.out.println(solution(")"));
		System.out.println(stack_solution(")"));
		
		//Should be 0
		System.out.println(solution("(()"));
		System.out.println(stack_solution("(()"));
	}

	/**
	 * Determines if a string consisting of only ( and ) (or empty) is
	 * properly nested according to the rules defined in the problem.
	 * Returns 1 if properly nested, 0 otherwise. Loops through the given
	 * input string and increases a counter when a ( is encountered, and decreasing
	 * when a ) is encountered.
	 * 
	 * @param S The input string of ('s and )'s (or empty)
	 * @return 1 is properly nested, or 0 if not.
	 */
	public static int solution(String S)
	{
		int nestCount = 0;
		
		for(int i = 0; i < S.length(); i++)
		{
			if(S.charAt(i) == '(')
			{
				nestCount++;
			}
			else
			{
				if(nestCount == 0)
				{
					//if nestCount already 0, we have no properly matching '(' for the encountered ')'
					return 0;
				}
				nestCount--;
			}
		}
		
		if(nestCount == 0)
		{
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * Alternate solution function.
	 * 
	 * Determines if a string consisting of only ( and ) (or empty) is
	 * properly nested according to the rules defined in the problem.
	 * Returns 1 if properly nested, 0 otherwise. Loops through the given
	 * input string and pushes ( onto a stack when encountered, pops off 
	 * the stack when ) is encountered. 
	 * 
	 * @param S The input string of ('s and )'s (or empty)
	 * @return 1 is properly nested, or 0 if not.
	 */
	public static int stack_solution(String S)
	{
		Stack<Character> s = new Stack<Character>();
		
		for(int i = 0; i < S.length(); i++)
		{
			if(S.charAt(i) == '(')
			{
				s.push('(');
			}
			else
			{
				if(s.isEmpty())
				{
					//if stack already empty and we encounter a')', we have no properly matched '(' 
					return 0;
				}
				s.pop();
			}
		}
		
		if(s.isEmpty())
		{
			return 1;
		}
		
		return 0;
	}

}
