/**
 * Subarray with given sum
 *
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 */
package com.advanced.dsa.twopointers;

public class SubarrySum {

    public static void main(String[] args){
        /*
        We can use 2 pointer technique to solve this problem efficiently.
        WE can keep pointers left and right.
        we move right if our sum is < target.
        we move left when sum > target. using left and right, we get our subarray.
         */
        int[] a = new int[]{1, 1000000000};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(solve(a, (int) 1e9));

    }

    public static int[] solve(int[] A, int B) {
        int[] result;
        int n=A.length,p1=0,p2=0,j=0,sum=A[p1];
        while(p2<n) {
            if(sum == B){
                int size = p2-p1+1;
                result = new int[size];
                for (int i = p1; i <=p2 ; i++) {
                    result[j] = A[i];
                    j++;
                }
                return result;
            }
            else if(sum > B){
                sum -= A[p1];
                p1++;
                if(p1>p2 && p1<n-1){
                    p2++;
                    sum += A[p2];
                }
            }else{
                p2++;
                if(p2<n)
                    sum += A[p2];
            }
        }
        result = new int[1];

        result[0] = -1;
        return result;
    }
}
