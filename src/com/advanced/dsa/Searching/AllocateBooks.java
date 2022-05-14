/**
 * Allocate Books
 *
 * Problem Description
 * Given an array of integers A of size N and an integer B.
 *
 * The College library has N books. The ith book has A[i] number of pages.
 *
 * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
 *
 * A book will be allocated to exactly one student.
 * Each student has to be allocated at least one book.
 * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * Calculate and return that minimum possible number.
 *
 * NOTE: Return -1 if a valid assignment is not possible.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i], B <= 105
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return that minimum possible number.
 *
 *
 *
 * Example Input
 * A = [12, 34, 67, 90]
 * B = 2
 *
 *
 * Example Output
 * 113
 *
 *
 * Example Explanation
 * There are two students. Books can be distributed in following fashion :
 *
 * 1)  [12] and [34, 67, 90]
 *     Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 * 2)  [12, 34] and [67, 90]
 *     Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
 * 3)  [12, 34, 67] and [90]
 *     Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 *     Of the 3 cases, Option 3 has the minimum pages = 113.
 */
package com.advanced.dsa.Searching;

public class AllocateBooks {

    public static void main(String[] args){
        /*
        Problem statement: Given a fixed number of pages (V),  how many students do we need?
        The problem has the following property, if it the maximum of minimum value of pages allocated to a student is <= V then it is always
        possible to allocate X as the maximum of minimum pages allocated to a student such than X>=V.

        This leads us to a binary search solution.

        Solution :
           simple simulation approach
           intially Sum := 0
           cnt_of_student = 0
           iterate over all books:
                If Sum + number_of_pages_in_current_book > V :
                          increment cnt_of_student
                          update Sum
                Else:
                          update Sum
           EndLoop;

            fix range LOW, HIGH
            Loop until LOW < HIGH:
                    find MID_point
                    Is the number of students required to keep the max number of pages below MID < M?
                    IF Yes:
                        update HIGH
                    Else
                        update LOW
            EndLoop;
         */
        int[] a = new int[]{12, 34, 67, 90};
        //ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(books(a,2));

    }
    public static int books(int[] A, int B) {
        int N = A.length;

        if (B > N) return -1;

        //building start and end for Binary Search
        int start = A[0], end = 0;
        for (int i = 0; i < N; i++) {
            start = Math.max(A[i], start);
            end += A[i];
        }

        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (checkPages(mid, A, B)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean checkPages(int maxpages, int[] A, int students) {
        int sumPages = 0, count = 0;

        for (int i = 0; i < A.length; i++) {
            sumPages += A[i];
            if (sumPages > maxpages) {
                count++;
                sumPages = A[i];
            }
        }
        if (sumPages != 0) count++;

        if (count <= students) {
            return true;
        } else {
            return false;
        }
    }
}
