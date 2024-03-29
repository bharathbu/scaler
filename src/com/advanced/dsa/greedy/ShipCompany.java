/**
 * The ship company
 *
 * Problem Description
 * The local ship renting service has a special rate plan:
 *
 * It is up to a passenger to choose a ship.
 * If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
 * The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.
 *
 * You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.
 *
 *
 *
 * Problem Constraints
 * 1 ≤ A ≤ 3000
 * 1 ≤ B ≤ 1000
 * 1 ≤ C[i] ≤ 1000
 * It is guaranteed that there are at least A empty seats in total.
 *
 *
 *
 * Input Format
 * First argument is a integer A denoting the number of passengers in the queue.
 * Second arugument is a integer B deonting the number of ships.
 * Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.
 *
 *
 *
 * Output Format
 * Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 4
 *  B = 3
 *  C = [2, 1, 1]
 * Input 2:
 *
 *  A = 4
 *  B = 3
 *  C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [5, 5]
 * Output 2:
 *
 *  [7, 6]
 *
 *
 * Example Explanation
 * Explantion 1:
 *
 *  Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 *  So, the cost will be 5.
 *  Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
 *  So, the cost will be 5.
 * Explanation 2:
 *
 *  Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 *  So, the cost will be 7.
 *  Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
 *  So, the cost will be 6.
 */
package com.advanced.dsa.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
/*
Make two priority queues, one for taking maximum cost tickets till now and the other for the minimum.

Now for A passengers, pop these two queues separately and take the sum of maximum and minimum answers.
 */
public class ShipCompany {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minH = new PriorityQueue();
        PriorityQueue<Integer> maxH = new PriorityQueue(Collections.reverseOrder());
        int n = C.size();
        for (int i = 0; i < n; i++) {
            int seatsLeft = C.get(i);
            minH.offer(seatsLeft);
            maxH.offer(seatsLeft);
        }
        int minCost = 0, maxCost = 0;
        for (int i = 0; i < A; i++) {
            int seatsLeft = minH.poll();
            minCost += seatsLeft;
            seatsLeft--;
            if(seatsLeft > 0)
                minH.offer(seatsLeft);


            seatsLeft = maxH.poll();
            maxCost += seatsLeft;
            seatsLeft = seatsLeft-1;
            if(seatsLeft > 0)
                maxH.offer(seatsLeft);
        }
        result.add(maxCost);
        result.add(minCost);
        return result;
    }
}
