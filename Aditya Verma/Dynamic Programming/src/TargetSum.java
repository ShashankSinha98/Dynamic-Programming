// https://leetcode.com/problems/target-sum/
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int MOD = (int)Math.pow(10, 9)+7;
    public int findTargetSumWays(int[] arr, int diff) {
        int n = arr.length;
        int sum=0;
		for(int ai: arr) sum+=ai;
		
		int target = (sum+diff)/2;
		
		if((sum+diff)%2!=0 || sum+diff<0) return 0;
		
		int[][] T = new int[n+1][target+1];
		
		T[0][0] = 1;
		int zeroCount = 0;
		for(int i=1; i<=n; i++) {
			if(arr[i-1]==0) zeroCount++;
			
			T[i][0] = ((int) Math.pow(2, zeroCount))%MOD;
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=target; j++) {
				if(arr[i-1]<=j) {
					T[i][j] = (T[i-1][j-arr[i-1]] + T[i-1][j])%MOD;
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[n][target]%MOD;
    }

}
