import java.util.Arrays;

public class BooleanParenthesization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String S = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		int ans = countWays(S.length(), S);
		System.out.println("Ans: "+ans);

	}
	
	static int T[][][];
	static int MOD = 1003;
	static int countWays(int N, String S){
        
		T = new int[N+1][N+1][2]; // 0:F, 1:T
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<2; k++) {
					T[i][j][k] = -1;
				}
			}
		}
		
		return solve(S, 0, N-1, true);
    }
	
	private static int solve(String S, int i, int j, boolean isTrue) {
		
		if(i>j) return 0;
		
		int thirdIdx = isTrue?1:0; 
		
		if(i==j) {
			if(isTrue) return S.charAt(i)=='T'?1:0;
			else return S.charAt(i)=='F'?1:0;
		}
		
		if(T[i][j][thirdIdx]!=-1) return T[i][j][thirdIdx];
			
		int ans = 0;
		for(int k=i+1; k<j; k+=2) {
			
			int LF = (T[i][k-1][0]!=-1)?T[i][k-1][0]:(T[i][k-1][0]=solve(S, i, k-1, false));
			int LT = (T[i][k-1][1]!=-1)?T[i][k-1][1]:(T[i][k-1][1]=solve(S, i, k-1, true));
			int RF = (T[k+1][j][0]!=-1)?T[k+1][j][0]:(T[k+1][j][0]=solve(S, k+1, j, false));
			int RT = (T[k+1][j][1]!=-1)?T[k+1][j][1]:(T[k+1][j][1]=solve(S, k+1, j, true));
			
			if(S.charAt(k)=='&') {
				if(isTrue) ans = (ans + (LT*RT)%MOD)%MOD;
				else ans = (ans + (LF*RF)%MOD + (LT*RF)%MOD + (LF*RT)%MOD)%MOD;
			} else if(S.charAt(k)=='|') {
				if(isTrue) ans = (ans + (RT*LT)%MOD + (LF*RT)%MOD + (LT*RF)%MOD)%MOD;
				else ans = (ans + (LF*RF))%MOD;
			} else if(S.charAt(k)=='^') {
				if(isTrue) ans= (ans+ (LF*RT)%MOD + (LT*RF)%MOD)%MOD;
				else ans= (ans + (LT*RT)%MOD + (LF*RF)%MOD)%MOD;
			}
		}
		
		return T[i][j][thirdIdx]=(ans%MOD);
	}

}
