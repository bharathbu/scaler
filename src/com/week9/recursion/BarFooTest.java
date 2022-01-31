/**
 * Recurrence relation for bar(x,y)
is

bar(x,y)=x+bar(x,y−1)=2x+bar(x,y−2)=…=yx+bar(x,0)=yx

That is bar(x,y)
returns the product of x and y

Now, recurrence relation for foo

is

foo(a,b)=a×foo(a,b−1)=a×a×foo(a,b−2)=…=ab×foo(a,0)=ab×1=ab

The given code returns a^b
 */
package com.week9.recursion;

/**
 * @author Bharath
 *
 */
public class BarFooTest {

	static int bar(int x , int y) {
		if(y==0) return 0;
		return x+bar(x,y-1);
	}
	static int foo(int x,int y) {
		if(y==0) return 1;
		return bar(x,foo(x,y-1));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(foo(3,5));
	}

}
