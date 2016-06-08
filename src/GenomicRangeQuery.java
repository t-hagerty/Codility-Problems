import java.util.Arrays;

/**
 * 
 */

/**
 * A DNA sequence can be represented as a string consisting 
 * of the letters A, C, G and T, which correspond to the 
 * types of successive nucleotides in the sequence. Each 
 * nucleotide has an impact factor, which is an integer. 
 * Nucleotides of types A, C, G and T have impact factors 
 * of 1, 2, 3 and 4, respectively. You are going to answer 
 * several queries of the form: What is the minimal impact 
 * factor of nucleotides contained in a particular part of 
 * the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string 
 * S = S[0]S[1]...S[N-1] consisting of N characters. There 
 * are M queries, which are given in non-empty arrays P 
 * and Q, each consisting of M integers. The K-th 
 * query (0 <= K < M) requires you to find the minimal 
 * impact factor of nucleotides contained in the DNA 
 * sequence between positions P[K] and Q[K] (inclusive).
 * 
 * @author Tyler Hagerty
 * @version 10/10/2015
 */
public class GenomicRangeQuery 
{

	/**
	 * To test the solution function
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * consider string S = CAGCCTA and arrays P, Q such that:
    		P[0] = 2    Q[0] = 4
    		P[1] = 5    Q[1] = 5
    		P[2] = 0    Q[2] = 6
		 * The answers to these M = 3 queries are as follows:

			-The part of the DNA between positions 2 and 4 
			contains nucleotides G and C (twice), whose 
			impact factors are 3 and 2 respectively, so the
			answer is 2.
			-The part between positions 5 and 5 contains a 
			single nucleotide T, whose impact factor is 4, 
			so the answer is 4.
			-The part between positions 0 and 6 (the whole 
			string) contains all nucleotides, in particular 
			nucleotide A whose impact factor is 1, so the 
			answer is 1.
			
			Result: [2, 4, 1]
		 */
		String testString = "CAGCCTA";
		int[] testArrayP = new int[] {2, 5, 0};
		int[] testArrayQ = new int[] {4, 5, 6};
		
		System.out.println("Results: " + 
				Arrays.toString(
					solution(testString, testArrayP, testArrayQ)));

	}

	/**
	 * Takes a String representing a genomic sequence and two arrays
	 * representing queries on that sequence, where the first array
	 * represents the starting index of each query and the second the last index,
	 * and returns an array of the smallest impacts in the subsections
	 * looked at by each query, where impacts: A = 1, C = 2, G = 3, T = 4
	 * 
	 * @param S The String representing the genomic sequence
	 * @param P The array of starting indices of each query
	 * @param Q The array of ending indices of each query
	 * @return The array of results (int) of the minimum impact in each section queried.
	 */
	public static int[] solution(String S, int[] P, int[] Q)
	{
		int length = S.length();
		int queryLength = P.length;
		int[] result = new int[queryLength];
		int[] seqImpact = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			char temp = S.charAt(i);
			switch(temp)
			{
				case 'A':
					seqImpact[i] = 1;
					break;
				case 'C':
					seqImpact[i] = 2;
					break;
				case 'G':
					seqImpact[i] = 3;
					break;
				case 'T':
					seqImpact[i] = 4;
					break;
			}
		}
		
		for(int i = 0; i < queryLength; i++)
		{
			int min = Integer.MAX_VALUE;
			
			for(int j = P[i]; j <= Q[i]; j++)
			{
				if(seqImpact[j] < min)
				{
					min = seqImpact[j];
				}
				
			}
			
			result[i] = min;
		}
		
		return result;
	}
}
