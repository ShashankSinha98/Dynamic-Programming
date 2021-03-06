
public class CountPalindromeSubStringsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abaab";
		int ans = CountPS(s, s.length());
		System.out.println("Ans: "+ans);

	}
	
	public static int CountPS(String S, int N)
    {
        boolean[][] T = new boolean[N][N];
        
        int count = 0;
        
        for(int i=0; i<N; i++) T[i][i] = true;
        
        for(int i=0; i<N-1; i++) {
        	if(S.charAt(i)==S.charAt(i+1)) {
        		T[i][i+1] = true;
        		count++;
        	}
        }
        
        for(int d=2; d<N; d++) {
        	for(int i=0; i<N-d; i++) {
        		int j=i+d;
        		
        		if(S.charAt(i)==S.charAt(j) && T[i+1][j-1]) {
        			T[i][j] = true;
        			count++;
        		}
        	}
        }
        
        return count;
    }

}
