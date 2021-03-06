
public class SubsetSumProblemTopDown {
	
	public static void main(String... args) {
		int[] arr = new int[] {3, 34, 4, 12, 5, 2};
		int sum = 9;
		boolean ans = isSubsetSum(arr.length, arr, sum);
		System.out.println("Ans: "+ans);
	}
	
	static Boolean isSubsetSum(int N, int arr[], int sum){
        
		boolean[][] T = new boolean[N+1][sum+1];
		
		for(int i=1; i<=sum; i++) T[0][i] = false;
		for(int i=0; i<=N; i++) T[i][0] = true;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=sum; j++) {
				
				if(arr[i-1]<=j) {
					T[i][j] = T[i-1][j-arr[i-1]] || T[i-1][j];
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[N][sum];
    }
}
