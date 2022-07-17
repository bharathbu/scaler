/**
 * Sudoku
 *
 * Problem Description
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 *
 *
 * Problem Constraints
 * N = 9
 *
 *
 * Input Format
 * First argument is an array of array of characters representing the Sudoku puzzle.
 *
 *
 * Output Format
 * Modify the given input to the required answer.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 *
 *
 * Example Output
 * Output 1:
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Look at the diagrams given in the question.
 */
package com.advanced.dsa.backtracking;

import java.util.ArrayList;
/*
Classic backtrack problem.
Everytime you place an element x on row,col, you need to check if its still valid to put x on that position by double checking if x occurs more than once in the row or column or in its block. If not, you proceed by placing x, and call forward to check if a correct solution is possible with x in position row, col.
If a solution is possible, you return the current configuration and you are done. Otherwise you try other values.
 */
public class Sudoku {
    private ArrayList<ArrayList<Character>> a;
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        this.a = a;
        sudoku(0);
    }

    private boolean sudoku(int x) {
        if(x == 81){
            return true;
        }
        int r=x/9, c=x%9;
        if(a.get(r).get(c) != '.')
            return sudoku(x+1);
        else{
            for (char i = '1'; i <= '9'; i++) {
                if(valid(a,r,c,i)){
                    a.get(r).set(c, i);
                    if(sudoku(x+1)) return true;
                    a.get(r).set(c, '.');
                }
            }
        }
        return false;
    }

    private boolean valid(ArrayList<ArrayList<Character>> mat, int r, int c, char d) {
        for (int i = 0; i < 9; i++) {
            if(mat.get(r).get(i) == d || mat.get(i).get(c) == d) return false;
        }
        int x = r-r%3;
        int y = c-c%3;

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                if(mat.get(i).get(j)==d) return false;
            }
        }
        return true;
    }
}
