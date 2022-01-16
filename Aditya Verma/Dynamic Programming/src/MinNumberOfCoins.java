
public class MinNumberOfCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = new int[] {9, 6, 5, 1};
		int V = 11;
		
		int ans = minCoins(coins, coins.length, V);
		System.out.println("Ans: "+ans);
	}
	
	public static int minCoins(int coins[], int M, int V) 
	{ 
		int[][] T = new int[M+1][V+1];
		
		for(int i=1; i<=V; i++) T[0][i] = Integer.MAX_VALUE-1;
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=V; j++) {
				
				if(coins[i-1]<=j) {
					T[i][j] = Math.min(1+T[i][j-coins[i-1]], 
							T[i-1][j]);
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return (T[M][V]>=Integer.MAX_VALUE-1)?-1:T[M][V];
	}

}
