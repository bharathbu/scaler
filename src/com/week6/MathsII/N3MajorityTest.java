/**
 * 
 */
package com.week6.MathsII;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bharath
 *
 */
public class N3MajorityTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] A = {1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 
				1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 
				1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 
				1000669, 1000489, 1000727, 1000329, 1000727, 1000050, 1000209, 1000109};
		List<Integer> list = Arrays.asList(A);
		System.out.println(repeatedNumber(list));

	}
	
	public static int repeatedNumber(final List<Integer> a) {
		int result=-1,maj1=-1,freq1=0,maj2=-1,freq2=0,n=a.size();
		for(int i=0;i<n;i++) {
			if(a.get(i) == maj1){
				freq1++;
			}else if(a.get(i) == maj2) {
				freq2++;
			}else if(maj1 == -1) {
				maj1 = a.get(i);
				freq1++;
			}else if(maj2==-1) {
				maj2 = a.get(i);
				freq2++;
			}else {
				freq1--;
				if(freq1 == 0)
					maj1 = -1;
				freq2--;
				if(freq2 == 0)
					maj2 = -1;
			}
		}
		freq1=0;freq2=0;
		for(int i=0;i<n;i++) {
			if(a.get(i) == maj1)
				freq1++;
			else  if(a.get(i) == maj2)
				freq2++;
		}
		if(freq1 >= (n/3)+1)
			result=maj1;
		else if(freq2 >= (n/3)+1)
			result=maj2;
		return result;
	}

}
