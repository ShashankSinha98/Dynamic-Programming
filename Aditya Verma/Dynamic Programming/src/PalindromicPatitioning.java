import java.util.Arrays;

public class PalindromicPatitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String S = "aaabba";
		int ans = palindromicPartition(S);
		System.out.println("Ans: "+ans);

	}
	
	static int[][] T;
	static int palindromicPartition(String str)
    {
        int i=0, j=str.length()-1;
        T = new int[str.length()][str.length()];
        
        for(int[] a: T)
        	Arrays.fill(a, -1);
        
        return solve(str, i, j);
    }

	private static int solve(String str, int i, int j) {
		
		if(i>=j) return 0;
		
		if(T[i][j]!=-1) return T[i][j];
		
		if(isPallindrome(str, i, j)) return 0;
		
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int tempAns1 = solve(str, i, k);
			int tempAns2 = solve(str, k+1, j);
			
			ans = Math.min(ans, tempAns1+tempAns2+1);
		}
		
		
		return T[i][j] = ans;
	}
	
	private static boolean isPallindrome(String str, int i, int j) {
		
		int ti=i, tj=j;
		
		while(ti<=tj) {
			if(str.charAt(ti)!=str.charAt(tj)) return false;
			
			ti++;
			tj--;
		}
		return true;
	}

}
