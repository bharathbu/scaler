package com.advanced.java;

public class StringTest {

    /**
     * Time complexity of this code is O(N2), because every time we append char inside for loop, original string gets cloned to new string
     * @param args
     */
    public static void main(String[] args){
        String str = "abcd";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            str+="A";
        }
        System.out.println(str.length());
    }

}
