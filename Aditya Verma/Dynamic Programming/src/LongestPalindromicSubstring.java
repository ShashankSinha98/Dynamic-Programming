// https://leetcode.com/problems/longest-palindromic-substring/submissions/
// https://www.youtube.com/watch?v=UflHuQj6MVA&t=216s&ab_channel=TECHDOSE
import java.util.*;
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "cbbd";
		String ans = longestPalindrome(s);
		System.out.println("Ans: "+ans);
		
	}
	
	public static String longestPalindrome(String s) {
		
		int n = s.length();
		if(n==0) return "";
		
		int[][] T = new int[n][n];
		
		int mi=0, mj=0;
		
		// fill diagonal
		for(int i=0; i<n; i++) T[i][i] = 1;
		
		// fill for substring of len 2
		for(int i=0; i<n-1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				T[i][i+1] = 2;
				if(2>mj-mi+1) {
					mi = i; mj = i+1;
				}
			}
		}
		
		for(int d=2; d<n; d++) {
			for(int i=0; i<n-d; i++) {
				int j = i+d;
				
				if(s.charAt(i)==s.charAt(j) && T[i+1][j-1]>0) {
					T[i][j] = T[i+1][j-1] + 2;
					
					if(j-i+1>mj-mi+1) {
						mi=i; mj=j;
					}
				} else {
					T[i][j] = 0;
				}
			}
		}
		
		return s.substring(mi, mj+1);
	}
}
