/**
 * The above function performs binary exponentation which returns xn, hence the answer is 210 = 1024.
 */
package com.week9.recursion;

/**
 * @author Bharath
 *
 */
public class PowerFunTest {

	public static int fun(int x,int n) {
		if(n==0)
			return 1;
		else if(n%2 ==0) {
			return fun(x*x,n/2);
		}else {
			return x * fun(x*x,(n-1)/2);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int ans = fun(2,10);
		System.out.println(ans);*/
		System.out.println(pow(0,1,1));		
	}
	public static int pow(int A, int B, int C) {
		//if(A==0) return 0;
		if(B==0) return 1;
		long halfPow = pow(A,B/2,C);
		long halfAns = (((halfPow%C)*(halfPow%C))%C);
		if(B%2==0) return (int) ((halfAns%C+C)%C);
		else return (int) (((halfAns%C*A%C)%C+C)%C);
    }

}
