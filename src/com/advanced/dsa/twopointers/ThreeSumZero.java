/**
 * 3 Sum Zero
 *
 * Problem Description
 *
 * Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
 *
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= N <= 7000
 *
 * -108 <= A[i] <= 108
 *
 *
 *
 * Input Format
 *
 * Single argument representing a 1-D array A.
 *
 *
 *
 * Output Format
 *
 * Output a 2-D vector where each row represent a unique triplet.
 *
 *
 *
 * Example Input
 *
 * A = [-1,0,1,2,-1,4]
 *
 *
 * Example Output
 *
 * [ [-1,0,1],
 *   [-1,-1,2] ]
 *
 *
 * Example Explanation
 *
 * Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
package com.advanced.dsa.twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {

    /*
    When the array is sorted, try to fix the least integer by looping over it.

    Let us say the least integer in the solution is arr[i].
    Now we need to find a pair of integers j and k such that :

    arr[j] + arr[k] is -arr[i].

    To do that, let us try the 2 pointer approach.
    If we fix the two pointers at the end ( that is, i+1 and end of array ),
    we look at the sum.

    If the sum is smaller than 0, we increase the first pointer to increase the sum.
    If the sum is bigger than 0, we decrease the end pointer to reduce the sum.

        Getting a Time Limit exceeded or Output Limit exceeded?
    Make sure you handle case of empty input [].
    In C++/C, usually if you run a loop till array.size() - 2,
    it can lead to the program running indefinitely as array.size() is unsigned int, and the subtraction just makes it wrap over to a big integer.

    Make sure you are not processing the same triplets again.

    Skip over the duplicates in the array.

    Try a input like :
    -1 -1 -1 -1 0 0 0 0 1 1 1 1
    Ideally, you should get only 2 pairs : {[-1 0 1], [0 0 0]}
     */
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp;
        int n = A.size();

        Collections.sort(A);

        for (int i = 0; i < n-2 ; i++) {
            int a = A.get(i);
            int j=i+1;
            int back = n - 1;

            int b=A.get(j);
            while (j < back) {
                int sum = a+A.get(j)+A.get(back);
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    back--;
                } else {
                    temp = new ArrayList<>();
                    b=A.get(j);
                    int c=A.get(back);
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    result.add(temp);

                    while (j < back && A.get(j) == b)
                        j++;
                    while (back > j && A.get(back) == c)
                        back--;
                }
            }
            while (i + 1 < n && a == A.get(i + 1)) i++;
        }
        return result;

        /*
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> temp = new ArrayList<>();

	    if (A == null)
	        return res;

	    Collections.sort(A);
	    int n = A.size();

	    for (int low = 0; low < n - 2; low++) {

	        int mid = low + 1;
	        int high = n - 1;
	        int sum = -A.get(low);

	        if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue())
	            continue;

	        while (mid < high) {

	            int num = A.get(mid) + A.get(high);

	            if (num == sum) {
	                temp.add(A.get(low));
	                temp.add(A.get(mid));
	                temp.add(A.get(high));
	                res.add(new ArrayList(temp));
	                temp.clear();

	                int prev = mid;
	                while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
	                    mid++;

	            } else if (num < sum) {
	                mid++;
	            } else {
	                high--;
	            }
	        }
	    }

	    return res;
         */
    }
}
