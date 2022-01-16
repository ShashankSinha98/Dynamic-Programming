
public class CountNoOfSubsetsWithGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= new int[] {1,1,1,1,1};
		int diff = 3;
		int ans = solve(arr,diff,arr.length);
		
		System.out.println("Ans: "+ans);
	}
	
	static int MOD = (int)Math.pow(10, 9)+7;
	
	static int solve(int[] arr, int diff, int n) {
		
		int sum=0;
		for(int ai: arr) sum+=ai;
		
		int target = (sum+diff)/2;
		
		if((sum+diff)%2!=0) return 0;
		
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
