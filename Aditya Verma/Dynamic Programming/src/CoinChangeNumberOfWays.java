
public class CoinChangeNumberOfWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] coins = new int[] {2,5,3,6};
		int value = 10;
		
		long ans = numberOfWays(coins, coins.length, value);
		System.out.println("Ans: "+ans);
	}
	
	public static long numberOfWays(int coins[],int n,int value)
    {
		long[][] T = new long[n+1][value+1];
		
		for(int i=0; i<=n; i++) T[i][0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=value; j++) {
				
				if(coins[i-1]<=j) {
					T[i][j] = T[i][j-coins[i-1]] + T[i-1][j];
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[n][value];
    }

}
