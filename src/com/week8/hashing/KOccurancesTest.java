/**
 * K Occurrences
 * 
 * Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].

He wants to select some trees to replace his broken branches.

But he wants uniformity in his selection of trees.

So he picks only those trees whose heights have frequency K.

He then sums up the heights that occur K times. (He adds the height only once to the sum and not K times).

But the sum he ended up getting was huge so he prints it modulo 10^9+7.

In case no such cluster exists, Groot becomes sad and prints -1.

Constraints:

1.   1<=N<=100000
2.   1<=K<=N
3.   0<=H[i]<=10^9
Input: Integers N and K and array of size A

Output: Sum of all numbers in the array that occur exactly K times.

Example:

Input:

N=5 ,K=2 ,A=[1 2 2 3 3]
Output:

5
Explanation:

There are 3 distinct numbers in the array which are 1,2,3.
Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.

 */
package com.week8.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bharath
 *
 */
public class KOccurancesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {2,0,1};
		System.out.println(getSum(5,2, A));

	}
	
	public static int getSum(int A, int B, int[] C) {
		int result = 0, n=C.length,curr;
		boolean flag=false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			curr = C[i];
			if(map.get(curr) == null) {
				map.put(curr, 1);
			}else map.put(curr, map.get(curr)+1);
		}
		for ( java.util.Map.Entry<Integer, Integer> entry : map.entrySet() ) {
			if(entry.getValue() == B) {
				flag=true;
				result+=entry.getKey();
			}
		}
		if(flag) {
			result = (int) (result%(Math.pow(10, 9)+7));
		}else {
			result=-1;
		}
		return result;
    }

}
