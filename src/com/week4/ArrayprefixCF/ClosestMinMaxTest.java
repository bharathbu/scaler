/**
 * 
 */
package com.week4.ArrayprefixCF;

/**
 * @author Bharath
 *
 */
public class ClosestMinMaxTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {4,4,4,4,4};
		System.out.println(solve(A));
	}

	public static int solve(int[] A) {
        int n=A.length,lastMin=-1,lastMax=-1,minLength=Integer.MAX_VALUE,length=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        
        for(int i=0;i<n;i++) {
        	if(A[i] == max) {
        		lastMax = i;
        		if(lastMin >=0) {
        			length = lastMax-lastMin+1;
        			if(length < minLength)
        				minLength = length;
        		}
        	}if(A[i] == min) {
        		lastMin = i;
        		if(lastMax >=0) {
        			length = lastMin-lastMax+1;
        			if(length < minLength)
        				minLength = length;
        		}
        	}
        }
        return minLength;
    }
}
