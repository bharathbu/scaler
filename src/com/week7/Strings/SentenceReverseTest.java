/**
 * 
 */
package com.week7.Strings;

/**
 * @author Bharath
 *
 */
public class SentenceReverseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "e jrkeymu coklj si vohl slje sxtpf xvak p kicqxoqaof uqwftidoi xixfvqbjey n tpkh ylqllzln ljo gvozwv ";
		System.out.println(solve(A) );

	}
	
	public static String solve(String A) {
		StringBuilder sb = new StringBuilder();
		A = A.trim();
		int n= A.length(),start = -1,end=-1;
		boolean flag = true;
		for(int i=n-1;i>=0;i--) {
			sb.append(A.charAt(i));
		}
		for(int i=0;i<n;i++) {
			if(start == -1 || end == -1) {
				if(sb.charAt(i)==' ') {
					if(i>0) {
						end = i-1;
						sb = reverse(sb,start,end);
						start = -1;
						end = -1;
						flag=true;
					}
				}else if(i==n-1) {
					end = i;
					if(start == -1)
						start = end;
					sb = reverse(sb,start,end);
				}else if(flag) {
					start = i;
					flag=false;
				}
			}
		}
		return sb.toString();
    }
	public static StringBuilder reverse(StringBuilder sb, int start, int end) {
		while(start<end) {
			sb.setCharAt(start, (char) (sb.charAt(start)^sb.charAt(end)));
			sb.setCharAt(end, (char) (sb.charAt(start)^sb.charAt(end)));
			sb.setCharAt(start, (char) (sb.charAt(start)^sb.charAt(end)));
			start++;
			end--;
		}
		return sb;
	}
}
