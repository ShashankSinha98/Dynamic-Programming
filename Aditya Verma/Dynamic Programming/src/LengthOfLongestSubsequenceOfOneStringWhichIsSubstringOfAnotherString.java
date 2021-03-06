
public class LengthOfLongestSubsequenceOfOneStringWhichIsSubstringOfAnotherString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String x = "a";
		String y = "a";
		
		int maxLen = 0;
		for(int i=1; i<=y.length(); i++) {
			int ans = maxSubsequenceSubstring(x, y, x.length(), i);
			maxLen = Math.max(maxLen, ans);
		}
		
		System.out.println("Ans: "+maxLen);
		
		maxLen = maxSubsequenceSubstring2(x, y, x.length(), y.length());
		System.out.println("maxLen: "+maxLen);

	}
	
	static int maxSubsequenceSubstring(String X, String Y, int n, int m) 
    {
        if(n==0 || m==0) return 0;
        
        if(X.charAt(n-1)==Y.charAt(m-1)) {
        	return maxSubsequenceSubstring(X, Y, n-1, m-1) + 1;
        } else {
        	return maxSubsequenceSubstring(X, Y, n-1, m);
        }
    }
	
	static int maxSubsequenceSubstring2(String X, String Y, int n, int m) 
    {
		int[][] T = new int[n+1][m+1];
        int res = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(X.charAt(i-1)==Y.charAt(j-1)) {
		        	T[i][j] = T[i-1][j-1] + 1;
		        	res = Math.max(res, T[i][j]);
		        } else {
		        	T[i][j] = T[i-1][j];
		        }
			}
		}
		
		return res;
    }

}
