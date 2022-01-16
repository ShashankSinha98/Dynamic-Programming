
public class MinimumNumberOfDeletionsToMakeStringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	int minDeletions(String str, int n)
    {
        return n-longestPalinSubseq(str);
    }
	
	private static int longestPalinSubseq(String S)
    {
        String B = new StringBuilder(S).reverse().toString();
        
        int m = S.length();
        int n = B.length();
        
        int[][] T = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		
        		if(S.charAt(i-1)==B.charAt(j-1)) {
        			T[i][j] = T[i-1][j-1] + 1;
        		} else {
        			T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
        		}
        	}
        }
        
        return T[m][n];
    }

}
