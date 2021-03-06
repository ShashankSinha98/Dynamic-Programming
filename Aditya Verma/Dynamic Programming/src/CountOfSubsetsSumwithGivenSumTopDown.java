import java.util.Arrays;

public class CountOfSubsetsSumwithGivenSumTopDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 1};
		int sum = 1;
		int ans = perfectSum(arr, arr.length, sum);
		System.out.println("Ans: "+ans);

	}
	
	static int MOD = (int) ((Math.pow(10, 9))+7);
	
	public static int perfectSum(int arr[],int N, int sum) 
	{ 
		int[][] T = new int[N+1][sum+1];
		
		for(int i=1; i<=sum; i++) T[0][i] = 0;
		int zeroCount = 0;
		T[0][0] = 1;
		for(int i=1; i<=N; i++) {
			if(arr[i-1]==0) zeroCount++;
			T[i][0] = (int) ((Math.pow(2, zeroCount))%MOD);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=sum; j++) {
				
				if(arr[i-1]<=j) {
					T[i][j] = (T[i-1][j-arr[i-1]] + T[i-1][j])%MOD;
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[N][sum]%(MOD);
	} 


}
