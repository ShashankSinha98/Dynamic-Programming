import java.util.*;
public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String X = "ABC";
        String Y = "DEF";
        String ans = getLongestCommonSubsequence(X, Y);
        System.out.println("Ans: "+ans);
	}
	
	static String getLongestCommonSubsequence(String A, String B) {
		
		int m = A.length();
		int n = B.length();
		int[][] T = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
				if(A.charAt(i-1)==B.charAt(j-1)) {
					T[i][j] = 1 + T[i-1][j-1];
				} else {
					T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int i=m, j=n;
		
		while(i!=0 && j!=0) {
			
			if(A.charAt(i-1)==B.charAt(j-1)) {
				sb.append(A.charAt(i-1));
				i--; j--;
			} else {
				if(T[i-1][j]>T[i][j-1]) i--;
				else j--;
			}
		}
		
		return sb.reverse().toString();
	}

}
