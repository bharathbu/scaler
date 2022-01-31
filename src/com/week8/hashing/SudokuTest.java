/**
 * Valid Sudoku
 * 
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
package com.week8.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuTest {

	public static void main(String[] args) {
		List<String> A = new ArrayList<String>();
		A.add("53..7....");
		A.add("6..195...");
		A.add(".98....6.");
		A.add("8...6...3");
		A.add("4..8.3..1");
		A.add("7...2...6");
		A.add(".6....28.");
		A.add("...419..5");
		A.add("....8..79");
		System.out.println(isValidSudoku(A));
	}
	public static int isValidSudoku(final List<String> A) {
		int result=isValidConfig(A, 9);	
		return result;
	}
	
	public static int isValidConfig(List<String> A, int n){
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {	             
	            // If current row or current column or
	            // current 3x3 box is not valid, return
	            // false
	            if (!isValid(A, i, j))
	                return 0;
	        }
	    }
	    return 1;
	}
	// Checks whether current row and current column and
	// current 3x3 box is valid or not
	public static boolean isValid(List<String> A, int row,
	                              int col)
	{
	    return notInRow(A, row) && notInCol(A, col) &&
	           notInBox(A, row - row % 3, col - col % 3);
	}
	
	private static boolean notInRow(List<String> A, int row) {
		// Set to store characters seen so far.
	    Set<Character> st = new HashSet<>();
	    for(int i = 0; i < 9; i++){      
	        // If already encountered before,
	        // return false
	        if (st.contains(A.get(row).charAt(i)))
	            return false;	 
	        // If it is not an empty cell, insert value
	        // at the current cell in the set
	        if (A.get(row).charAt(i) != '.')
	            st.add(A.get(row).charAt(i));
	    }
	    return true;
	}
	// Checks whether there is any duplicate
	// in current 3x3 box or not.
	public static boolean notInBox(List<String> A,
	                               int startRow,
	                               int startCol){
	    Set<Character> st = new HashSet<>();
	 
	    for(int row = 0; row < 3; row++) {
	        for(int col = 0; col < 3; col++) {
	            char curr = A.get(row + startRow).charAt(col + startCol);
	            // If already encountered before, return
	            // false
	            if (st.contains(curr))
	                return false;
	 
	            // If it is not an empty cell,
	            // insert value at current cell in set
	            if (curr != '.')
	                st.add(curr);
	        }
	    }
	    return true;
	}
	
	// Checks whether there is any duplicate
	// in current column or not.
	public static boolean notInCol(List<String> A, int col){
	    Set<Character> st = new HashSet<>(); 
	    for(int i = 0; i < 9; i++){         
	        // If already encountered before,
	        // return false
	        if (st.contains(A.get(i).charAt(col)))
	            return false; 
	        // If it is not an empty cell,
	        // insert value at the current
	        // cell in the set
	        if (A.get(i).charAt(col) != '.')
	            st.add(A.get(i).charAt(col));
	    }
	    return true;
	}
}


