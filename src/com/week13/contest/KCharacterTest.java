/**
 * k-character trouble
 */
package com.week13.contest;

/**
 * @author Bharath
 *
 */
public class KCharacterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String A = "aabbaa";
		System.out.println(solve1(A, 2));
	}

	public static String solve1(String A, int B) {
		StringBuilder sb = new StringBuilder();
		StringBuilder asb = new StringBuilder();
		int[] alpha = new int[26];
		int n = A.length(), count = 0;
		char temp=0;
		for (int i = 0; i < n; i++) {
			temp = A.charAt(i);
			alpha[temp-'a']++;
			asb.append(temp);
		}

		
		for (int i = 0; i < n; ) {
			n = asb.length();
			count = 1;
			temp = asb.charAt(i);
			if(alpha[temp-'a'] >= B) {
				for (int j = i + 1; (j < (i + B) && j < n); j++) {
					if (temp == asb.charAt(j))
						count++;
					else
						break;
				}
			}
			
			if (count != B) {
				sb.append(temp);
			} else
				i = i + B - 1;
		}

		return sb.toString();		
	}
	
	public static String solve(String A, int B) {
		if (A.length() < B)
			return A;
		else {
			StringBuilder sb = new StringBuilder();
			int n = A.length(), count = 0;
			for (int i = 0; i < n; i++) {
				count = 1;
				for (int j = i + 1; (j < (i + B) && j < n); j++) {
					if (A.charAt(i) == A.charAt(j))
						count++;
					else
						break;
				}
				if (count != B) {
					sb.append(A.charAt(i));
				} else
					i = i + B - 1;
			}
			return solve(sb.toString(), B);
		}
	}

}
