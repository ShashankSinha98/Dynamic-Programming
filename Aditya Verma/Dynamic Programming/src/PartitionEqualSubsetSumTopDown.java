
public class PartitionEqualSubsetSumTopDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {1, 3, 5};
		int ans = equalPartition(arr.length, arr);
		System.out.println("Ans: "+ans);

	}
	
	static int equalPartition(int N, int arr[])
    {
		int sum = 0;
		for(int ai: arr) {
			sum += ai;
		}
		
		if((sum&1)==1) return 0;
		
		return isSubsetSum(N, arr, sum/2) ? 1:0;
    }
	
	private static Boolean isSubsetSum(int N, int arr[], int sum){
        
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
