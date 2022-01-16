
public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String A = "";
		int ans = longestRepeatingSubsequence(A);
		System.out.println("Ans: "+ans);
	}
	
	
	private static int longestRepeatingSubsequence(String A) {
		
		int n = A.length();
		int[][] T = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				if(A.charAt(i) == A.charAt(j) && i!=j) {
					T[i][j] = T[i-1][j-1] + 1;
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		
		return T[n][n];
	}

}
