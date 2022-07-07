/**
 * B Closest Points to Origin
 *
 * Problem Description
 * We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
 *
 * Here, the distance between two points on a plane is the Euclidean distance.
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
 *
 *
 *
 * Problem Constraints
 * 1 <= B <= length of the list A <= 105
 * -105 <= A[i][0] <= 105
 * -105 <= A[i][1] <= 105
 *
 *
 *
 * Input Format
 * The argument given is list A and an integer B.
 *
 *
 *
 * Output Format
 * Return the B closest points to the origin (0, 0) in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [
 *        [1, 3],
 *        [-2, 2]
 *      ]
 *  B = 1
 * Input 2:
 *
 *  A = [
 *        [1, -1],
 *        [2, -1]
 *      ]
 *  B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  [ [-2, 2] ]
 * Output 2:
 *
 *  [ [1, -1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 *  So one closest point will be [-2,2].
 * Explanation 2:
 *
 *  The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 *  So one closest point will be [1,-1].
 */
package com.advanced.dsa.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Sort the list of these points with respect to the distance from the origin.
We can do this with the help of a comparator function, which takes two elements of the array as input
and returns which one will be smaller than the other. So basically, it takes care of the comparison process.

After the list is sorted, take the first B elements from the list and create a new list and return it.
Think of calculating the Euclidean distance and storing it efficiently.

Time Complexity - O(N log N)
Space Complexity - O(N)

public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList <ArrayList <Integer>> ans = new ArrayList <ArrayList <Integer>>();
        Collections.sort(A, new Comparator<ArrayList <Integer>>() {
            public int compare(ArrayList <Integer> a, ArrayList <Integer> b) {
                long d1 = (long)a.get(0) * a.get(0) + (long)a.get(1) * a.get(1);
                long d2 = (long)b.get(0) * b.get(0) + (long)b.get(1) * b.get(1);
                if(d1 < d2)return -1;
                else if(d2 < d1)return 1;
                else return 0;
            }
        });
        for(int i = 0; i < B; i++){
            ans.add(A.get(i));
        }
        return ans;
    }
 */
public class BClosestPoints {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = A.size();
        //PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] a) → (long)a[0] * (long)a[0] + (long)a[1] * (long)a[1]));
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing( (Pair p)-> p.distance ));

        for (int i = 0; i < n; i++) {
            int x = A.get(i).get(0);
            int y = A.get(i).get(1);
            long dist = ((long)x*(long)x+(long)y*(long)y);
            Pair pair = new Pair();
            pair.distance = dist;
            pair.coordinates = A.get(i);
            minHeap.offer(pair);
        }

        for (int i = 0; i < B; i++) {
            ArrayList<Integer> coordinates = minHeap.poll().coordinates;
            ans.add(coordinates);
        }
        return ans;
    }

    class Pair{
        long distance;
        ArrayList<Integer> coordinates;

        Pair(){
            distance = 0;
            coordinates = null;
        }
    }
}
