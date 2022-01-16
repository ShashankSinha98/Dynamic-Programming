
public class LongestCommonSubsequenceRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String A = "abc";
		String B = "def";
		
		int ans = longestCommonSubsequence(A, B);
		System.out.println("Ans: "+ans);
	}
	
	static int longestCommonSubsequence(String A, String B) {
		return solve(A, B, A.length(), B.length());
    }
	
	private static int solve(String A, String B, int m, int n) {
		
		if(m==0 || n==0) return 0;
		
		if(A.charAt(m-1) == B.charAt(n-1)) {
			return 1 + solve(A,B,m-1,n-1);
		} else {
			return Math.max(solve(A, B,m-1, n), solve(A, B, m, n-1));
		}
	}

}
