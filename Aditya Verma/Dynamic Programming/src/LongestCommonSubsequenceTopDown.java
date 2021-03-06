// https://leetcode.com/problems/longest-common-subsequence/submissions/
public class LongestCommonSubsequenceTopDown {
	
	public static void main(String[] args) {
		String A = "abc";
		String B = "adc";
		
		int ans = longestCommonSubsequence(A, B);
		System.out.println("Ans: "+ans);
	}
	
	static int longestCommonSubsequence(String A, String B) {
		
		int m = A.length();
		int n = B.length();
		int[][] T = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
				if(A.charAt(i-1)==B.charAt(j-1)) {
					T[i][j] = T[i-1][j-1] + 1;
				} else {
					T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				}
			}
		}
		
		return T[m][n];
    }
}
