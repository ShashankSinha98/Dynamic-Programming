import java.util.Arrays;

public class PrintShortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "aaaaaaaa";
		String s2 = "aaaaaaaa";
		
		String res = shortestCommonSupersequence(s1, s2);
		System.out.println("Res: "+res);
		
	}
	
	public static String shortestCommonSupersequence(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] T = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				
				if(s1.charAt(i-1)==s2.charAt(j-1) ) {
					T[i][j] = T[i-1][j-1]+1;
				} else {
					T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
				}
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		int i=m, j=n;
		while(i!=0 && j!=0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;j--;
			} else {
				if(T[i-1][j]>T[i][j-1]) {
					
					sb.append(s1.charAt(i-1));
					i--;
				} else {
					sb.append(s2.charAt(j-1));
					j--;
				}
			}
		}
		
		sb = sb.reverse();
		
		String res = "";
		if(i!=0) {
			res = s1.substring(0,i) + sb.toString();
		} 
		
		else {
			res = s2.substring(0, j) + sb.toString();
		}
		
		return res;
    }

}
