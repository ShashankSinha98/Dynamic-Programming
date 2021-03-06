
public class NumberOfTimesAStringOccursAsASubsequenceInGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "geeksforgeeks";
		String s2 = "gks";
		
		int ans = countWays(s1, s2);
		System.out.println("Ans: "+ans);
		
		ans = countWaysRecc(s1, s2, s1.length(), s2.length());
		System.out.println("Ans: "+ans);

	}
	
	static int countWays(String S1, String S2) { 
       int m = S1.length();
       int n = S2.length();
       
       int[][] T = new int[m+1][n+1];
       
       for(int i=0; i<=m; i++) T[i][0] = 1;
       
       for(int i=1; i<=m; i++) {
    	   for(int j=1; j<=n; j++) {
    		   
    		   if(S1.charAt(i-1)==S2.charAt(j-1)) {
    			   T[i][j] = T[i-1][j-1] + T[i-1][j];
    		   } else {
    			   T[i][j] = T[i-1][j];
    		   }
    	   }
       }
       
       return T[m][n];
    }
	
	
	static int countWaysRecc(String s1, String s2, int m, int n) {
		
		if((m==0 && n==0) || n==0) return 1;
		if(m==0) return 0;
		
		if(s1.charAt(m-1)==s2.charAt(n-1)) 
			return countWaysRecc(s1, s2, m-1, n-1) + countWaysRecc(s1, s2, m-1, n);
		
		else return countWaysRecc(s1, s2, m-1, n);
	}

}
