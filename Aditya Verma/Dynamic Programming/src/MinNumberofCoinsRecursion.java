
public class MinNumberofCoinsRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = new int[] {25};
		int V = 30;
		
		int ans = minCoins(coins, coins.length, V);
		System.out.println("Ans: "+ans);
	}
	
	public static int minCoins(int coins[], int M, int V) 
	{ 
	    int ans = solve(coins, M, V);
	    
	    if(ans>=Integer.MAX_VALUE-1) return -1;
	    else return ans;
	}
	
	static int solve(int coins[], int M, int V) {
		if(M==0 && V!=0) return Integer.MAX_VALUE-1;
	    else if(V==0) return 0;
	    
	    if(coins[M-1] <= V) {
	    	return Math.min(1+solve(coins, M, V-coins[M-1]), 
	    			solve(coins, M-1, V));
	    } else {
	    	return solve(coins, M-1, V);
	    }
	}
 
}
