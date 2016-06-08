/**
 * 
 */
import java.util.Arrays;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:
A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.
Write a function:
int solution(int A[], int N);that, given a zero-indexed array A consisting 
of N integers, returns 1 if there exists a triangular triplet for this array 
and returns 0 otherwise.
 * 
 * @author Tyler Hagerty
 * @version Oct 14, 2015
 */
public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Taken from http://codesays.com/2014/solution-to-triangle-by-codility/
	 * 
	 * Sorts the input array of integers and then loops through the array and
	 * checks each triplet against one of the cases (the other two can be ruled 
	 * out because the array is sorted).
	 * 
	 * @param A The input array of integers
	 * @return 1 if there is a triangular, 0 if there is not.
	 */
	public static int solution(int[] A) {
        // Handle with the special cases
        if(null == A || A.length < 3) return 0;

        // Sort the input, and then try to find the triangular
        Arrays.sort(A);
        for(int i = 0; i < A.length-2; i++) {
            // Beware of overflow
            if (A[i] >= 0 && A[i] > A[i+2] - A[i+1]) {
                return 1;
            }
            /*
             * We already know A[i+1] <= A[i+2]. If A[i] < 0,
             * A[i] + A[i+1] < A[i+2]
             */
        }                
        return 0;
    }
}
