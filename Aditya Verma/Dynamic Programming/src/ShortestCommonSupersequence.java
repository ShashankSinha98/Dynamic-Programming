
public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String A = "efgh";
		String B = "jghi";
		
		int ans = shortestCommonSupersequence(A, B, A.length(), B.length());
		System.out.println("Ans: "+ans);
	}
	
	
	public static int shortestCommonSupersequence(String A,String B,int m,int n)
    {
		
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
		
		return m+n-T[m][n];
    }

}
