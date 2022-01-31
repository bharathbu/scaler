/**
 * Print a Pattern According to The Given Value of A.
 * Example: For A = 3 pattern looks like:
 * 1 0 0
 * 1 2 0
 * 1 2 3
 * 
 * Problem Constraints
 * 1 <= A <= 1000
 * 
 * Input Format
 * First and only argument is an integer denoting A.
 * 
 * Output Format
 * Return a two-dimensional array where each row in the returned array represents a row in the pattern.
 * 
 * Example Input
 * Input 1:
 *  A = 3
 *  
 * Input 2:
 * A = 4
 * 
 * 
Example Output

Output :1

 [ 
   [1, 0, 0]
   [1, 2, 0]
   [1, 2, 3]
 ]
Output 2:

 [ 
   [1, 0, 0, 0]
   [1, 2, 0, 0]
   [1, 2, 3, 0]
   [1, 2, 3, 4]
 ]
 */
package com.week2.problemsolving;

/**
 * @author Bharath
 *
 */
public class PatternPrintingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		solve(10);

	}

	public static void solve(int A) {
        int [][] ans = new int [A][A];
        
        for(int i = 0; i < A; ++i){
            for(int j = 0; j <= i; ++j) {
            	ans[i][j] = j + 1;
            }   
        }
        
        for(int i=0; i<A; i++) {
        	for(int j=0;j<A;j++) {
        		System.out.print(ans[i][j]+" ");
        	}
        	System.out.println();
        }
	}
}
